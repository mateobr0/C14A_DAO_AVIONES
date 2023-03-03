package org.vuelosCharter.models;

import java.time.LocalDate;

public class Avion {
    private String marca;
    private String modelo;
    private String matricula;
    private LocalDate entradaEnServicio;
    private Integer id;

    public Avion(String marca, String modelo, String matricula, LocalDate entradaEnServicio) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.entradaEnServicio = entradaEnServicio;
    }

    public Avion(String marca, String modelo, String matricula, LocalDate entradaEnServicio, Integer id) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.entradaEnServicio = entradaEnServicio;
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getEntradaEnServicio() {
        return entradaEnServicio;
    }

    public void setEntradaEnServicio(LocalDate entradaEnServicio) {
        this.entradaEnServicio = entradaEnServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", entradaEnServicio=" + entradaEnServicio +
                ", id=" + id +
                '}';
    }
}
