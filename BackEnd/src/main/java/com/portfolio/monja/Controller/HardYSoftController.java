/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.monja.Controller;

import com.portfolio.monja.Dto.DtoHardYSoft;
import com.portfolio.monja.Entity.HardYSoft;
import com.portfolio.monja.Security.Controller.Mensaje;
import com.portfolio.monja.Service.SHardYSoft;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("skill")
public class HardYSoftController {

    @Autowired
    SHardYSoft shys;

    @GetMapping("/detail/{id}")
    public ResponseEntity<HardYSoft> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HardYSoft hys = shys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<HardYSoft>> list() {
        List<HardYSoft> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHardYSoft dtoHys) {
        if (StringUtils.isBlank(dtoHys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (shys.existsByNombre(dtoHys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        }

        HardYSoft hys = new HardYSoft(dtoHys.getNombre(), dtoHys.getPorcentaje(), dtoHys.getImg());
        shys.save(hys);

        return new ResponseEntity(new Mensaje("skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHardYSoft dtoHys) {

        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (shys.existsByNombre(dtoHys.getNombre()) && shys.getByNombre(dtoHys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoHys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HardYSoft hys = shys.getOne(id).get();
        hys.setNombre(dtoHys.getNombre());
        hys.setPorcentaje(dtoHys.getPorcentaje());
        hys.setImg(dtoHys.getImg());

        shys.save(hys);
        return new ResponseEntity(new Mensaje("skill actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.BAD_REQUEST);
        }

        shys.delete(id);

        return new ResponseEntity(new Mensaje("skill eliminada"), HttpStatus.OK);
    }
}
