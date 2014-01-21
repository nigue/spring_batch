package com.neoingen.cl.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {

    private String nombre;
    private int edad;
    private boolean masculino;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBean.class);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isMasculino() {
        return masculino;
    }

    public void setMasculino(boolean masculino) {
        this.masculino = masculino;
    }
}
