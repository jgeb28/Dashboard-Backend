package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.OfferDto;
import io.github.jgeb28.dashboard.models.dtos.OpinionDto;
import io.github.jgeb28.dashboard.models.entities.Opinion;
import io.github.jgeb28.dashboard.repositories.OpinionRepository;
import io.github.jgeb28.dashboard.repositories.UserRepository;
import io.github.jgeb28.dashboard.util.OpinionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService{
    private UserRepository userRepository;
    private OpinionRepository opinionRepository;

    public OpinionServiceImpl(UserRepository userRepository, OpinionRepository opinionRepository) {
        this.userRepository = userRepository;
        this.opinionRepository = opinionRepository;
    }

    @Override
    public List<OpinionDto> getAllUserOpinions(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        List<Opinion> opinions = opinionRepository.findByUserId(id);

        return opinions.stream().map(OpinionMapper::toDto).toList();
    }

    @Override
    public List<OpinionDto> getPositiveUserOpinions(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        List<Opinion> opinions = opinionRepository.findPositiveByUserId(id);

        return opinions.stream().map(OpinionMapper::toDto).toList();
    }

    @Override
    public List<OpinionDto> getNegativeUserOpinions(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        List<Opinion> opinions = opinionRepository.findNegativeByUserId(id);

        return opinions.stream().map(OpinionMapper::toDto).toList();
    }
}
