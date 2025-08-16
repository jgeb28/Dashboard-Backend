package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.AspectDto;
import io.github.jgeb28.dashboard.models.dtos.UserScoreDto;
import io.github.jgeb28.dashboard.models.entities.Aspect;
import io.github.jgeb28.dashboard.repositories.AspectRepository;
import io.github.jgeb28.dashboard.repositories.UserRepository;
import io.github.jgeb28.dashboard.util.AspectMapper;
import io.github.jgeb28.dashboard.util.PointsScale;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private AspectRepository aspectRepository;

    public UserServiceImpl(UserRepository userRepository, AspectRepository aspectRepository) {
        this.userRepository = userRepository;
        this.aspectRepository = aspectRepository;
    }


    @Override
    public UserScoreDto getUserScore(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        Object[] pointsSumAndScalesSum = (Object[]) aspectRepository.getPointsSumAndScalesSum(id);
        return PointsScale.fromObjectArray(pointsSumAndScalesSum);
    }

    @Override
    public List<AspectDto> getWorstAspectsForUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        List<Aspect> allAspects = aspectRepository.findByUserId(id);
        return allAspects.stream()
                .sorted(Comparator.comparingDouble(a -> (double) a.getPoints() / a.getScale()))
                .limit(3)
                .map(AspectMapper::toDto)
                .toList();
    }

    @Override
    public List<AspectDto> getAllAspectsForUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        List<Aspect> allAspects = aspectRepository.findByUserId(id);
        return allAspects.stream().map(AspectMapper::toDto).toList();
    }
}
