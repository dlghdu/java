package com.himedia.java;

import java.util.Scanner;

public class N_machine implements N_vending {
    private int totalMoney = 0;

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===자판기===");
        System.out.println("[1]콜라-100 [2]사이다-200 [3]환타-300 [4]물-400 \n [5]돈 넣기 [6]반환");
        System.out.println("현재 금액 :" + totalMoney + " 원");
        System.out.println("아래에 원하는 메뉴를 선택하세요.");
        return sc.nextInt();
    }

    @Override
    public int giveuMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("돈을 넣어주세요.");
        return sc.nextInt();
    }

    @Override
    public int calc(int price) {
        return totalMoney - price;
    }

    @Override
    public void Refuse() {
        System.out.println("돈이 부족합니다.");
    }
}
