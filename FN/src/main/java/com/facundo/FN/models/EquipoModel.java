package com.facundo.FN.models;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class EquipoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
