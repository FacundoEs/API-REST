package com.facundo.FN.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String usuario;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    public UserModel(Integer id, String usuario, String contrasena, AppUserRole appUserRole) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.appUserRole = appUserRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }
}
