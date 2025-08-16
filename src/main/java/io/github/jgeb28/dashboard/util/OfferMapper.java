package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.dtos.OfferDto;
import io.github.jgeb28.dashboard.models.entities.Offer;

public class OfferMapper {
    public static OfferDto toDto(Offer offer) {
        return new OfferDto(
                offer.getId(),
                offer.getName(),
                offer.getRevenue(),
                offer.getUnits(),
                offer.getNumberOfViews(),
                offer.getPictureAddr()
        );
    }
}
