package com.himedia.java;

import java.util.Scanner;

public class N_gwaje1 {

    public static final int COKE=500, CIDER=300, FANTA=700, WATER=200;

    public static int totalMoney = 0;

    public static void printMenu() {
        System.out.println("=====자판기=====");
        System.out.println("[1]콜라 500원 [2]사이다 300원 [3]환타 700원 [4]물 200원");
        System.out.println("[5]돈 넣기 [6]반환");
        System.out.println("현재 금액 " + totalMoney + "원");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("무엇을 선택하시겠습니까?");
        return sc.nextInt();
    }

    public static int getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("얼마를 입금하시겠습니까?");
        int money = sc.nextInt();
        totalMoney += money;
        return money;
    }

    public static int gamMoney( int price) {
        return totalMoney - price;
    }

    public static void andae() {
        System.out.println("잔돈이 부족합니다.");
    }

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    if( totalMoney >= COKE ) {
                        totalMoney -= COKE;
                        System.out.println("콜라가 나왔습니다.");
                        System.out.println("남은 돈은 " + totalMoney + "원입니다.");
                    } else {
                        System.out.println("잔돈이 부족합니다.");
                    }
                    break;
                case 2:
                    if( totalMoney >= CIDER ) {
                        totalMoney -= CIDER;
                        System.out.println("사이다가 나왔습니다.");
                        System.out.println("남은 돈은 " + totalMoney + "원입니다.");
                    } else {
                        System.out.println("잔돈이 부족합니다.");
                    }
                    break;
                case 3:
                    int result = gamMoney(FANTA);
                    if( result < 0  ) {
                        andae();
                    } else {
                        System.out.println("환타가 나왔습니다.");
                        totalMoney = result;
                        System.out.println("남은 돈은 " + totalMoney + "원입니다.");
                    }
                    break;
                case 4:
                    int result1 = gamMoney(WATER);
                    if( result1 < 0 ) {
                        andae();
                    } else {
                        System.out.println("물이 나왔습니다.");
                        totalMoney = result1;
                        System.out.println("남은 돈은 " + totalMoney + "원입니다.");
                    }
                    break;
                case 5:
                    getMoney();
                    break;
                case 6:
                    System.out.println(totalMoney + "원이 반환되었습니다.");
                    return;
                default:
                    System.out.println("잘 못 선택하셨습니다.");
                    break;
            }
        }
    }
}
