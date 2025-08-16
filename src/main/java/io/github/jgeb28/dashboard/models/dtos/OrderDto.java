package io.github.jgeb28.dashboard.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.github.jgeb28.dashboard.models.entities.OrderStatus;

public record OrderDto(
    Long id,
    LocalDateTime date,
    OrderStatus status,
    BigDecimal price
){}