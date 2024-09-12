package practice;

import com.himedia.java.A_accountimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class accountmt implements acount {

    public static final int  ACCOUNT_MAX_LENGTH = 5;

    private String userName;
    private String userAccount;
    private int totalMoney = 0;
    private List<String> histories;

    public accountmt() {
        histories = new ArrayList<>();
    }

    @Override
    public void printCreateAccountMenu() {
        System.out.println("===========계좌 생성===========");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");

        userName = sc.nextLine();
        userAccount = createAccountNum();

        System.out.println("계좌가 생성되었습니다. [이름] " + userName + ", [계좌번호] " + userAccount);
    }

    @Override
    public String createAccountNum() {
        StringBuilder sb = new StringBuilder();
        int[] accountNums = new int[ACCOUNT_MAX_LENGTH];
        int idx = 0;

        while (idx < ACCOUNT_MAX_LENGTH) {
            int tmp = (int)(Math.random() * 10);

            if ( idx == 0 && tmp == 0 ) continue;
            if ( idx > 0 && checkDuplicateNum(accountNums, tmp, idx) ) continue;

            accountNums[idx++] = tmp;
        }

        for ( int accountNum : accountNums ) {
            sb.append(accountNum);
        }

        return sb.toString();
    }

    @Override
    public boolean checkDuplicateNum(int[] accountNums, int tmp, int idx) {
        for (int i = 0; i < idx; i++) {
            if (tmp == accountNums[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============ 메뉴 ============");
        System.out.println("[계좌번호] : " + userAccount + ", [이름] " + userName);
        System.out.println("[1]입금 [2]출금 [3]내역조회 [4]프로그램 종료");
        System.out.println("현재금액 = " + totalMoney + "원");
        System.out.println("원하시는 메뉴를 선택하세요.");

        return sc.nextInt();
    }

    @Override
    public void addMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금할 금액을 입력하세요.");
        int getMoney = sc.nextInt();
        totalMoney += getMoney;

        // 히스토리 추가
        String historyMessage= "[입금] " + getMoney + "원 ";
        manageHistory(historyMessage);
    }

    @Override
    public void minusMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("출금할 금액을 입력하세요.");
        int minusMoney = sc.nextInt();
        if (minusMoney > totalMoney) {
            System.out.println("출금할 금액이 부족합니다.");
        }
        totalMoney -= minusMoney;

        // 히스토리 추가
        String historyMessage= "[출금] " + minusMoney + "원 ";
        manageHistory(historyMessage);
    }

    @Override
    public void manageHistory(String message) {
        histories.add(message + " - " + getNowDateTime());
    }

    @Override
    public void printHistory() {
        System.out.println("======== 내역조회 ========");
        histories.sort(Comparator.reverseOrder());
        for ( String h : histories ) {
            System.out.println(h);
        }
    }

    @Override
    public String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
