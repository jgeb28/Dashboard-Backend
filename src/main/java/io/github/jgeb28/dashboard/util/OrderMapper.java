package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.dtos.OrderDto;
import io.github.jgeb28.dashboard.models.entities.Order;

public class OrderMapper {
    public static OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getDate(),
                order.getStatus(),
                order.getPrice()
        );
    }
}
