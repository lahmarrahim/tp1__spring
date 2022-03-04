package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data @AllArgsConstructor  @NoArgsConstructor
public class Adresse implements Serializable {
    private Integer numero;
    private String rue;
    private String ville;
}


