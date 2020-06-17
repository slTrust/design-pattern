package com.design.d14访问者模式.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * 对我们自己的 Tank类不满意
 *  现在通过 asm 织入一些自己的代码
 */
public class ClassTransformerTest2 {
    public static void main(String[] args) throws Exception {
        // 读入 Tank类
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/design/d14访问者模式/asm/Tank.class"));

        // 自己写一个class需要 ClassWriter
        ClassWriter cw = new ClassWriter(0);
        // 自定义了一个 ClassVisitor
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {

            // 访问方法的时候
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                //return mv;
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        //给自定义的Tank类 添加自己定义的功能
                        visitMethodInsn(INVOKESTATIC, "com/design/d14访问者模式/asm/TimeProxy","before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();

        String path = (String)System.getProperties().get("user.dir");
        System.out.println(path);
        File f = new File(path + "/com/design/d14访问者模式/ASM/");
        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/design/d14访问者模式/ASM/Tank_2.class"));
        fos.write(b2);
        fos.flush();
        fos.close();

    }
}
