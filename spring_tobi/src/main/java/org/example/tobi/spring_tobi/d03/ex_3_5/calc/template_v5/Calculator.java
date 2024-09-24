package org.example.tobi.spring_tobi.d03.ex_3_5.calc.template_v5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filepath) throws IOException {
        LineCallBack<Integer> callBack = new LineCallBack<>() {
            @Override
            public Integer dosomethingWithLine(String line, Integer value) {
                return value + Integer.parseInt(line);
            }
        };
        return lineReadTemplate(filepath, callBack, 0);
    }



    public Double calcMultiply(String filepath) throws IOException {
        LineCallBack<Double> callBack = new LineCallBack<>() {
            @Override
            public Double dosomethingWithLine(String line, Double value) {
                return value * Double.parseDouble(line);
            }
        };
        return lineReadTemplate(filepath, callBack, 1.0);
    }

    public Float calcDivide(String filepath) throws IOException {
        LineCallBack<Float> callBack = new LineCallBack<>() {
            @Override
            public Float dosomethingWithLine(String line, Float value) {
                return value / Float.parseFloat(line);
            }
        };
        return lineReadTemplate(filepath, callBack, 1.0f);
    }

    public Integer calcMinus(String filepath) throws IOException {
        LineCallBack<Integer> callBack = new LineCallBack<>() {
            @Override
            public Integer dosomethingWithLine(String line, Integer value) {
                return value - Integer.parseInt(line);
            }
        };
        return lineReadTemplate(filepath, callBack, 0);
    }

    public <T> T lineReadTemplate(String filepath, LineCallBack<T> callback, T initValue) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
            T result = initValue;
            String line;

            while ((line = br.readLine()) != null) {
                result = callback.dosomethingWithLine(line, result);
            }
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