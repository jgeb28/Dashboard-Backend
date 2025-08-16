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
@Table(name = "aspects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aspect {
    @Id 
    @GeneratedValue
    private Long id;

    private String name;
    private Integer points;
    private Integer scale;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
