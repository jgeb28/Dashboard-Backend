package io.github.jgeb28.dashboard;

import io.github.jgeb28.dashboard.models.entities.*;
import io.github.jgeb28.dashboard.repositories.*;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(
            UserRepository userRepo,
            OfferRepository offerRepo,
            OrderRepository orderRepo,
            OpinionRepository opinionRepo,
            AspectRepository aspectRepo
    ) {
        return args -> {
            Faker faker = new Faker();
            Random random = new Random();

            List<String> aspectNames = List.of(
                    "Communication", "Reliability", "Punctuality", "Product Quality",
                    "Packaging Quality", "Customer Service", "Responsiveness",
                    "Price Fairness", "Problem Solving", "Professionalism"
            );

            for (int i = 0; i < 5; i++) {
                User user = new User();
                user.setName(faker.name().fullName());
                userRepo.save(user);

                for (String aspectName : aspectNames) {
                    Aspect aspect = new Aspect();
                    aspect.setName(aspectName);
                    aspect.setPoints(random.nextInt(4) + 7);
                    aspect.setScale(10);
                    aspect.setUser(user);
                    aspectRepo.save(aspect);
                }

                for (int j = 0; j < 10; j++) {
                    Offer offer = new Offer();
                    offer.setName(faker.commerce().productName());
                    offer.setRevenue(BigDecimal.valueOf(random.nextDouble() * 500 + 50));
                    offer.setUnits(random.nextInt(200) + 20);
                    offer.setNumberOfViews(random.nextInt(5000) + 100);
                    offer.setPictureAddr("/" + faker.commerce().material() + ".jpg");
                    offer.setUser(user);
                    offerRepo.save(offer);

                    int ordersCount = random.nextInt(5) + 3; 
                    for (int k = 0; k < ordersCount; k++) {
                        Order order = new Order();
                        order.setOffer(offer);
                        order.setUser(user);
                        order.setDate(LocalDateTime.now().minusDays(random.nextInt(23) + 8));
                        order.setStatus(OrderStatus.values()[random.nextInt(OrderStatus.values().length)]);
                        order.setUnits(random.nextInt(100) + 1);
                        order.setPrice(BigDecimal.valueOf(random.nextDouble() * 300 + 20));
                        orderRepo.save(order);

                        if (random.nextBoolean()) {
                            Opinion opinion = new Opinion();
                            opinion.setOffer(offer); 
                            opinion.setRate(random.nextInt(5) + 1);
                            opinion.setDescription(faker.lorem().sentence());
                            opinionRepo.save(opinion);
                        }
                    }
                    for (int k = 0; k < ordersCount; k++) {
                        Order order = new Order();
                        order.setOffer(offer);
                        order.setUser(user);
                        order.setDate(LocalDateTime.now().minusDays(random.nextInt(6) + 2));
                        order.setStatus(OrderStatus.values()[random.nextInt(OrderStatus.values().length)]);
                        order.setUnits(random.nextInt(100) + 1);
                        order.setPrice(BigDecimal.valueOf(random.nextDouble() * 300 + 20));
                        orderRepo.save(order);

                        if (random.nextBoolean()) {
                            Opinion opinion = new Opinion();
                            opinion.setOffer(offer);
                            opinion.setRate(random.nextInt(5) + 1);
                            opinion.setDescription(faker.lorem().sentence());
                            opinionRepo.save(opinion);
                        }
                    }
                    for (int k = 0; k < ordersCount; k++) {
                        Order order = new Order();
                        order.setOffer(offer);
                        order.setUser(user);
                        order.setDate(LocalDateTime.now().minusHours(random.nextInt(24)));
                        order.setStatus(OrderStatus.values()[random.nextInt(OrderStatus.values().length)]);
                        order.setUnits(random.nextInt(5) + 1);
                        order.setPrice(BigDecimal.valueOf(random.nextDouble() * 30 + 20));
                        orderRepo.save(order);

                        if (random.nextBoolean()) {
                            Opinion opinion = new Opinion();
                            opinion.setOffer(offer);
                            opinion.setRate(random.nextInt(5) + 1);
                            opinion.setDescription(faker.lorem().sentence());
                            opinionRepo.save(opinion);
                        }
                    }
                }
            }
        };
    }
}
