package io.github.jgeb28.dashboard.repositories;

import io.github.jgeb28.dashboard.models.entities.Order;
import io.github.jgeb28.dashboard.models.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o.status,COUNT(o) FROM Order o where o.user.id = :userId GROUP BY o.status")
    List<Object[]> countOrdersByStatus(@Param("userId") Long userId);
    List<Order> findOrderByUserIdAndStatus(Long userId, OrderStatus status);

    @Query(value = """
         SELECT d AS period,
           COALESCE(SUM(o.price * o.units), 0) AS revenue,
           COALESCE(SUM(o.units), 0) AS items_sold
        FROM generate_series(
            date_trunc('hour', NOW() - interval '24 hours'),
            date_trunc('hour', NOW()),
            interval '1 hour'
         ) d
        LEFT JOIN orders o
               ON date_trunc('hour', o.date) = d
              AND o.user_id = :userId
        GROUP BY d
        ORDER BY d;
        """, nativeQuery = true)
    List<Object[]> getLastDayRevenueAndItemsSoldLastDay(@Param("userId") Long userId);
    @Query(value = """
        SELECT d AS period,
           COALESCE(SUM(o.price * o.units), 0) AS revenue,
           COALESCE(SUM(o.units), 0) AS items_sold
        FROM generate_series(
            date_trunc('day', NOW() - interval '7 days'),
            date_trunc('day', NOW()),
            interval '1 day'
         ) d
        LEFT JOIN orders o
               ON date_trunc('day', o.date) = d
              AND o.user_id = :userId
        GROUP BY d
        ORDER BY d;
        """, nativeQuery = true)
    List<Object[]> getLastDayRevenueAndItemsSoldLastWeek(@Param("userId") Long userId);
    @Query(value = """
         SELECT d AS period,
           COALESCE(SUM(o.price * o.units), 0) AS revenue,
           COALESCE(SUM(o.units), 0) AS items_sold
        FROM generate_series(
            date_trunc('day', NOW() - interval '1 month'),
            date_trunc('day', NOW()),
            interval '1 day'
         ) d
        LEFT JOIN orders o
               ON date_trunc('day', o.date) = d
              AND o.user_id = :userId
        GROUP BY d
        ORDER BY d;
        """, nativeQuery = true)
    List<Object[]> getLastDayRevenueAndItemsSoldLastMonth(@Param("userId") Long userId);
}
