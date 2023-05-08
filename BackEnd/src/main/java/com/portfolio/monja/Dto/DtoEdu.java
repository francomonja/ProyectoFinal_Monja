/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.monja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEdu {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String fInicio;
    @NotBlank
    private String fFinal;

    public DtoEdu() {
    }

    public DtoEdu(String nombreEdu, String descripcionEdu, String fInicio, String fFinal) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.fInicio = fInicio;
        this.fFinal = fFinal;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
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