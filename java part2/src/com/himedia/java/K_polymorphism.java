package com.himedia.java;

// * 다형성(polymorphism)
// 동일한 인터페이스나 부모 클래스를 공유하는 여러 객체들이 각자 다른 방식으로 동작하도록 할 수 있는 기능.
// 다형성은 "하나의 인터페이스로 여러 형태의 객체를 처리할 수 있다."는 의미를 가지고 있다.
// 이를 통해 코드의 유연성과 확장성을 크게 향상 시킬 수 있다.

public class K_polymorphism {

    public static void main(String[] args) {
        K_animal animal = new K_animal();
        K_animal myDog = new K_dog(); // Dog 타입의 객체, Animal타입으로 업캐스팅
        K_animal myCat = new K_cat(); // Cat 타입의 객체, Animal타입으로 업캐스팅

        animal.sound();
        animal.action();
        myDog.sound();
        myDog.action();
        myCat.sound();
        myCat.action();
        System.out.println("\n");

        K_animal ani1 = myDog; // 업캐스팅이 이건가?
        K_animal ani2 = myCat; // 맞나?

        // 다운 캐스팅을 통해 다시 Dog타입로 변환

        if (ani1 instanceof K_dog) {
            K_dog myDog2 = (K_dog) ani1;
            myDog2.sound();
            myDog2.action();
        } else {
            System.out.println("안되네");
        }
        if (ani2 instanceof K_cat) {
            K_cat myCat2 = (K_cat) ani2;
            myCat2.sound();
            myCat2.action();
        } else {
            System.out.pr;
        }
        // 과제 :Exception in thread "main" java.lang.ClassCastException: class com.himedia.java.K_animal cannot be cast to class com.himedia.java.K_dog (com.himedia.java.K_animal and com.himedia.java.K_dog are in unnamed module of loader 'app')
        //	at com.himedia.java.K_polymorphism.main(K_polymorphism.java:20)
        // 이거 왜 안되는지 알아보기 [과제]
    }

}

// 이것이 다형성이다. 하나의 타입으로 다양하게 표현할 수 있는 것.
