package io.github.jgeb28.dashboard.repositories;

import io.github.jgeb28.dashboard.models.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion,Long> {
    List<Opinion> findByOfferId(Long offerId);
    @Query("SELECT op FROM Opinion op WHERE op.offer.user.id = :userId")
    List<Opinion> findByUserId(@Param("userId") Long userId);
    @Query("SELECT op FROM Opinion op WHERE op.offer.user.id = :userId AND op.rate > 3")
    List<Opinion> findPositiveByUserId(@Param("userId") Long userId);
    @Query("SELECT op FROM Opinion op WHERE op.offer.user.id = :userId AND op.rate < 3")
    List<Opinion> findNegativeByUserId(@Param("userId") Long userId);
}
