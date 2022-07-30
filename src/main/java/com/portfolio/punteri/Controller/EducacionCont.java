
package com.portfolio.punteri.Controller;

import com.portfolio.punteri.Models.Educacion;
import com.portfolio.punteri.Services.EducacionServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
public class EducacionCont {
    private final EducacionServ educacionServ;

    public EducacionCont(EducacionServ educacionServ){
        this.educacionServ = educacionServ;
    }

    //@PreAuthorize("hasRole('ADMIN')")//
    @PutMapping("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion=educacionServ.editarEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
        List<Educacion> educaciones=educacionServ.buscarEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionServ.addEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("id") Long id){
        educacionServ.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
