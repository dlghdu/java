package practice;

public interface acount {
    void printCreateAccountMenu();
    String createAccountNum();
    boolean checkDuplicateNum(int[] accountNums, int tmp, int idx);
    int printMenu();
    void addMoney();
    void minusMoney();
    void manageHistory(String message);
    void printHistory();
    String getNowDateTime();
}
