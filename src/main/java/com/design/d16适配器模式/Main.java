package com.design.d16适配器模式;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = (String)System.getProperties().get("user.dir");
        FileInputStream fis = new FileInputStream(path + "/pom.xml");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();

    }
}

