/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.monja.Service;

import com.portfolio.monja.Entity.HardYSoft;
import com.portfolio.monja.Repository.RHardYSoft;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SHardYSoft {
    @Autowired
    RHardYSoft rhys;
    
    public List<HardYSoft> list(){
        return rhys.findAll();
    }
    
    public Optional<HardYSoft> getOne(int id){
        return rhys.findById(id);
    }
    
    public Optional<HardYSoft> getByNombre(String nombre){
        return rhys.findByNombre(nombre);
    }
    
    public void save(HardYSoft skill){
        rhys.save(skill);
    }
    
    public void delete(int id){
        rhys.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
}
