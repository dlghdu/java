package com.himedia.java;

//계좌 생성. 계좌번호 이름
// -> Math.random 계좌 번호 생성 -> 0~9 사이의 수로 조합된 5자리로 제한, 중복 숫자 없도록... 앞자리 0 안됨
//메뉴 출력
//입금
//출금
//현재 금액 조회
//내역 조회 -> 최근 5개만 보이게. 5개가 꽉 찼다면 가장 오래된 내역은 사라지게.
//입금 500원 * 입금일자(Localdatetime)찾아볼것 2024-08-27 11:33:59 느김대로
//출금도 동일
//프로그램 종료

import java.util.Scanner;

public class M_account {

    public static String neName;
    public static String banacut;
    public static int totalmoney = 0;


    public static void makban(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====계좌 생성=====");
        System.out.println("이름 입력");

        neName = sc.nextLine();

        System.out.println("계좌번호 : " + banacut + "\n이름 : " + neName);
    }



    public static int printmenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[메뉴 - 현재 금액 : " + totalmoney + "원" + "]");
        System.out.println("계좌번호 :" + banacut + ", 이름 :" + neName);
        System.out.println("[1]입금 [2]출금");
        System.out.println("[3]내역 조회");
        System.out.println("[4]프로그램 종료");
        return sc.nextInt();
    }



    public static void addmoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("얼마를 입금하시겠습니까?");
        int plus = sc.nextInt();
        System.out.println("입금이 완료 되었습니다.");
        totalmoney += plus;
    }

    public static void minusmoney() {
            Scanner sc = new Scanner(System.in);
            System.out.println("얼마를 출금하시겠습니까?");
            int minus = sc.nextInt();
            if ( minus > totalmoney ) {
                System.out.println("잔액부족");
                return;
            }
            totalmoney -= minus;
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
