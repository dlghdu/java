package org.example.tobi.spring_tobi.d03.ex_3_5.calc.template_v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        Integer sum = 0;
        String line;

        while ( (line = br.readLine()) != null ) {
            sum += Integer.parseInt(line);
        }

        br.close();
        return sum;
    }

}

// 이 메서드가 잘 동작하면 문제 없지만 자원 반납이 안된다면 메모리 누수가 발생해서 계속 동작하다보면 결국 메모리가 터져버린다.
// close() , return 을 잘 이용해서 잘 작동하도록 만들자.
// ㅓㅇ 이거 아닌가 모르겠네 저거 맞지 않을까
// 결과적으로는 괜찮지만 리스크를 가지면서 함께 가는 코드다.
