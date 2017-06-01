package com.example.sip.models.Dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by alusdev on 5/31/17.
 */

@DatabaseTable
public class GruposFormacion {

    public static final String ID = "_id";
    public static final String SUCURSAL_ID = "sucursal_id";
    public static final String PROMOTOR_ID = "promotor_id";
    public static final String STS_GRUPOCLIENTE_ID = "sts_grupocliente_id";
    public static final String NOMBRE_GRUPO = "nombre_grupo";
    public static final String FECHA_ALTA_GRUPO = "fecha_alta_grupo";
    public static final String PROMOTOR_ALTA = "promotor_alta";
    public static final String CONSECUTIVO_GRUPO = "consecutivo_grupo";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String DELETED_AT = "deleted_at";

    @DatabaseField(generatedId = true, columnName = ID)
    private int id;
    @DatabaseField(columnName = SUCURSAL_ID)
    private int sucursalId;
    @DatabaseField(columnName = PROMOTOR_ID)
    private int promotorId;
    @DatabaseField(columnName = STS_GRUPOCLIENTE_ID)
    private int stsGrupoclienteId;
    @DatabaseField(columnName = NOMBRE_GRUPO)
    private String nombreGrupo;
    @DatabaseField(columnName = FECHA_ALTA_GRUPO)
    private Date fechaAltaGrupo;
    @DatabaseField(columnName = PROMOTOR_ALTA)
    private String promotorAlta;
    @DatabaseField(columnName = CONSECUTIVO_GRUPO)
    private String consecutivoGrupo;
    @DatabaseField(columnName = CREATED_AT)
    private Date createdAt;
    @DatabaseField(columnName = UPDATED_AT)
    private Date updatedAt;
    @DatabaseField(columnName = DELETED_AT)
    private Date deletedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getPromotorId() {
        return promotorId;
    }

    public void setPromotorId(int promotorId) {
        this.promotorId = promotorId;
    }

    public int getStsGrupoclienteId() {
        return stsGrupoclienteId;
    }

    public void setStsGrupoclienteId(int stsGrupoclienteId) {
        this.stsGrupoclienteId = stsGrupoclienteId;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Date getFechaAltaGrupo() {
        return fechaAltaGrupo;
    }

    public void setFechaAltaGrupo(Date fechaAltaGrupo) {
        this.fechaAltaGrupo = fechaAltaGrupo;
    }

    public String getPromotorAlta() {
        return promotorAlta;
    }

    public void setPromotorAlta(String promotorAlta) {
        this.promotorAlta = promotorAlta;
    }

    public String getConsecutivoGrupo() {
        return consecutivoGrupo;
    }

    public void setConsecutivoGrupo(String consecutivoGrupo) {
        this.consecutivoGrupo = consecutivoGrupo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}