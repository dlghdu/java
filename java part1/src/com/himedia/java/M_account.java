package com.himedia.java;

import java.util.Scanner;

public class M_account {

    static int totalmoney = 0;
    static int chul = 0;


    public static int printmenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[메뉴 출력 - 현재 금액 : " + totalmoney + "원" + "]");
        System.out.println("[1]입금 [2]출금");
        System.out.println("[3]내역 조회");
        System.out.println("[4]프로그램 종료");
        return sc.nextInt();
    }

    public static String makban(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====계좌 생성=====");
        System.out.printf("계좌번호 : ");
        for ( int i =0; i < 1; ++i) {

                System.out.println((int) (Math.random() * 89999) + 10000);

        }
        System.out.println("이름 : ");
        return sc.nextLine();
    }

    public static void addmoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("얼마를 입금하시겠습니까?");
        String plus = sc.nextLine();
        System.out.println("입금이 완료 되었습니다.");


        totalmoney = totalmoney + Integer.parseInt(plus);
    }

    public static void minusmoney() {
            Scanner sc = new Scanner(System.in);
            System.out.println("얼마를 출금하시겠습니까?");
            String minus = sc.nextLine();
            totalmoney = totalmoney - Integer.parseInt(minus);
    }



    public static void main(String[] args) {
        makban();
        while (true) {
            int menuNum = printmenu();
            switch (menuNum) {
                case 1:
                    addmoney();
                    break;
                case 2:
                    minusmoney();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘 못 선택하셨습니다.");
                    break;
            }
        }
    }
}
