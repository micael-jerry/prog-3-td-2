package com.footballclub.prog3td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Id
    @SequenceGenerator(name = "team_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    private Integer id;
    @Column(length = 80, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "team")
    @OrderBy(value = "number")
    @JsonIgnore
    private List<Player> players;

    @ManyToMany
    @JoinTable(
            name = "have",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "sponsor_id")}
    )
    private List<Sponsor> sponsors;

    @OneToMany
    private List<PlayAgainst> playAgainst;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Team team = (Team) o;
        return id != null && Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
