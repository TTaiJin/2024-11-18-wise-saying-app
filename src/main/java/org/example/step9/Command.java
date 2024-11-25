package org.example.step9;

public enum Command {
    등록("등록"),
    삭제("삭제"),
    수정("수정"),
    종료("종료"),
    목록("목록");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command fromString(String text) {
        for (Command c : values()) {
            if(c.command.equalsIgnoreCase(text)) return c;
        }
        return null;
    }
}
