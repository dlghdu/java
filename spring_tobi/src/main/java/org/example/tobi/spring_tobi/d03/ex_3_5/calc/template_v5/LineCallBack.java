package org.example.tobi.spring_tobi.d03.ex_3_5.calc.template_v5;

public interface LineCallBack<T> {
    T dosomethingWithLine(String line, T value);
}