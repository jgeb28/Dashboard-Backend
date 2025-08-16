package io.github.jgeb28.dashboard.repositories;

import io.github.jgeb28.dashboard.models.entities.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AspectRepository extends JpaRepository<Aspect, Long> {
    List<Aspect> findByUserId(Long userId);
    @Query("SELECT SUM(a.points), SUM(a.scale) FROM Aspect a WHERE a.user.id = :userId")
    Object getPointsSumAndScalesSum(@Param("userId") Long userId);
}
