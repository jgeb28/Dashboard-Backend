package io.github.jgeb28.dashboard.controllers;

import io.github.jgeb28.dashboard.models.dtos.OfferDto;
import io.github.jgeb28.dashboard.services.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OfferDto>> getUserOffers(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getUserOffers(id));
    }
}
