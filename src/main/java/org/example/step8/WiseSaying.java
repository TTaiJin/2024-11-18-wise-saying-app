package org.example.step8;

import java.util.ArrayList;

public class WiseSaying {
    private String wiseSaying;
    private String writer;
    private int index;
    private static ArrayList<WiseSaying> wsList = new ArrayList<>();

    public WiseSaying(String wiseSaying, String writer, int index) {
        this.wiseSaying = wiseSaying;
        this.writer = writer;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    public void setWiseSaying(String wiseSaying) {
        this.wiseSaying = wiseSaying;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
