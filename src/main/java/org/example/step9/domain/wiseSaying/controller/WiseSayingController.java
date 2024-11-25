package org.example.step9.domain.wiseSaying.controller;

import org.example.step9.domain.wiseSaying.entity.WiseSaying;

import java.util.*;

public class WiseSayingController {
    private final Scanner scanner;
    private final List<WiseSaying> wiseSayings;
    private int lastId = 1;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayings = new ArrayList<>();
        this.lastId = 1;
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String writer = scanner.nextLine();
        WiseSaying wiseSaying = new WiseSaying(lastId, content, writer);
        wiseSayings.add(wiseSaying);
        System.out.println(lastId + "번 명언이 등록되었습니다.");
        lastId++;
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        wiseSayings.stream()
                .sorted(Comparator.comparingInt(WiseSaying::getId).reversed())
                .forEach(e -> System.out.println(e.getId() + " / " + e.getWriter() + " / " + e.getContent()));
    }

    public void actionDelete(int deleteId) {

        boolean delete = wiseSayings.removeIf(e -> e.getId() == deleteId);

        if (delete) System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        else System.out.println(deleteId + "번 명언이 존재하지 않습니다.");
    }

    public void actionEdit(int editId) {
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
    }
}
