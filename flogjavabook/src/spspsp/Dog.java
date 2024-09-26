package spspsp;

public class Dog extends Animal {

    @Override
    AnimalToy getToy() {
        return new dogToy();
    }
}
