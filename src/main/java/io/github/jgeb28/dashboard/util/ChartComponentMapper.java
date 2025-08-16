package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.dtos.SalesPointDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

public class ChartComponentMapper {
    public static List<SalesPointDto> toDto(List<Object[]> dataList) {
        return  dataList.stream()
                .map(row -> new SalesPointDto(
                        ((Instant) row[0]).atZone(ZoneId.systemDefault()).toLocalDateTime(),
                        (BigDecimal) row[1],
                        ((Number) row[2]).intValue()
                ))
                .toList();
    }

}
