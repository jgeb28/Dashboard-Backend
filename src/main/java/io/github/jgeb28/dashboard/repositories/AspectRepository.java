package io.github.jgeb28.dashboard.repositories;

import io.github.jgeb28.dashboard.models.entities.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AspectRepository extends JpaRepository<Aspect, Long> {
    List<Aspect> findByUserId(Long userId);
    @Query("SELECT SUM(asp.points), SUM(asp.scale) FROM Aspect asp WHERE asp.user.id = :userId")
    Object getPointsSumAndScalesSum(@Param("userId") Long userId);
}
