package com.footballclub.prog3td2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "play_against")
public class PlayAgainst implements Serializable {
    @Id
    @SequenceGenerator(name = "play_against_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "play_against_seq")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "team1_id")
    private Team team1;
    @ManyToOne
    @JoinColumn(name = "team2_id")
    private Team team2;
    private Instant datetime;
    private String stadium;
    @OneToMany(mappedBy = "playAgainst")
    private List<Goal> goals;
    @Transient
    private int team1_score;
    @Transient
    private int team2_score;
    @Transient
    private List<Goal> team1_goals;
    @Transient
    private List<Goal> team2_goals;
}
