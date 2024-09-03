package com.himedia.java;

import java.util.Scanner;

public class N_2_gwaje2 {
    public static int totalCnt = 0;
    public static int totalMemberCnt = 0;

    public static int pricePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("요금제를 선택하세요.");
        System.out.println("[1]Lite: 10명 [2]Basic: 20명 [3]Premium: 30명");
        return sc.nextInt();
    }

    public static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===메뉴 출력===");
        System.out.println("현재 회원 수 " + totalMemberCnt + "/" + totalCnt);
        System.out.println("[1]회원추가 [2]회원조회(이름) [3]회원조회(이메일)");
        System.out.println("[4]회원조회(전체) [5]회원정보수정 [6]회원삭제");
        System.out.println("[7]프로그램 종료");
        return sc.nextInt();
    }

    public static void addmembers(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력하세요.");
        String email = sc.nextLine();
        System.out.println("연락처를 입력하세요.");
        String phone = sc.nextLine();

        members[totalMemberCnt][0] = name;
        members[totalMemberCnt][1] = email;
        members[totalMemberCnt][2] = phone;
        totalMemberCnt++;
    }

    public static void checkName(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();

        boolean flag = true;
        for ( int i = 0; i < totalMemberCnt; i++) {
            if (name.equals(members[i][0])) {
                System.out.println("[이름]" + members[i][0] + ",[이메일]" + members[i][1] + ",[연락처]" + members[i][2]);
                return;
            }
                System.out.println("찾는 정보가 없습니다.");
        }
    }

    public static void checkEmail(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이메일을 입력하세요.");
        String email = sc.nextLine();

        boolean flag = true;
        for ( int i = 0; i < totalMemberCnt; i++) {
            if (email.equals(members[i][0])) {
                System.out.println("[이름]" + members[i][0] + ",[이메일]" + members[i][1] + ",[연락처]" + members[i][2]);
                return;
            }
            System.out.println("찾는 정보가 없습니다.");
        }
    }

    public static void allCheck(String[][] members) {



        for ( int i = 0; i < totalMemberCnt; i++) {
                System.out.println("[이름]" + members[i][0] + ",[이메일]" + members[i][1] + ",[연락처]" + members[i][2]);
        }

    }

    public static void main(String[] args) {
        int pricePlanNum = pricePlan();
        String[][] members = new String[pricePlanNum * 10][3];
        totalCnt = pricePlanNum * 10;

        while(true) {
            int menuNum = printMenu();
            switch (menuNum) {
                case 1:
                    addmembers(members);
                    break;
                case 2:
                    checkName(members);
                    break;
                case 3:
                    checkEmail(members);
                    break;
                case 4:
                    allCheck(members);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘 못 선택하셨습니다.");
                    break;
            }
        }
    }
}
