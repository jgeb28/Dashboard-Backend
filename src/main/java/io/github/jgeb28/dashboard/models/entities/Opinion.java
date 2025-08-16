package io.github.jgeb28.dashboard.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "opinions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opinion {
    @Id
    @GeneratedValue
    private Long id;

    private Integer rate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
