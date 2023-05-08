/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.monja.Repository;

import com.portfolio.monja.Entity.HardYSoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHardYSoft extends JpaRepository<HardYSoft, Integer>{
    Optional<HardYSoft> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
