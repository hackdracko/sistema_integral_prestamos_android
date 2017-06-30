package com.example.sip.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alusdev on 6/5/17.
 */

public class Sucursal {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre_sucursal")
    private String nombreSucursal;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("colonia")
    private String colonia;
    @JsonProperty("poblacion")
    private String poblacion;
    @JsonProperty("estado_id")
    private Integer estadoId;
    @JsonProperty("localidad")
    private String localidad;
    @JsonProperty("codigo_postal")
    private String codigoPostal;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("correo")
    private String correo;
    @JsonProperty("iva")
    private Integer iva;
    @JsonProperty("created_at")
    private Object createdAt;
    @JsonProperty("updated_at")
    private Object updatedAt;
    @JsonProperty("deleted_at")
    private Object deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
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
}
