package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.entities.OrderStatus;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderCount {
    public static Map<OrderStatus, Integer> toStatusCountMap(List<Object[]> results) {
        return results.stream()
                .collect(Collectors.toMap(
                        row -> (OrderStatus) row[0],
                        row -> ((Number) row[1]).intValue()
                ));
    }

}
