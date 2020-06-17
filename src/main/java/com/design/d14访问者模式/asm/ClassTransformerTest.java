package com.design.d14访问者模式.asm;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 复制一份Tank类代码
 */
public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        // 读入 Tank类
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/design/d14访问者模式/asm/Tank.class"));

        // 自己写一个class需要 ClassWriter
        ClassWriter cw = new ClassWriter(0);

        cr.accept(cw, 0);
        byte[] b2 = cw.toByteArray(); // 这里就是 把原来的 Tank类 copy了一份

        String path = (String)System.getProperties().get("user.dir");
        File f = new File(path + "/com/design/d14访问者模式/ASM/");
        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/design/d14访问者模式/ASM/Tank_1.class"));
        fos.write(b2);
        fos.flush();
        fos.close();

    }
}
