package practice.SOLID.SRP;

public class solidsrp {
    public static void main(String[] args) {

    }


        abstract class dog {
            abstract void pee();
        }

        class male extends dog {
            @Override
            void pee() {
                System.out.println("한 다리 들고");
            }
        }

        class female extends dog {
            @Override
            void pee() {
                System.out.println("앉고");
            }
        }

}
