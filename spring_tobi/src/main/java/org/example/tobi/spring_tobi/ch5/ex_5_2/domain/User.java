package org.example.tobi.spring_tobi.ch5.ex_5_2.domain;

public class User {

    String id;
    String name;
    String password;
    Level level;
    int login;
    int recommend;

    public User(String bumjin, String 박범진, String p1, Level basic, int login, int recommend) {
    }

    public User() {
        this.id = id;
        this.level = level;
        this.login = login;
        this.name = name;
        this.password = password;
        this.recommend = recommend;
    }



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public void upgradeLevel() {
        Level nextLevel = this.level.nextLevel();
        if (nextLevel == null) {
            throw new IllegalArgumentException(this.level + "은 업그레이드가 불가능합니다.");
        } else {
            this.level = nextLevel;
        }
    }

}

