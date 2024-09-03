package com.himedia.java;

// * enum(열거형)
// 자바에서 특정한 상수 집합을 정의하는데 사용되는 특별한 데이터 타입이다.

public class B_num {

    public static void exam1() {
        B_day today = B_day.TUESDAY;
        System.out.println(B_day.TUESDAY.ordinal());
        System.out.println(B_day.TUESDAY.name());
        switch (today) {
            case MONDAY:
                System.out.println("MONDAY");
                break;
            case TUESDAY:
                System.out.println("TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("THURSDAY");
                break;
            case FRIDAY:
                System.out.println("FRIDAY");
                break;
            case SATURDAY:
                System.out.println("SATURDAY");
                break;
            case SUNDAY:
                System.out.println("SUNDAY");
                break;
        }
    }
    
    public static void exam2() {
        // 모든 값을 순회
        for (B_day_2 day : B_day_2.values()) {
            System.out.println(day.ordinal() + " : " + day.name() + " : " + day.getDescription());
        }
    }

    public static void main(String[] args) {
        exam1();
    }
}
