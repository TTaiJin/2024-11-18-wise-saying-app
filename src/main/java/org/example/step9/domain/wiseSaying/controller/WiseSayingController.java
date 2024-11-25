package org.example.step9.domain.wiseSaying.controller;

import org.example.step9.domain.wiseSaying.entity.WiseSaying;
import org.example.step9.domain.wiseSaying.service.WiseSayingService;

import java.util.*;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    private final Scanner scanner;

    public WiseSayingController(Scanner scanner) {
        this.wiseSayingService = new WiseSayingService();
        this.scanner = scanner;
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String writer = scanner.nextLine();
        WiseSaying wiseSaying = wiseSayingService.addWiseSaying(content, writer);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        wiseSayings.stream()
                .sorted(Comparator.comparingInt(WiseSaying::getId).reversed())
                .forEach(e -> System.out.println(e.getId() + " / " + e.getWriter() + " / " + e.getContent()));
    }

    public void actionDelete(int deleteId) {
        int id = deleteId;
        boolean delete = wiseSayingService.removeById(id);

        if (delete) System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        else System.out.println(deleteId + "번 명언이 존재하지 않습니다.");
    }

    public void actionEdit(int editId) {
        int id = editId;
        wiseSayingService.findById(id);
        Optional<WiseSaying> optionalWiseSaying = wiseSayingService.findById(id);

        if (optionalWiseSaying.isPresent()) {
            WiseSaying foundWiseSaying = optionalWiseSaying.get();
            System.out.println("명언(기존) : " + foundWiseSaying.getContent());
            System.out.print("명언 : ");
            String content = scanner.nextLine();
            System.out.println("작가(기존) : " + foundWiseSaying.getWriter());
            System.out.print("작가 : ");
            String writer = scanner.nextLine();

            wiseSayingService.edit(foundWiseSaying, content, writer);
            System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
        } else {
            System.out.println("%d번 명언이 존재하지 않습니다.".formatted(id));
        }
    }
}
