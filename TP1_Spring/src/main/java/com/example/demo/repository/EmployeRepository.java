package com.example.demo.repository;

import com.example.demo.entity.Employe;
import com.example.demo.entity.Genre;
import com.example.demo.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Map;

@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    //Q4 a
    List<Employe> findEmployesByEmailContaining(String domaine);

    //Q4 b
    @Query("Select count(e.genre) from Employe e where e.genre=:genre")
    Integer getNbrEmpByGenre(@Param("genre") Genre g);

    @Query(value="Select concat(e.idEmp, p.nomProjet) from employe_table e join projet_table p join departement_table where d.nomDepartement=:nomDepartement"
        , nativeQuery = true)
    List<String> getByNomDep(@Param("nomDep") String nomDep);

}