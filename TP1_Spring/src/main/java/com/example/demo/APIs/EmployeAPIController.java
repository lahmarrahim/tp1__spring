package com.example.demo.APIs;

import com.example.demo.entity.Employe;
import com.example.demo.entity.Genre;
import com.example.demo.entity.Departement;
import com.example.demo.entity.Projet;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rsu")
public class EmployeAPIController {
    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    ProjetRepository projetRepository;
//a
    @GetMapping("/departement") //GET http://localhost:8082/rsu/departement/employe-projet?nomDepartement=Informatique
    public List<String> getByNomDepApi(@RequestParam("nomDepartement") String nomDepartement) {
        return employeRepository.getByNomDep(nomDepartement);
    }
//b
    @PostMapping("/employe")//POST http://localhost:8082/rsu/employe?iddepart=1
    public Employe insertEmpIntoDep(@RequestParam ("iddepart") Long idDepartement, @RequestBody Employe employe) {
        employe.setDepartement(departementRepository.findById(idDepartement).get());
        return employeRepository.save(employe);
    }
//c
    @PostMapping("/employe2")  //POST http://localhost:8082/rsu/employe2
    public Employe insertEmpIntoDep2(@RequestBody Map<String, Object> payload) {
        Employe e = new Employe();
        e.setNomEmp(payload.get("nomEmp").toString());
        e.setEmail(payload.get("email").toString());

        Long idDepartement = Long.valueOf(payload.get("idDepartement").toString());
        e.setDepartement(departementRepository.findById(idDepartement).get());

        return employeRepository.save(e);
    }
//d
/*    @PutMapping("/employe/{id}")  //PUT http://localhost:8081/rsu/employe/{id}
    public Employe updateEmployePut(@PathVariable(value = "id") Long idEmp, @RequestBody Employe employe) {
        return employeRepository.save(employe);
    }
//e
    @PatchMapping("/employe/{id}")  //PUT http://localhost:8081/rsu/employe/{id}
    public Employe updateEmployePatch(@PathVariable(value = "id") Long idEmp, @RequestBody Employe employe) {
        return employeRepository.save(employe);
    }*/
//f
    @PutMapping("/projet/projet/{idprojet}/{idemp}")  //PUT http://localhost:8081/rsu/projet/{idprojet}/{idemp}
    public Employe addEmpToProjet(@PathVariable(value = "idprojet") Long idProjet,
                                @PathVariable(value = "idemp") Long idEmp,
                                  @RequestBody Employe employe) {
        employe.setProjet(projetRepository.findById(idProjet).get());
        return employeRepository.save(employe);
    }
//g
/*    @DeleteMapping("/projet/projet/{idprojet}/{idemp}")  //DELETE http://localhost:8081/rsu/projet/{idprojet}/{idemp}
    public String DeleteEmpFromProjet(@RequestBody Employe employe,@PathVariable(value = "idprojet") Long idProjet,@PathVariable(value = "idemp") Long idEmp){

        if(projetRepository.findById(idProjet).isPresent()){
            if(employeRepository.findById(idEmp).isPresent()){
                employe.setProjet(null);
                return "Deleted correctly";
            }
        }
        return "does not exist";
    }*/
}
