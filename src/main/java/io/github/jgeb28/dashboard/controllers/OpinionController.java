package io.github.jgeb28.dashboard.controllers;

import io.github.jgeb28.dashboard.models.dtos.OpinionDto;
import io.github.jgeb28.dashboard.services.OpinionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/opinions")
public class OpinionController {
    private final OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<OpinionDto>> getUserOpinions(@PathVariable Long id) {
        return ResponseEntity.ok(opinionService.getAllUserOpinions(id));
    }

    @GetMapping("positive/{id}")
    public ResponseEntity<List<OpinionDto>> getUserPositiveOpinions(@PathVariable Long id) {
        return ResponseEntity.ok(opinionService.getPositiveUserOpinions(id));
    }

    @GetMapping("negative/{id}")
    public ResponseEntity<List<OpinionDto>> getUserNegativeOpinions(@PathVariable Long id) {
        return ResponseEntity.ok(opinionService.getNegativeUserOpinions(id));
    }
}
