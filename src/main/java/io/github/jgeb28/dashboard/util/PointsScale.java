package io.github.jgeb28.dashboard.util;

import io.github.jgeb28.dashboard.models.dtos.UserScoreDto;

public class PointsScale {
    public static UserScoreDto fromObjectArray(Object[] row) {
        return new UserScoreDto(((Number) row[0]).intValue(), ((Number) row[1]).intValue());
    }
}
