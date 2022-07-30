package com.portfolio.punteri.Controller;

import com.portfolio.punteri.Models.Skills;
import com.portfolio.punteri.Services.SkillsServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsCont {
    private final SkillsServ skillsServ;

    public SkillsCont(SkillsServ skillsServ){
        this.skillsServ = skillsServ;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skills){
        Skills updateSkills=skillsServ.editarSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skills>> obtenerSkills(){
        List<Skills> skillses=skillsServ.buscarSkillses();
        return new ResponseEntity<>(skillses, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Skills> crearSkills(@RequestBody Skills skills){
        Skills nuevaSkills=skillsServ.addSkills(skills);
        return new ResponseEntity<>(nuevaSkills,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable("id") Long id){
        skillsServ.borrarSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}