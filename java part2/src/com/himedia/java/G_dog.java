package com.himedia.java;

public class G_dog extends G_animal {
    
    public void bark() {
        System.out.println(name + " is barking");
    }

    @Override // 언텐션인가 언테이션인가 뭔가 오버라이딩해서 재정의 하겠다는 뜻
    public void walk() {
        System.out.println("우당탕탕~");
    }
}
