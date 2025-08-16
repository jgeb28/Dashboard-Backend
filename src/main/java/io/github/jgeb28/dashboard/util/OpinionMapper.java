package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.dtos.OpinionDto;
import io.github.jgeb28.dashboard.models.entities.Opinion;

public class OpinionMapper {
    public static OpinionDto toDto(Opinion opinion) {
        return new OpinionDto(
                opinion.getId(),
                opinion.getOffer().getName(),
                opinion.getRate(),
                opinion.getDescription()
        );
    }
}
