package io.github.jgeb28.dashboard.repositories;

import io.github.jgeb28.dashboard.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
