package com.himedia.java;

// * 정적 메서드
// 클래스 메서드는 자바에서 static 키워드로 선언된 메서드를 의미하며. 이는 정적 메서드라고도 불린다.
// 정적 메서드는 특정 클래스의 인스턴스에 종속되지 않으며, 클래스 자체에 속한다.
// 따라서 객체를 생성하지 않고도 클래스 이름을 통해 직접 호출할 수 있다.
// 클래스 메서드도 클래스변수처럼, 객체를 생성하지 않고 '클래스이름.메서드이름'과 같은 식으로 호출 가능.

// * 주요 특징
// 1. 인스턴스 필요없음
// 2. 정적 변수와 상수만 접근 가능
// 정적 메서드는 다른 정적 멤버(정적 변수 또는 다른 정적 메서드)와만 상호작용할 수 있다.
// 인스턴스 변수나 인스턴스 메서드에는 직접 접근할 수 없다.
// 3. 유틸리티 메서드로 자주 사용
// 자주 사용되거나 공통적인 작업을 수행하는 유틸리티 메서드는 일반적으로 정적 메서드로 구현된다.
// 예를 들어 Math 클래스의 Math.random() 메서드처럼 인스턴스와 관련이 없는 관련이 없는 계산 작업을 수행하는 경우가 많다.

// * 결론
// - 정적 메서드는 클래스에 속하는 메서드로서, 특정 인스턴스와 관계없이 호출할 수 있다.
// - 주로 유틸리티 성격의 메서드나, 클래스 자체의 특성과 관련된 기능을 제공하는 메서들르 정의할 때 사용.
// - 인스턴스 변수를 사용하지 않고, 클래스 차원에서 공통으로 사용할 수 있는 기능을 제공할 때 유용.

public class D_static_method {

    public static void main(String[] args) {
        // add
        // 호출
        // 출력
        double add = D_calc.add(3.4, 1.1);
        System.out.println(add);

        // multi
        // 호출
        // 출력
        double multi = D_calc.multi(2.2, 4);
        System.out.println(multi);

        //circleArea
        // 호출
        // 출력
        double circleArea = D_calc.multi(2.2, 4);
        System.out.println(multi);
        //System.out.println(D_calc.circleArea(4));

    }

}
