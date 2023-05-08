/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.monja.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExp {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String fInicio;
    @NotBlank
    private String fFinal;

    public DtoExp() {
    }

    public DtoExp(String nombreExp, String descripcionExp, String fInicio, String fFinal) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.fFinal = fFinal;
        this.fInicio = fInicio;
        
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getfInicio() {
        return fInicio;
    }

    public void setfInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public String getfFinal() {
        return fFinal;
    }

    public void setfFinal(String fFinal) {
        this.fFinal = fFinal;
    }
    
    
}
