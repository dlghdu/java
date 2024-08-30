package com.himedia.java;

public interface N_vending {
    int Menu();
    int giveuMoney();
    void setTotalMoney(int totalMoney);
    int getTotalMoney();
    int calc(int price);
    void Refuse();
}
