/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 7fprog03
 */
public class Logistica extends Trabajador {
    
    //asociacion con parte
    private List<Parte>parte = new ArrayList<>();
    

    public Logistica() {
    }

     public Logistica(String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
        super(dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, idCent);
    }
   
    
}
