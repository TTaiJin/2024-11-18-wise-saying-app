package org.example.step7;

import java.util.ArrayList;

public class WiseSaying {
    private String wiseSaying;
    private String writer;
    private int number;
    private static ArrayList<WiseSaying> wsList = new ArrayList<>();

    public WiseSaying(String wiseSaying, String writer, int number) {
        this.wiseSaying = wiseSaying;
        this.writer = writer;
        this.number = number;
    }

    public static ArrayList<WiseSaying> getWsList() {
        return wsList;
    }

    public String getWiseSaying() {
        return wiseSaying;
    }

    public String getWriter() {
        return writer;
    }

    public int getNumber() {
        return number;
    }
}
