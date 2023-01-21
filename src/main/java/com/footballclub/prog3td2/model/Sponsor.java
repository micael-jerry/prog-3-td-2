package com.footballclub.prog3td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sponsor")
public class Sponsor implements Serializable {
    @Id
    @SequenceGenerator(name = "sponsor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sponsor_seq")
    private Integer id;
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @ManyToMany(mappedBy = "sponsors")
    @JsonIgnore
    private List<Team> teams;
}
