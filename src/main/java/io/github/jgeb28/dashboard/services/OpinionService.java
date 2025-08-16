package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.OpinionDto;

import java.util.List;

public interface OpinionService {
    List<OpinionDto> getAllUserOpinions(Long id);
    List<OpinionDto> getPositiveUserOpinions(Long id);
    List<OpinionDto> getNegativeUserOpinions(Long id);
}
