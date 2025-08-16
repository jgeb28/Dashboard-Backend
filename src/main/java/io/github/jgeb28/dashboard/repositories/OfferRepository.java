package io.github.jgeb28.dashboard.repositories;

import io.github.jgeb28.dashboard.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByUserId(Long id);
}
