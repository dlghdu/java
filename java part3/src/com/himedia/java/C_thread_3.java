package com.himedia.java;

// * 싱글 스레드와 멀티스레드
// 두 개의 작업을 하나의 스레드로 처리하는 경우와 두 개의 스레드로 처리하는 경우,
// 하나의 스레드로 두 작업을 처리하는 경우는 한 작업을 마친 후에 다른 작업을 시작하지만
// 두 개의 스레드로 작업 하는 경우는 짧은 시간동안 2개의 스레드가 번갈아 가면서 작업을 수행해서
// 동시에 두 작업이 처리되는 것과 같이 느끼게 한다.
// 하나의 스레드로 두개의 작업을 수행한 시간과 두개의 스레드로 두 개의 작업을 수행한 시간은 거의 같다.
// 오히려 두 개의 스레드로 작업한 시간이 싱글스레드로 작업한 시간보다 더 걸리게 되는데
// 그 이유는 스레드간의 작업전환(Context Switching)에 시간이 걸리기 때문이다.
// 그래서 싱글 코어에서 단순히 cpu만을 사용하는 계산작업이라면 오히려 멀티스레드보다
// 싱글스레드 프로그래밍하는 것이 더 효율적이다.

class C_ThreadEx_time extends Thread {
    @Override
    public void run() {
        super.run();
    }
}

public class C_thread_3 {

    static long startTime = 0;

    public void exam1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 300; ++i) {
            System.out.printf("%s", new String("-"));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("소요시간 1 : " + (endTime - startTime) + "ms");
        for (int i = 0; i < 300; ++i) {
            System.out.printf("%s", new String("|"));
        }
    }

    public static void main(String[] args) {
        
    }
}
