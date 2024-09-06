package GA_GE_BU;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountBookimpl implements AccountBook {

    private String name;
    private int money;
    private int totalMoney;
    private String toDay;
    private String eleMent;


    List<String> list =  new ArrayList<>();

    public AccountBookimpl() {
        this.name = name;
        this.money = money;
        this.toDay = toDay;
        this.eleMent = eleMent;

    }


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
        name = sc.nextLine();
        System.out.println("그 가격을 적으시오");
        money = sc.nextInt();
        list.add(name + " : " + String.valueOf(money) + "원");
        totalMoney += money;


        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println("합계: " + totalMoney + "원");
    }

    @Override
    public void printHistory() {
        toDay = dateTime();
        System.out.println("내역조회");
        for ( int i = 0; i < list.size(); i++) {
            System.out.println(toDay);
            Scanner sc = new Scanner(System.in);
            System.out.println("제목을 입력하십시오.");
            eleMent = sc.nextLine();
            System.out.println(list.get(i) + " : " + eleMent);
        }
    }

    @Override
    public String dateTime() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
        return today.format(formatter);
    }

    @Override
    public void allClear() {
        Scanner sc = new Scanner(System.in);
        System.out.println("제목을 입력하십시오.");
        eleMent = sc.nextLine();
        if (list.contains(eleMent)) {
            System.out.println("존재합니다.");
        } else {
            System.out.println("안존재합니다.");
        }
        System.out.println("삭제 하시겠습니까?");
        String yes = sc.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            list.remove(0);
            totalMoney -= money;
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제하지않았습니다.");
        }
    }

    @Override
    public void neukClear() {
        System.out.println("List size : " + list.size());
    }
}
