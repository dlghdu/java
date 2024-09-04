package com.himedia.java;

public class A_start3 {

    public static void main(String[] args) {
        A_account bank = new A_accountimpl();
        bank.makeaccountMenu();

        while(true) {
            int choice = bank.printMenu();
            switch(choice) {
                case 1:
                    bank.addMoney();
                    break;
                case 2:
                    bank.minusMoney();
                    break;
                case 3:
                    bank.printHistory();
                    break;
                case 4:
                    System.out.println("안녕히 가십시오.");
                    return;
                default:
                    System.out.println("잘못 선택 하셨 습니 다.");
                    break;

            }
        }
    }
}
