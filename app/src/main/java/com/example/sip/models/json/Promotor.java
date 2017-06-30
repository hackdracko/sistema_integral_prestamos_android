package com.example.sip.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alusdev on 6/5/17.
 */

public class Promotor {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sucursal_id")
    private Integer sucursalId;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("paterno")
    private String paterno;
    @JsonProperty("materno")
    private String materno;
    @JsonProperty("nombre_promotor")
    private String nombrePromotor;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("num_empleado")
    private String numEmpleado;
    @JsonProperty("created_at")
    private Object createdAt;
    @JsonProperty("updated_at")
    private Object updatedAt;
    @JsonProperty("deleted_at")
    private Object deletedAt;
    @JsonProperty("sucursal")
    private Sucursal sucursal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombrePromotor() {
        return nombrePromotor;
    }

    public void setNombrePromotor(String nombrePromotor) {
        this.nombrePromotor = nombrePromotor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
