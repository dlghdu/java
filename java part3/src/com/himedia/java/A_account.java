package com.himedia.java;

public interface A_account {
    void makeaccountMenu();
    String createAccount();
    boolean checkDuplicateNum(int[]accountNums, int tmp, int idx);
    int printMenu();
    void addMoney();
    void manageHistory(String message);
    void printHistory();
    void minusMoney();
    String getNowDateTime();
}
