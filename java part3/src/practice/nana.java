package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class nana {

    public static void exam1() {
        List<String> list = new ArrayList<>();

        // 요소 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        System.out.println("Element at index 2 :" + list.get(2));

        if (list.contains("Apple")) {
            System.out.println("Apple found");
        }

        list.remove(1);
        System.out.println(list);

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Iterator : " + element);
        }

        while (iterator.hasPrevious()) {
            String element = iterator.previous();
            System.out.println("Iterator reversed : " + element);
        }
    }

    public static void main(String[] args) {
        exam1();
    }
}
