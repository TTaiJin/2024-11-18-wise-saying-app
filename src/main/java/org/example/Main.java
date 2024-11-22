package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

}

class App {

    public void run() {
        System.out.println("== 명언 앱 ==");
        int lastId = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String content = scanner.nextLine();
                System.out.print("작가: ");
                String author = scanner.nextLine();
                int id = ++lastId;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));

                WiseSaying wiseSaying = new WiseSaying();
            }
        }
        scanner.close();
    }
}

class WiseSaying {

}
