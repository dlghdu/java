package com.himedia.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D_1_inoutput_streammm {

    private String desktopPath;
    private String folderPath;
    private Path folfol;



    public static void exam1() {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        String folderPath = desktopPath + File.separator + "데스크탑";
        Path folfol = Paths.get(folderPath);
        try {
            if ( Files.notExists(folfol)) {
                Files.createDirectory(folfol);
                System.out.println("데스크탑 폴더가 생성되었습니다.");
            } else {
                System.out.println("폴더가 이미 존재합니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exam2() {

    }

    public static void main(String[] args) {
        D_1_inoutput_streammm dem =  new D_1_inoutput_streammm();
        exam1();
    }
}
