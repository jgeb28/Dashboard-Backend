package io.github.jgeb28.dashboard.models.dtos;

import java.math.BigDecimal;

public record OfferDto(
    Long Id,
    String name,
    BigDecimal revenue,
    Integer units,
    Integer numberOfViews,
    String pictureAddr
){}