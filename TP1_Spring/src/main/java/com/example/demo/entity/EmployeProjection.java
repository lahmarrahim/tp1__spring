package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="pr1", types=Employe.class)
public interface EmployeProjection {

    public String getNomEmp();

    @Value("#{target.Departement.nomDepartement}")
    public String getNomDep();
}