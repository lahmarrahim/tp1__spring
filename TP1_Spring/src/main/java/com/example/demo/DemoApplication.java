package com.example.demo;

import com.example.demo.entity.Adresse;
import com.example.demo.entity.Genre;
import com.example.demo.entity.Employe;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Projet;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    EmployeRepository employeRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    ProjetRepository projetRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        departementRepository.save(new Departement(null,"Informatique",null));
        departementRepository.save(new Departement(null,"Mathematique",null));

        projetRepository.save(new Projet(null,"Projet1",90,null));
        projetRepository.save(new Projet(null,"Projet2",100,null));

        Departement dep1 = departementRepository.getById(1L);
        Departement dep2 = departementRepository.getById(2L);

        Projet projet1 = projetRepository.getById(1L);
        Projet projet2 = projetRepository.getById(2L);

        employeRepository.save(new Employe(null,"Mohamed",Genre.Mr,Date.valueOf("2018-09-16"),
                "mohamed@esi-sba.dz",null,dep1,projet1));
        employeRepository.save(new Employe(null,"Riad",Genre.Mr,Date.valueOf("2018-09-16"),
                "riad@esi-sba.dz",null,dep1,projet1));
        employeRepository.save(new Employe(null,"Abdelkrim",Genre.Mr,Date.valueOf("2018-09-16"),
                "krimo@esi-sba.dz",null,dep1,projet1));
        employeRepository.save(new Employe(null,"Salah",Genre.Mr,Date.valueOf("2018-09-16"),
                "salah@esi-sba.dz",null,dep1,projet2));
        employeRepository.save(new Employe(null,"Fethi",Genre.Mr,Date.valueOf("2018-09-16"),
                "fethi@esi-sba.dz",null,dep2,projet2));
        employeRepository.save(new Employe(null,"Fouad",Genre.Mr,Date.valueOf("2018-09-16"),
                "fouad@esi-sba.dz",null,dep2,projet2));
        employeRepository.save(new Employe(null,"Zakaria",Genre.Mr,Date.valueOf("2024-09-16"),
                "zakaria@gmail.com",null,null,null));

//        employeRepository.findAll().forEach(System.out::println);
        //Q4 a
        employeRepository.findEmployesByEmailContaining("esi-sba.dz").forEach(System.out::println);

        //Q4 b
        System.out.println(employeRepository.getNbrEmpByGenre(Genre.Mr));

//        employeRepository.getByNomDep("Informatique").forEach(System.out.println();


    }
}
