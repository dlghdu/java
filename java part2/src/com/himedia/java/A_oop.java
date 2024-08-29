package com.himedia.java;

// * 객체지향 프로그래밍(Object-Oriented Programming, OOP)
// 프로그래밍을 여러 개의 객체(object)로 나누어 작성한느 방법을 말한다.
// 객체지향 프로그래밍은 코드의 재사용성과 유집보수성을 높이고,
//복작한 문제를 쉽게 해결할 수 있도록 하는 데 중점을 둔다.

// * class
// 객체를 정의해 놓은 것.
// 클래스는 객체를 생성하는데 사용.
// 객체의 특징을 정의함.

// * 객체
// 실제로 존재하는 것. 사물 또는 객체.

// * 인스터스
// 클래스로부터 객체를 만드는 과정을 클래스의 인스터스라고 하며,
// 어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 한다.
// 클래스 --(인스턴스화) --> 인스턴스(객체)

public class A_oop {

    public static void main(String[] args) {
        A_tv tvtv= new A_tv();
        tvtv.getColor();
        tvtv.power();
        tvtv.volumeUp();
        tvtv.volumeDown();
        tvtv.channelUp();
        tvtv.channelDown();
    }

}
