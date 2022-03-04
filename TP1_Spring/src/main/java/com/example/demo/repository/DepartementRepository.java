package com.example.demo.repository;

import com.example.demo.entity.Departement;
import com.example.demo.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement,Long>  {
}
