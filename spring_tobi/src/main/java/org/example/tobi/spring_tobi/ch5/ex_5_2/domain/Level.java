package org.example.tobi.spring_tobi.ch5.ex_5_2.domain;

public enum Level {

    GOLD(3, null),
    SILVER(2, GOLD),
    BASIC(1, SILVER);

    private final int value;
    private final Level level;

    Level(int value, Level level) { // 생성자 하나 만들기
        this.value = value;
        this.level = level;
    }

    public Level nextLevel() {
        return level;
    }

    public int getValue() { // 게터 해서 데려오기
        return value;
    }
    
    public static Level valueOf(int value) {
        switch (value) {
            case 1:
                return BASIC;
            case 2:
                return SILVER;
            case 3:
                return GOLD;
            default:
                throw new IllegalArgumentException("Unknown level: " + value);
        }
    }
    
}
