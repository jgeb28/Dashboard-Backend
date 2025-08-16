package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.dtos.AspectDto;
import io.github.jgeb28.dashboard.models.entities.Aspect;

public class AspectMapper {
    public static AspectDto toDto(Aspect aspect) {
        return new AspectDto(
            aspect.getId(),
            aspect.getName(),
            aspect.getPoints(),
            aspect.getScale()
        );
    }
}
