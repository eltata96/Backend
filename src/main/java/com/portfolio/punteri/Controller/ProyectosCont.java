package com.portfolio.punteri.Controller;

import com.portfolio.punteri.Models.Proyectos;
import com.portfolio.punteri.Services.ProyectosServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectosCont {
    private final ProyectosServ proyectosServ;

    public ProyectosCont(ProyectosServ proyectosServ){
        this.proyectosServ = proyectosServ;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos=proyectosServ.editarProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> obtenerProyectos(){
        List<Proyectos> proyectoss=proyectosServ.buscarProyectoss();
        return new ResponseEntity<>(proyectoss, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Proyectos> crearProyectos(@RequestBody Proyectos proyectos){
        Proyectos nuevaProyectos=proyectosServ.addProyectos(proyectos);
        return new ResponseEntity<>(nuevaProyectos,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarProyectos(@PathVariable("id") Long id){
        proyectosServ.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}