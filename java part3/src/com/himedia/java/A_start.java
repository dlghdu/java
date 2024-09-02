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
                    likey.highLike();
                    break;
                case 3:
                    likey.selAll();
                    break;
                case 4:
                    likey.deletE();
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
