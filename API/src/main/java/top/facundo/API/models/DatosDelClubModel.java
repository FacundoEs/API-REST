package top.facundo.API.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DatosDelClub")
public class DatosDelClubModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreDelClub;
    private String descripcionDelClub;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDelClub() {
        return nombreDelClub;
    }

    public void setNombreDelClub(String nombreDelClub) {
        this.nombreDelClub = nombreDelClub;
    }

    public String getDescripcionDelClub() {
        return descripcionDelClub;
    }

    public void setDescripcionDelClub(String descripcionDelClub) {
        this.descripcionDelClub = descripcionDelClub;
    }

    public DatosDelClubModel() {
    }
}
