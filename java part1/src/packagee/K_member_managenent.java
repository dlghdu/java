package packagee;

import java.util.Scanner;

public class K_member_managenent {

    public static int printPricePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("요금제를 선택하세요.");
        System.out.println("[1]일반 : 5명 [2]고급 : 3명 [3]최고급 : 1명");
        return sc.nextInt();
    }

    public static int printmmenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[수행할 업무를 선택하세요]");
        System.out.println("[1] 회원 추가 [2] 회원 정보 [3] 전체 조회");
        System.out.println("[4] 회원 정보 수정 [5] 회원 삭제 [6] 프로그램 종료");
        return sc.nextInt();
    }

    public static void main(String[] args) {

    }
}
