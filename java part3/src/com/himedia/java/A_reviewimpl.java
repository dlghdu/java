package com.himedia.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_reviewimpl implements A_review {
    private Map<String, String> contentMap;
    private Map<String, Integer> likeMap;

    public A_reviewimpl() {
        this.contentMap = new HashMap<>();
        this.likeMap = new HashMap<>();
    }

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("리.뷰.푸.로.그.램");
        System.out.println("[1]댓글추가 [2]좋와요 [3]전체보기 [4]삭제 [5]종료");
        System.out.println("숫자 선택↓");
        return sc.nextInt();
    }

    @Override
    public void plusMent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String name = sc.nextLine().trim();
        System.out.println("내용을 입력하세요.");
        String sogae = sc.nextLine().trim();

        if (!checkString(name) || !checkString(sogae)) {
            System.out.println("다시 입력해주세요");
            return;
        }
        dataIn(name, sogae, 0);
    }

    @Override
    public void dataIn(String id, String sogae, int likeCnt) {
        contentMap.put(id, sogae);
        likeMap.put(id, likeCnt);
    }

    @Override
    public void selAll() {
        for (String key : contentMap.keySet()) {
            System.out.println(key + ":" + contentMap.get(key) + "\t" + likeMap.get(key));
        }
    }

    @Override
    public void highLike() {
        selAll();
        Scanner sc = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String name = sc.nextLine().trim();

        if (!checkString(name)) {
            System.out.println("ID를 입력하지 않았습니다.");
            return;
        }

        if (likeMap.containsKey(name)) {
            likeMap.put(name, likeMap.get(name) + 1);
        } else {
            System.out.println("ID를 잘 못 입력하셨습니다.");
        }
    }

    @Override
    public void deletE() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String name = sc.nextLine().trim();

        if (!checkString(name)) {
            System.out.println("ID를 입력하지 않았습니다.");
            return;
        }

        if (contentMap.containsKey(name)) {
            contentMap.remove(name);
            likeMap.remove(name);
        } else {
            System.out.println("찾으시는 ID가 없습니다.");
        }
    }

    private boolean checkString(String str) {
            return str.length() == 0 ? false : true;

    }
}


//@Override
//    public void plusMent() {
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("ID를 입력하세요.");
//        String name = sc.nextLine();
//        String nameTrim = name.trim();
//        System.out.println(nameTrim);
//        System.out.println("내용을 입력하세요.");
//        String sogae = sc.nextLine();
//        String sogaeTrim = sogae.trim();
//        System.out.println(sogaeTrim);
//
//
//
//    }
//
//    @Override
//    public void mapMap() {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("name", "");
//        map.put("sogae", "");
//        map.put("likie", "");
//
//        String bv = map.get("name");
//        String ct = map.get("sogae");
//        String lv = map.get("likie");
//        System.out.println("ID : " + bv + "내용 : " + ct + "좋와용 : " + lv);
//    }
//
//    @Override
//    public void joayo() {
//
//    }