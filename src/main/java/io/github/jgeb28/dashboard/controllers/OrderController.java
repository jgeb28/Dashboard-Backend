package io.github.jgeb28.dashboard.controllers;

import io.github.jgeb28.dashboard.models.dtos.OrderDto;
import io.github.jgeb28.dashboard.models.dtos.SalesPointDto;
import io.github.jgeb28.dashboard.models.entities.OrderStatus;
import io.github.jgeb28.dashboard.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/statistics/{id}")
    public ResponseEntity<Map<OrderStatus, Integer>> getUserOrdersStatistics(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getUserOrderStatusStatistics(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDto>> getUserOrdersCountByStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.getUserOrderCountByStatus(id, status));
    }
    @GetMapping("/{id}/sales/day")
    public ResponseEntity<List<SalesPointDto>> getUserSalesDataByHour(
            @PathVariable Long id) {
        return ResponseEntity.ok(orderService.getUserSalesLastDay(id));
    }
    @GetMapping("/{id}/sales/week")
    public ResponseEntity<List<SalesPointDto>> getUserSalesDataByDay(
            @PathVariable Long id) {
        return ResponseEntity.ok(orderService.getUserSalesLastWeek(id));
    }

    @GetMapping("/{id}/sales/month")
    public ResponseEntity<List<SalesPointDto>> getUserSalesDataByMonth(
            @PathVariable Long id) {
        return ResponseEntity.ok(orderService.getUserSalesLastMonth(id));
    }


}
