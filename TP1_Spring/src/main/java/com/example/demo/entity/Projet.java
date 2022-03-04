package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ProjetTable")
@Data @AllArgsConstructor @NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjet;
    @Column(nullable = false, length = 20)
    private String nomProjet;

    private Integer dureeRealisation;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "projet")
    private Collection<Employe> lesEmployes;
}
