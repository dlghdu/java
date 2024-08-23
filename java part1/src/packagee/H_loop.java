package packagee;

public class H_loop {
    public static void exam1() {
        for ( int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    public static void exam2() {
        System.out.println("==구구단 2단==");
        for ( int i = 0; i < 10; ++i) {
            System.out.println(" 2 * " + i + " = " + 2 * i);
        }
    }

    public static void exam3() {
        for ( int i = 0; i < 10; ++i) {
            System.out.println("첫번째 for문 : " + i);
            for ( int j = 0; j < 10; ++j) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        exam3();
    }
}
