package org.example.step9;

import org.example.step9.domain.wiseSaying.controller.WiseSayingController;
import org.example.step9.domain.wiseSaying.entity.WiseSaying;

import java.util.*;

public class App {
    private final Scanner scanner;
    private final List<WiseSaying> wiseSayings;
    private boolean isRunning;

    private final WiseSayingController wiseSayingController;

    public App() {
        scanner = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        isRunning = true;
        wiseSayingController = new WiseSayingController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (isRunning) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            Command command = Command.fromString(cmd);
            if (command == null) {
                System.out.println("올바르지 않은 명령어입니다.");
                continue;
            }
            switch (command) {
                case 등록 -> wiseSayingController.actionAdd(scanner, wiseSayings);
                case 삭제 -> {
                    System.out.print("삭제할 명언의 번호를 입력하세요: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    wiseSayingController.actionDelete(wiseSayings, deleteId);
                }
                case 수정 -> {
                    System.out.println("수정할 명언의 번호를 입력하세요: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    wiseSayingController.actionEdit(scanner, wiseSayings, editId);
                }
                case 목록 -> wiseSayingController.actionList(wiseSayings);
                case 종료 -> actionExit();
            }
        }
    }

    private void actionExit() {
        System.out.println("종료합니다.");
        scanner.close();
        isRunning = false;
    }
}
