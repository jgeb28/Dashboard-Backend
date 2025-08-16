package io.github.jgeb28.dashboard.models.dtos;

public record OpinionDto(
    Long id,
    String productName,
    Integer rate,
    String description
){}