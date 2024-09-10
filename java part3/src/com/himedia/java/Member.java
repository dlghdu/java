package com.himedia.java;

public interface Member {
    void printPricePlan();
    int printMenu();
    void addMember();
    boolean checkEmail(String email);
    void selectEmail();
    void selectName();
    void selectAll();
    void updateMember();
    void deleteMember();
    void updatePricePlan(int planNum);
    void initMember();
}
