package org.example.step9.domain.wiseSaying.controller;

import org.example.step9.domain.wiseSaying.entity.WiseSaying;

import java.util.Comparator;
import java.util.List;

public class WiseSayingController {
    public void actionList(List<WiseSaying> wiseSayings) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        wiseSayings.stream()
                .sorted(Comparator.comparingInt(WiseSaying::getId).reversed())
                .forEach(e -> System.out.println(e.getId() + " / " + e.getWriter() + " / " + e.getContent()));
    }

    public void actionDelete(List<WiseSaying> wiseSayings, int deleteId) {

        boolean delete = wiseSayings.removeIf(e -> e.getId() == deleteId);

        if (delete) System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        else System.out.println(deleteId + "번 명언이 존재하지 않습니다.");
    }
}
