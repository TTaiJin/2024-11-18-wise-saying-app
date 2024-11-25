package org.example.step9.domain.wiseSaying.service;

import org.example.step9.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingService() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 1;
    }

    public WiseSaying addWiseSaying(String content, String writer) {
        int id = lastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, writer);
        wiseSayings.add(wiseSaying);
        lastId++;
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int id) {
        return wiseSayings.removeIf(e -> e.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void edit(WiseSaying foundWiseSaying, String content, String writer) {
        foundWiseSaying.setContent(content);
        foundWiseSaying.setWriter(writer);
    }
}
