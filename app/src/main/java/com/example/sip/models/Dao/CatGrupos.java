package com.example.sip.models.Dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by alusdev on 5/31/17.
 */

@DatabaseTable
public class CatGrupos {

    public static final String ID = "_id";
    public static final String SUCURSAL_ID = "sucursal_id";
    public static final String PROMOTOR_ID = "promotor_id";
    public static final String NOMBRE_GRUPO = "nombre_grupo";
    public static final String FECHA_INICIO_CICLO = "fecha_inicio_ciclo";
    public static final String FECHA_FIN_CICLO = "fecha_fin_ciclo";
    public static final String NUM_CICLO = "num_ciclo";
    public static final String DIA_REUNION = "dia_reunion";
    public static final String HORA_REUNION = "hora_reunion";
    public static final String TELEFONO = "telefono";
    public static final String DOMICILIO = "domicilio";
    public static final String FECHA_ALTA_GRUPO = "fecha_alta_grupo";
    public static final String CONTACTO = "contacto";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String DELETED_AT = "deleted_at";

    @DatabaseField(generatedId = true, columnName = ID)
    private int id;
    @DatabaseField(columnName = SUCURSAL_ID)
    private int sucursalId;
    @DatabaseField(columnName = PROMOTOR_ID)
    private int promotorId;
    @DatabaseField(columnName = NOMBRE_GRUPO)
    private String nombreGrupo;
    @DatabaseField(columnName = FECHA_INICIO_CICLO)
    private Date fechaInicioCiclo;
    @DatabaseField(columnName = FECHA_FIN_CICLO)
    private Date fechaFinCiclo;
    @DatabaseField(columnName = NUM_CICLO)
    private int numCiclo;
    @DatabaseField(columnName = DIA_REUNION)
    private String diaReunion;
    @DatabaseField(columnName = HORA_REUNION)
    private String horaReunion;
    @DatabaseField(columnName = TELEFONO)
    private String telefono;
    @DatabaseField(columnName = DOMICILIO)
    private String domicilio;
    @DatabaseField(columnName = FECHA_ALTA_GRUPO)
    private Date fechaAltaGrupo;
    @DatabaseField(columnName = CONTACTO)
    private String contacto;
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

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Date getFechaInicioCiclo() {
        return fechaInicioCiclo;
    }

    public void setFechaInicioCiclo(Date fechaInicioCiclo) {
        this.fechaInicioCiclo = fechaInicioCiclo;
    }

    public Date getFechaFinCiclo() {
        return fechaFinCiclo;
    }

    public void setFechaFinCiclo(Date fechaFinCiclo) {
        this.fechaFinCiclo = fechaFinCiclo;
    }

    public int getNumCiclo() {
        return numCiclo;
    }

    public void setNumCiclo(int numCiclo) {
        this.numCiclo = numCiclo;
    }

    public String getDiaReunion() {
        return diaReunion;
    }

    public void setDiaReunion(String diaReunion) {
        this.diaReunion = diaReunion;
    }

    public String getHoraReunion() {
        return horaReunion;
    }

    public void setHoraReunion(String horaReunion) {
        this.horaReunion = horaReunion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaAltaGrupo() {
        return fechaAltaGrupo;
    }

    public void setFechaAltaGrupo(Date fechaAltaGrupo) {
        this.fechaAltaGrupo = fechaAltaGrupo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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