package com.himedia.java;

import java.util.Scanner;

public class K_member_managenent {

    static int totalCnt = 0;
    static int totalMemberCnt = 0;

    // 요금제
    public static int printPricePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[요금제를 선택하세요.}");
        System.out.println("[1}Lite : 10명 [2]Basic : 20명 [3]Premium : 30명");

        return sc.nextInt();
    }

    public static int printmenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[수행할 업무를 선택하세요 - 현재 회원수 " + totalMemberCnt + "/" + totalCnt +"]");
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]전체조회 [5]회원정보 수정 [6]회원삭제");
        System.out.println("[7]프로그램 종료");

        return sc.nextInt();
    }

    public static void addMember(String[][] members) {
        // 예외처리1
        // 인원수 예외처리를 해주세요.
        // 인원이 초과되었으면,... "회원이 꽉 찼습니다."를 출력하고
        // addMember함수를 종료시켜주세요.
        // return;
        if( totalMemberCnt >= totalCnt ) {
            System.out.println("회원이 꽉 찼습니다.");
            return;
        }


        // 사용자로부터 이름, 이메일, 연락처
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력하세요.");
        String email = sc.nextLine();
        System.out.println("연락처를 입력하세요.");
        String phone = sc.nextLine();

        // 예외처리2
        // 이메일 체크 필요
        if ( checkEmail(members, email)) {
            System.out.println("이미 존재하는 회원입니다.");
            return;
        }

        // members에 넣어주세요.
        members[totalMemberCnt][0] = name;
        members[totalMemberCnt][1] = email;
        members[totalMemberCnt][2] = phone;
    }

    public static boolean checkEmail(String[][] members, String email) {
        // 회원존재하면 true, 존재하지않으면 false
        // 로직 수현...
        for( int i = 0; i < members.length; i++ ) {
            if(email.equals(members[i][1])) {
                return true;
            }
        }
        return false;
    }

    public static void selectEmail(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이메일을 입력하세요.");
        String email = sc.nextLine();

        // 사용자를 찾았을 경우
        // 출력 : [이름] 홍길동, [이메일] abc@ddwod.com [연락처]010-1234-2131
        //로직
        for( int i = 0; i < members.length; i++ ) {
            if(email.equals(members[i][1])) {
                System.out.println("[이름] " + members[i][0] + ", [이메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                return;
            }

        }
            // 사용자를 찾지 못했을 경우
            System.out.println("찾으시는 정보가 없습니다.");
    }

    public static void selectname(String[][] members) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        // 로직 구현
        // 이름은 중복이 허용된다.
        // 다 출력해야 된다.
        // ** 고민포인트 : 1번이라도 찾았다는 것을 인지할 수 있는 어떠한 flag값이 필요하다.
        boolean flag = false;
        for( int i = 0; i < members.length; i++ ) {
            if(name.equals(members[i][0])) {
                System.out.println("[이름] " + members[i][0] + ", [이메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                flag = true;
            }
        }
        if(!flag) {
            System.out.println("찾으시는 정보가 없습니다.");
        }
    }

    public static void selectAll(String[][] members) {
        // 전체조회
        // 값이 들어있는 친구들만 넘버링해서 출력해주세요.
        // 예) System.out.println(" 1. [이름] 홍길동, [이메일] abc@ddwod.com [연락처]010-1234-2131");
        for( int i = 0; i < totalMemberCnt; ++i) {
            System.out.println((i + 1) +", [이름] " + members[i][0] + ", [이메일] " + members[i][1] + ", [연락처] " + members[i][2]);

        }

    }

    public static void updateMember(String[][] members) {
        // 1. 이메일 조회 -> 사용자로부터 이메일을 받아온다.
        // 2. 조회
        // 3. 찾았으면(=인덱스(쉽게말해행) 해당 인덱스값을 가지고 있는다.
        // 3-1 찾지 못했으면 "찾으시는 회원이 없습니다."를 출력 후 updateMember 함수 종료.
        // 4. 새로운 이름, 이메일, 연락처 입력받는다.
        // 5. 찾은 인덱스에 값을 갱신시켜준다.
        Scanner sc = new Scanner(System.in);
        System.out.println("[수정] 이메일을 입력하세요.");
        String email = sc.nextLine();
        int idx = -1;

        for( int i = 0; i < members.length; i++ ) {
            if(email.equals(members[i][1])) {
                idx = i;
                break;
            }
        }

        if( idx == -1 ) {
            System.out.println("찾으시는 회원이 없습니다.");
            return;
        }

        // 해당 행에 속한 회원 정보를 갱신
        System.out.println("변경할 이름을 입력하세요");
        String newName = sc.nextLine();
        System.out.println("변경할 이메일을 입력하세요");
        String newEmail = sc.nextLine();
        System.out.println("변경할 연락처를 입력하세요");
        String newPhone = sc.nextLine();

        members[idx][0] = newName;
        members[idx][1] = newEmail;
        members[idx][2] = newPhone;

        System.out.println("수정이 완료되었습니다.");

    }

    public static void deleteMember(String[][] members) {
        // 1. 이메일로 삭제할 회원을 찾는다.
        // 2. 찾았으면 찾은 행정보(인덱스 값을 별도로 가지고 있는다.
        // 2-1. 찾지 못했으면 안내 문구를 출력 후 종료 시킨다.
        // 3. 찾은 행 뒹의 행들을 모두 땡긴 후, 마지막 행은 NULL처리한다.
        // 4. 전체 회원수도 차감 시킨다. 0인 경우에는 실행 하지마오.
        Scanner sc = new Scanner(System.in);


    }

    public static void main(String[] args) {
        // 사용자로부터 요금제 선택을 받아서
        // 해당 크기에 맞는 2차원 배열을 생성해주세요.
        // 단, 열은 3열로 고정한다.
        // 배열명 : members
        int pricePlanNum = printPricePlan();
        String[][] members = new String[pricePlanNum * 10][3];
        totalCnt = pricePlanNum * 10;

        while (true) {
            // 7번 프로그램 종료를 완성시켜주세요.
            // "이용해주셔서 감사합니다."
            int menunum = printmenu();

            switch (menunum) {
                case 1:
                    addMember(members);
                    break;
                case 2:
                    selectEmail(members);
                    break;
                case 3:
                    selectname(members);
                    break;
                case 4:
                    selectAll(members);
                    break;
                case 5:
                    updateMember(members);
                    break;
                case 6: // 과제 delete 원하는 부분 없애고 나머지에서 땡겨서 맨 위를 비게 만드는 행위.
                    deleteMember(members);
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
