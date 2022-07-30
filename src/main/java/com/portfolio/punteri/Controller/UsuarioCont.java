
package com.portfolio.punteri.Controller;

import com.portfolio.punteri.Models.Usuario;
import com.portfolio.punteri.Services.UsuarioServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioCont {
    private final UsuarioServ usuarioServ; 
    
    public UsuarioCont(UsuarioServ usuarioServ){
        this.usuarioServ = usuarioServ;
    }
    @GetMapping("id/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Long id){
        Usuario usuario=usuarioServ.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
        Usuario updateUsuario=usuarioServ.editarUsuario(usuario);
        return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
    }
}
