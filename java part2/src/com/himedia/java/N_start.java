package com.himedia.java;

// * static 오직 main. 그 외 X 상수 사용에서는 O
//
//vending.class(interface) -> 자판기 기능에 해당하는 모든 메서드 명세
//machine -> 인터페이스에 명세된 메서드 구현
//	-> 필드는 모두 private
//	-> 필드 값 제어는 getter, setter
//	-> setter에 유효성 체크 추가
//start -> 오직 while문 siwtch-case문만 가진다.
//	-> 다형성을 적용하여 생성한다.
//
//모든 기능은 이전에 만들었던 자판기와 동일

public class N_start {

    static final int COKE=100, CIDER=200, FANTA=300, WATER=400;

    public static void main(String[] args) {
        N_vending maSim = new N_machine();

        while(true) {
            int menuNum = maSim.Menu();
            switch (menuNum) {
                case 1:
                    int result = maSim.calc(COKE);
                    if( result < 0 ) {
                        maSim.Refuse();
                    } else {
                        maSim.setTotalMoney(result);
                        System.out.println("제로콜라가 나왔습니다.");
                    }
                    break;
                case 2:
                    result = maSim.calc(CIDER);
                    if( result < 0 ) {
                        maSim.Refuse();
                    } else {
                        maSim.setTotalMoney(result);
                        System.out.println("사이다가 나왔습니다.");
                    }
                    break;
                case 3:
                    result = maSim.calc(FANTA);
                    if( result < 0 ) {
                        maSim.Refuse();
                    } else {
                        maSim.setTotalMoney(result);
                        System.out.println("환타가 나왔습니다.");
                    }
                    break;
                case 4:
                    result = maSim.calc(WATER);
                    if( result < 0 ) {
                        maSim.Refuse();
                    } else {
                        maSim.setTotalMoney(result);
                        System.out.println("물 나왔습니다.");
                    }
                    break;
                case 5:
                    int mmMoney = maSim.getTotalMoney();
                    int mMoney = maSim.giveuMoney();
                    maSim.setTotalMoney(mmMoney + mMoney);
                    break;
                case 6:
                    System.out.printf("잔돈 : %d원이 반환되었습니다.", maSim.getTotalMoney());
                    return;
                default:
                    System.out.println("다시 입력해주십시오.");
                    break;
            }
        }
    }
}
