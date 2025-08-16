package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.OfferDto;

import java.util.List;

public interface OfferService {
    List<OfferDto> getUserOffers(Long id);
}
