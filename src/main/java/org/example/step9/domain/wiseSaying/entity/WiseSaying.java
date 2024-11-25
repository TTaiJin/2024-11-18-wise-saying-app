package org.example.step9.domain.wiseSaying.entity;

public class WiseSaying {
    private final int id;
    private String content;
    private String writer;

    public WiseSaying(int id, String content, String writer) {
        this.id = id;
        this.content = content;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
