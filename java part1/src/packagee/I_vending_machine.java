package packagee;

import java.util.Scanner;

public class I_vending_machine {

    static final int  COKE = 500, CIDER = 400, FANTA = 200, WATER=100;

    public static void printmenu(int totalMoney) {
        System.out.println("=============자판기===========");
        System.out.println("[1]콜라-500원 [2]사이다-400원 [3]환타-200원 [4]물-100원");
        System.out.println("[5]돈넣기 [6]반환");
        System.out.println("현재 금액 : " + totalMoney + "원");
        System.out.println("=============================");
    }

    public static int getchoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 메뉴를 선택하시오 -> ");
        return sc.nextInt();
    }

    public static int getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 만큼 넣어주세요. -> ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        int totalMoney = 0;

        while(true) {
            printmenu(totalMoney);
            int mychoice = getchoice();
            switch (mychoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    totalMoney += getMoney();
                    break;
                case 6:
                    System.out.printf("잔돈 : %d원이 반환되었습니다.", totalMoney);
                    return;
                default:
                    System.out.printf("잘 못 누르셨습니다.");
            }
        }
    }
}
