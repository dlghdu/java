package benkis;

import java.util.Scanner;

public class Noticeimpl implements Notice {

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---공지---");
        System.out.println("[1]로그인 [2]회원가입 [3]글 목록 보기");
        System.out.println("[4]글 등록 [5]글 수정 [6]글 삭제");
        System.out.println("[7]로그아웃 [8]회원 탈퇴 [9]프로그램 종료");
        return sc.nextInt();
    }
}
