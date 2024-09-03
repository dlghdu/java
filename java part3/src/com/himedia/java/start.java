package com.himedia.java;

public class start {

    public static void main(String[] args) {
        Member mem = new managementlmpl();
        mem.paySys();
        while (true) {
            int menuNum = mem.printMenu();
            switch (menuNum) {
                case 1:
                    mem.addMember();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    mem.paySys();
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("안녕히 가십시오");
                    return;
            }
        }
    }
}
