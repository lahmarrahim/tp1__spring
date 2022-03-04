package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "DepartementTable")
@Data @AllArgsConstructor @NoArgsConstructor
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartement;
    @Column(nullable = false, length = 20)
    private String nomDepartement;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "departement", fetch = FetchType.EAGER)
    private Collection<Employe> lesEmployes;

}
