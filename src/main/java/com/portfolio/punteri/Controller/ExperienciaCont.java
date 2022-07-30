package com.portfolio.punteri.Controller;

import com.portfolio.punteri.Models.Experiencia;
import com.portfolio.punteri.Services.ExperienciaServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaCont {
    private final ExperienciaServ experienciaServ;

    public ExperienciaCont(ExperienciaServ experienciaServ){
        this.experienciaServ = experienciaServ;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){
        Experiencia updateExperiencia=experienciaServ.editarExperiencia(experiencia);
        return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> obtenerExperiencia(){
        List<Experiencia> experiencias=experienciaServ.buscarExperiencias();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia){
        Experiencia nuevaExperiencia=experienciaServ.addExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("id") Long id){
        experienciaServ.borrarExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
