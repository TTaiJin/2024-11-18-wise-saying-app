package org.example.step5;

import java.util.Scanner;

public class Main {
    // 내림차순 출력 수정 생각해보기

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        startApp();
    }

    private static void startApp() {
        int index = 1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("명령) ");
            String option = scanner.nextLine();
            if (option.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine();
                System.out.print("작가 : ");
                String writer = scanner.nextLine();
                WiseSaying wiseObj = new WiseSaying(wiseSaying, writer, index);
                WiseSaying.getWsList().add(wiseObj);
                System.out.println(index + "번 명언이 등록되었습니다.");
                index++;
            } else if(option.equals("목록")) {
                printWsList();
            } else if (option.equals("종료")) {
                scanner.close();
                break;
            }
        }
    }
    private static void printWsList() {
        for (WiseSaying ws : WiseSaying.getWsList()) {
            System.out.println(ws.getNumber() + " / " + ws.getWriter() + " / " + ws.getWiseSaying());
        }
    }
}
