package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EmployeTable")
@Data @AllArgsConstructor @NoArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmp;
    @Column(nullable = false, length = 20)
    private String nomEmp;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Temporal(TemporalType.DATE)
    private Date dateEmbauche;
    @Column(unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="AdresseTable")
    private List<Adresse> adresse;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="iddepartement")
    private Departement departement;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="idprojet")
    private Projet projet;
}
