package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.OrderDto;
import io.github.jgeb28.dashboard.models.dtos.SalesPointDto;
import io.github.jgeb28.dashboard.models.entities.OrderStatus;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<OrderStatus,Integer> getUserOrderStatusStatistics(Long userId);
    List<OrderDto> getUserOrderCountByStatus(Long userId, OrderStatus status);

    List<SalesPointDto> getUserSalesLastDay(Long userId);
    List<SalesPointDto> getUserSalesLastWeek(Long userId);
    List<SalesPointDto> getUserSalesLastMonth(Long userId);

}
