package benkis;

public class Start {
    public static void main(String[] args) {
        Notice notice = new Noticeimpl();

        while(true) {
            int choice = notice.printMenu();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("잘가");
                    return;
                default:
                    System.out.println("다시");
                    break;
            }
        }
    }
}
