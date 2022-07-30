package com.portfolio.punteri.Services;

/*implementar en el 
resto de clases*/
import com.portfolio.punteri.Models.Usuario;
import com.portfolio.punteri.Repository.UsuarioRepo;
import com.portfolio.punteri.exception.UserNotFoundException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServ {
    private final UsuarioRepo usuarioRepo;
    
    @Autowired
    public UsuarioServ(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }
    
    public Usuario addUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    public List<Usuario> buscarUsuario(){
        return usuarioRepo.findAll();
    }
    public Usuario editarUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }
    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }
    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElseThrow(()->new UserNotFoundException("usuario no encontrado"));
    }

}
