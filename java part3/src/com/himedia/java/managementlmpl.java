package com.himedia.java;

import java.util.*;

public class managementlmpl implements Member {

    @Override
    public void paySys() {
        Map<String, Integer> pay = new HashMap<>();
        pay.put("[1]Lite", 10);
        pay.put("[2]Basic", 20);
        pay.put("[3]Primium", 30);
        pay.put("[4]Freepass", 40);
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[=====[회원관리프로그램=====]");
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]전체조회 [5]회원정보수정 [6]회원삭제");
        System.out.println("[7]요금제변경 [8]초기화 [9]프로그램종료");
        System.out.println("원하시는 메뉴를 선택하세요.");
        return sc.nextInt();
    }

    @Override
    public void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력해주세요.");
        String email = sc.nextLine();
        System.out.println("연락처를 연럭해주세요.");
        int phone = sc.nextInt();
    }

    @Override
    public void checkEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("이메일을 입력하세요.");
    }

    @Override
    public void checkName() {
        System.out.println("이름을 입력하세요.");

    }

    @Override
    public void checkAll() {

    }
}
