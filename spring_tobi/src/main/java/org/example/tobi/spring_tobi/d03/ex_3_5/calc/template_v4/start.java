package org.example.tobi.spring_tobi.d03.ex_3_5.calc.template_v4;

import java.io.File;
import java.io.IOException;

public class start {
    public static void main(String[] args) throws IOException {
        start start = new start();
        start.sumOfNumbers();
        start.multiplyOfNumbers();
    }

    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();

        String userHome = System.getProperty("user.home");
        String desktop = userHome + File.separator + "Desktop"; // 이렇게 하면 컴퓨터가 뭐든 알아서 가져옴.
        String filepath = desktop + File.separator + "java" + File.separator + "numbers.txt";

        int sum = calculator.calcSum(filepath);

        System.out.println(sum);

    }

    public void multiplyOfNumbers() throws IOException {
        Calculator calculator = new Calculator();

        String userHome = System.getProperty("user.home");
        String desktop = userHome + File.separator + "Desktop"; // 이렇게 하면 컴퓨터가 뭐든 알아서 가져옴.
        String filepath = desktop + File.separator + "java" + File.separator + "numbers.txt";

        int multiply = calculator.calcMultiply(filepath);

        System.out.println(multiply);

    }

}
