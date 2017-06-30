package com.example.sip.models.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alusdev on 6/5/17.
 */

public class Usuario {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("promotor_id")
    private Integer promotorId;
    @JsonProperty("usuario")
    private String usuario;
    @JsonProperty("administrador")
    private Integer administrador;
    @JsonProperty("fecha_vencimiento")
    private String fechaVencimiento;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("deleted_at")
    private Object deletedAt;
    @JsonProperty("promotor")
    private Promotor promotor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPromotorId() {
        return promotorId;
    }

    public void setPromotorId(Integer promotorId) {
        this.promotorId = promotorId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Integer administrador) {
        this.administrador = administrador;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }
}
