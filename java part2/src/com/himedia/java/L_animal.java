package com.himedia.java;

public abstract class L_animal {
    // 추상 메서드 : 하위 클래스가 이 메서드를 구현해야 함.
    public abstract void makesound();

    public void breathe() {
        System.out.println("동물은 숨을 쉰다.");
    }



}
