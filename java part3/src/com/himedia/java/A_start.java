package com.himedia.java;

public class A_start {

    public static void main(String[] args) {
        A_review likey = new A_reviewimpl();

        while(true) {
            int menuNum = likey.printMenu();
            switch(menuNum) {
                case 1:
                    likey.plusMent();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("잘가");
                    return;
                default:
                    System.out.println("다시");
                    break;
            }
        }
    }

}
