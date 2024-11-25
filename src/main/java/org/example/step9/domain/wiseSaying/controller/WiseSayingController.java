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
}
