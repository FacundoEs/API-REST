package top.facundo.API.models;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class JugadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private int edad;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JugadorModel(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public JugadorModel() {
    }
}
