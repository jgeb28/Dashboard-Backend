package io.github.jgeb28.dashboard.services;

import io.github.jgeb28.dashboard.models.dtos.OfferDto;
import io.github.jgeb28.dashboard.models.entities.Offer;
import io.github.jgeb28.dashboard.repositories.OfferRepository;
import io.github.jgeb28.dashboard.repositories.UserRepository;
import io.github.jgeb28.dashboard.util.OfferMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService{

    private UserRepository userRepository;
    private OfferRepository offerRepository;

    public OfferServiceImpl(UserRepository userRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public List<OfferDto> getUserOffers(Long id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found id: " + id);
        }
        List<Offer> offers = offerRepository.findByUserId(id);
        return offers.stream().map(OfferMapper::toDto).toList();
    }
}
