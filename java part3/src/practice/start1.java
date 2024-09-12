package practice;

public class start1 {

    public static void main(String[] args) {
        acount bank = new accountmt();
        bank.printCreateAccountMenu();

        while(true) {
            int choice = bank.printMenu();
            switch(choice) {
                case 1:
                    bank.addMoney();
                    break;
                case 2:
                    bank.minusMoney();
                    break;
                case 3:
                    bank.printHistory();
                    break;
                case 4:
                    System.out.println("안녕히 가십시오");
                    return;
            }
        }
    }

}
