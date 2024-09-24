package org.example.tobi.spring_tobi.d03.ex_3_5.calc.template_v3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filepath) throws IOException {
        BufferedReaderCallback callback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader reader) throws IOException {
                Integer sum = 0;
                String line;

                while ((line = reader.readLine()) != null) {
                    sum += Integer.valueOf(line);
                }
                return sum;
            }
        };
        return fileReadTemplate(filepath, callback);
    }



    public Integer calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback callback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader reader) throws IOException {
                Integer multiply = 1;
                String line;

                while ((line = reader.readLine()) != null) {
                    multiply *= Integer.valueOf(line);
                }
                return multiply;
            }
        };
        return fileReadTemplate(filepath, callback);
    }

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            int result = callback.doSomethingWithReader(br);
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

}

// try catch finally가 몬가몬가 공통되는 그런게 있어서 인터페이스 하나 놓고 메서드로 그거 받아서 공통되는 부분을 따로 빼놓고
// 몬가몬가 달라지는 부분들을 인터페이스로 받아서 다르게 만드는(?) 몬가 그런(?) 그러한(?) 것이다.
// 설마 이것이 템플릿 메소드 패턴?
// while문 빼고는 또 반복한다한다.
// 큰 틀은 비슷하다한다나.
