package com.portfolio.punteri.Services;

import com.portfolio.punteri.Models.Skills;
import com.portfolio.punteri.Repository.SkillsRepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SkillsServ {
    @Autowired
    private final SkillsRepo skillsRepo;

    public SkillsServ(SkillsRepo skillsRepo){
        this.skillsRepo = skillsRepo;
    }
    public Skills addSkills(Skills skills){
        return skillsRepo.save(skills);
    }
    public List<Skills> buscarSkillses(){
        return skillsRepo.findAll();
    }
    public Skills editarSkills(Skills skills){
        return skillsRepo.save(skills);
    }
    public void borrarSkills(Long id){
        skillsRepo.deleteById(id);
    }
}