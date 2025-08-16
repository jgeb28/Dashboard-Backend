package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.AspectDto;
import io.github.jgeb28.dashboard.models.dtos.UserScoreDto;

import java.util.List;

public interface UserService {
    UserScoreDto getUserScore(Long id);
    List<AspectDto> getWorstAspectsForUser(Long id);
    List<AspectDto> getAllAspectsForUser(Long id);
}
