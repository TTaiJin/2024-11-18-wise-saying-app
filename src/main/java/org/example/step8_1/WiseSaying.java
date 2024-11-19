package org.example.step8_1;

public class WiseSaying {
    private String wiseSaying;
    private String writer;
    private int index;

    public WiseSaying(String wiseSaying, String writer, int index) {
        this.wiseSaying = wiseSaying;
        this.writer = writer;
        this.index = index;
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
