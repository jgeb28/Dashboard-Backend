package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.OrderDto;
import io.github.jgeb28.dashboard.models.dtos.SalesPointDto;
import io.github.jgeb28.dashboard.models.entities.OrderStatus;
import io.github.jgeb28.dashboard.repositories.OrderRepository;
import io.github.jgeb28.dashboard.repositories.UserRepository;
import io.github.jgeb28.dashboard.util.ChartComponentMapper;
import io.github.jgeb28.dashboard.util.OrderCount;
import io.github.jgeb28.dashboard.util.OrderMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Map<OrderStatus, Integer> getUserOrderStatusStatistics(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found id: " + userId);
        }
        List<Object[]> orderStatusStatistics = orderRepository.countOrdersByStatus(userId);
        return OrderCount.toStatusCountMap(orderStatusStatistics);
    }

    @Override
    public List<OrderDto> getUserOrderCountByStatus(Long userId, OrderStatus status) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found id: " + userId);
        }

        return orderRepository.findOrderByUserIdAndStatus(userId,status)
                .stream().map(OrderMapper::toDto).toList();
    }

    @Override
    public List<SalesPointDto> getUserSalesLastDay(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found id: " + userId);
        }
        return ChartComponentMapper.toDto(orderRepository.getLastDayRevenueAndItemsSoldLastDay(userId));
    }

    @Override
    public List<SalesPointDto> getUserSalesLastWeek(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found id: " + userId);
        }
        return ChartComponentMapper.toDto(orderRepository.getLastDayRevenueAndItemsSoldLastWeek(userId));
    }

    @Override
    public List<SalesPointDto> getUserSalesLastMonth(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found id: " + userId);
        }
        return ChartComponentMapper.toDto(orderRepository.getLastDayRevenueAndItemsSoldLastMonth(userId));
    }


}
