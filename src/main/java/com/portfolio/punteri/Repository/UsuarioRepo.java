
package com.portfolio.punteri.Repository;

import com.portfolio.punteri.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends JpaRepository<Usuario,Long>{

    public void deleteById(Long id);
    
}
