package io.github.jgeb28.dashboard.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SalesPointDto(LocalDateTime period, BigDecimal revenue, int itemsSold) {
}
