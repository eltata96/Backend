
package com.portfolio.punteri.Repository;

import com.portfolio.punteri.Models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia,Long>{
    public void deleteById(Long id);
    
}
