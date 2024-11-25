package org.example.step8_2;

import java.util.*;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private int lastId = 1;
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private boolean isRunning = true;

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
                case 등록 -> actionAdd();
                case 삭제 -> actionDelete();
                case 수정 -> actionEdit();
                case 목록 -> actionList();
                case 종료 -> actionExit();
            }
        }
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String writer = scanner.nextLine();
        WiseSaying wiseSaying = new WiseSaying(lastId, content, writer);
        wiseSayings.add(wiseSaying);
        System.out.println(lastId + "번 명언이 등록되었습니다.");
        lastId++;
    }

    private void actionDelete() {
        System.out.print("삭제할 명언의 번호를 입력하세요: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine();
        boolean delete = wiseSayings.removeIf(e -> e.getId() == deleteId);

        if (delete) System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        else System.out.println(deleteId + "번 명언이 존재하지 않습니다.");
    }

    private void actionEdit() {
        System.out.println("수정할 명언의 번호를 입력하세요: ");
        int editId = scanner.nextInt();
        scanner.nextLine();

        Optional<WiseSaying> optionalWiseSaying = wiseSayings.stream()
                .filter(e -> e.getId() == editId)
                .findFirst();

        if (optionalWiseSaying.isPresent()) {
            WiseSaying foundWiseSaying = optionalWiseSaying.get();
            System.out.println("명언(기존) : " + foundWiseSaying.getContent());
            System.out.print("명언 : ");
            foundWiseSaying.setContent(scanner.nextLine());
            System.out.println("작가(기존) : " + foundWiseSaying.getWriter());
            System.out.print("작가 : ");
            foundWiseSaying.setWriter(scanner.nextLine());
            System.out.println(editId + "번 명언이 수정되었습니다.");
        } else {
            System.out.println(editId + "번 명언이 존재하지 않습니다.");
        }

     /*   WiseSaying foundWiseSaying = null;

        System.out.println("수정할 명언의 번호를 입력하세요: ");
        int editId = scanner.nextInt();
        scanner.nextLine();
        if(editId < 0 || editId >= wiseSayings.size()) {
            System.out.println(editId + "번 명언이 존재하지 않습니다.");
            return;
        }
        for (WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.getId() == editId){
                foundWiseSaying = wiseSaying;
                break;
            }
        }
        foundWiseSaying = wiseSayings.get(editId);


        if (foundWiseSaying == null) {
            System.out.println(editId + "번 명언이 존재하지 않습니다.");
        } else {
            System.out.println("명언(기존) : " + foundWiseSaying.getContent());
            System.out.print("명언 : ");
            foundWiseSaying.setContent(scanner.nextLine());
            System.out.println("작가(기존) : " + foundWiseSaying.getWriter());
            System.out.print("작가 : ");
            foundWiseSaying.setWriter(scanner.nextLine());
        }*/
        }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        wiseSayings.stream()
                .sorted(Comparator.comparingInt(WiseSaying::getId).reversed())
                .forEach(e -> System.out.println(e.getId() + " / " + e.getWriter() + " / " + e.getContent()));
    }

    private void actionExit() {
        System.out.println("종료합니다.");
        isRunning = false;
    }
}
