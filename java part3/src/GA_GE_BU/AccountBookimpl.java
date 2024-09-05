package GA_GE_BU;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountBookimpl implements AccountBook {

    private String name;
    private int money;
    private int totalMoney;
    private String today;

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("====가계부====");
        System.out.println("[1]내역 추가 [2]내역 조회 [3]전체 삭제");
        System.out.println("[4]내역 삭제 [5]종료");
        return sc.nextInt();
    }

    @Override
    public void plusNeuk() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매한 품목을 적으시오.");
        String namee = sc.nextLine();
        System.out.println("그 가격을 적으시오");
        int moneyy = sc.nextInt();
        totalMoney += moneyy;
        name += namee;
        money += moneyy;

        System.out.println(namee + ":" + moneyy + "원");
        System.out.println("합계 : " + totalMoney + "원");
    }

    @Override
    public void printHistory() {
        System.out.println("내역조회");

        
    }

    @Override
    public String DateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.now().format(formatter);
    }
}
