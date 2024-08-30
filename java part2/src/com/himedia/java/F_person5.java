package com.himedia.java;

public class F_person5 {

    String name;
    int age;

    public F_person5() {
        // 반드시 첫 줄에 생성자 호출이 와야한다.
        // 예) System.out.println();로 시작하면 에러
        this("jhon", 14);
        // this로 호출해야 한다.
        // 예) F_person5("jhon", 14); 안됌
        System.out.println(name + " : " + age);
    }

    public F_person5(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
