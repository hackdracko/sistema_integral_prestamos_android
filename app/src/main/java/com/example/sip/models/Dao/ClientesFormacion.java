package com.example.sip.models.Dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by alusdev on 5/31/17.
 */

@DatabaseTable
public class ClientesFormacion {

    public static final String ID = "_id";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO_PATERNO = "apellido_paterno";
    public static final String APELLIDO_MATERNO = "apellido_materno";
    public static final String TIPO_CLIENTE_ID = "tipo_cliente_id";
    public static final String RFC = "RFC";
    public static final String LUGAR_NACIMIENTO_ID = "lugar_nacimiento_id";
    public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String ESTADO_CIVIL_ID = "estado_civil_id";
    public static final String GENERO_ID = "genero_id";
    public static final String NACIONALIDAD_ID = "nacionalidad_id";
    public static final String TELEFONO_CELULAR = "telefono_celular";
    public static final String COMPANIA_CELULAR_ID = "compania_celular_id";
    public static final String IDENTIFICACION_ID = "identificacion_id";
    public static final String NUMERO_IDENTIFICACION = "numero_identificacion";
    public static final String CLIENTE_COMPETENCIA = "cliente_competencia";
    public static final String COMPETENCIA_ID = "competencia_id";
    public static final String PRESTAMO_SOLICITADO_ID = "prestamo_solicitado_id";
    public static final String PRESTAMO_SOLICITADO = "prestamo_solicitado";
    public static final String DESTINO_PRESTAMO_ID = "destino_prestamo_id";
    public static final String CODIGO_POSTAL = "codigo_postal";
    public static final String ESTADO_ID = "estado_id";
    public static final String LOCALIDAD = "localidad";
    public static final String DELEGACION = "delegacion";
    public static final String COLONIA = "colonia";
    public static final String CALLE = "calle";
    public static final String NUMERO_EXTERIOR = "numero_exterior";
    public static final String NUMERO_INTERIOR = "numero_interior";
    public static final String SUCURSAL_ID = "sucursal_id";
    public static final String PROMOTOR_ID = "promotor_id";
    public static final String GRUPO_ID = "grupo_id";
    public static final String AUTORIZACION_IMPRESA = "autorizacion_impresa";
    public static final String PREAFILIADO = "preafiliado";
    public static final String ESTATUS_CLIENTE_ID = "estatus_cliente_id";
    public static final String MOTIVO_RECHAZO_ID = "motivo_rechazo_id";
    public static final String MOTIVO_RECHAZO = "motivo_rechazo";
    public static final String CONSECUTIVO_GRUPO = "consecutivo_grupo";
    public static final String CONSECUTIVO_CLIENTE = "consecutivo_cliente";
    public static final String FECHA_SINCRONIZACION = "fecha_sincronizacion";
    public static final String FECHA_CONSULTA_BURO = "fecha_consulta_buro";
    public static final String CODIGO_POSTAL_NEGOCIO = "codigo_postal_negocio";
    public static final String ESTADO_NEGOCIO_ID = "estado_negocio_id";
    public static final String LOCALIDAD_NEGOCIO = "localidad_negocio";
    public static final String DELEGACION_NEGOCIO = "delegacion_negocio";
    public static final String COLONIA_NEGOCIO = "colonia_negocio";
    public static final String CALLE_NEGOCIO = "calle_negocio";
    public static final String NUMERO_EXTERIOR_NEGOCIO = "numero_exterior_negocio";
    public static final String NUMERO_INTERIOR_NEGOCIO = "numero_interior_negocio";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String DELETED_AT = "deleted_at";

    @DatabaseField(generatedId = true, columnName = ID)
    private int id;
    @DatabaseField(columnName = NOMBRE)
    private String nombre;
    @DatabaseField(columnName = APELLIDO_PATERNO)
    private String apellidoPaterno;
    @DatabaseField(columnName = APELLIDO_MATERNO)
    private String apellidoMaterno;
    @DatabaseField(columnName = TIPO_CLIENTE_ID)
    private int tipoClienteId;
    @DatabaseField(columnName = RFC)
    private String rfc;
    @DatabaseField(columnName = LUGAR_NACIMIENTO_ID)
    private int lugarNacimientoId;
    @DatabaseField(columnName = FECHA_NACIMIENTO)
    private Date fechaNacimiento;
    @DatabaseField(columnName = ESTADO_CIVIL_ID)
    private int estadoCivilId;
    @DatabaseField(columnName = GENERO_ID)
    private int generoId;
    @DatabaseField(columnName = NACIONALIDAD_ID)
    private int nacionalidadId;
    @DatabaseField(columnName = TELEFONO_CELULAR)
    private String telefonoCelular;
    @DatabaseField(columnName = COMPANIA_CELULAR_ID)
    private int companiaCelularId;
    @DatabaseField(columnName = IDENTIFICACION_ID)
    private int identificacionId;
    @DatabaseField(columnName = NUMERO_IDENTIFICACION)
    private String numeroIdentificacion;
    @DatabaseField(columnName = CLIENTE_COMPETENCIA)
    private int clienteCompetencia;
    @DatabaseField(columnName = COMPETENCIA_ID)
    private int competenciaId;
    @DatabaseField(columnName = PRESTAMO_SOLICITADO_ID)
    private int prestamoSolicitadoId;
    @DatabaseField(columnName = PRESTAMO_SOLICITADO)
    private String prestamoSolicitado;
    @DatabaseField(columnName = DESTINO_PRESTAMO_ID)
    private int destinoPrestamoId;
    @DatabaseField(columnName = CODIGO_POSTAL)
    private int codigoPostal;
    @DatabaseField(columnName = ESTADO_ID)
    private int estadoId;
    @DatabaseField(columnName = LOCALIDAD)
    private String localidad;
    @DatabaseField(columnName = DELEGACION)
    private String delegacion;
    @DatabaseField(columnName = COLONIA)
    private String colonia;
    @DatabaseField(columnName = CALLE)
    private String calle;
    @DatabaseField(columnName = NUMERO_EXTERIOR)
    private String numeroExterior;
    @DatabaseField(columnName = NUMERO_INTERIOR)
    private String numeroInterior;
    @DatabaseField(columnName = SUCURSAL_ID)
    private int sucursalId;
    @DatabaseField(columnName = PROMOTOR_ID)
    private int promotorId;
    @DatabaseField(columnName = GRUPO_ID)
    private int grupoId;
    @DatabaseField(columnName = AUTORIZACION_IMPRESA)
    private int autorizacionImpresa;
    @DatabaseField(columnName = PREAFILIADO)
    private int preafiliado;
    @DatabaseField(columnName = ESTATUS_CLIENTE_ID)
    private int estatusClienteId;
    @DatabaseField(columnName = MOTIVO_RECHAZO_ID)
    private int motivoRechazoId;
    @DatabaseField(columnName = MOTIVO_RECHAZO)
    private String motivoRechazo;
    @DatabaseField(columnName = CONSECUTIVO_GRUPO)
    private String consecutivoGrupo;
    @DatabaseField(columnName = CONSECUTIVO_CLIENTE)
    private String consecutivoCliente;
    @DatabaseField(columnName = FECHA_SINCRONIZACION)
    private Date fechaSincronizacion;
    @DatabaseField(columnName = FECHA_CONSULTA_BURO)
    private Date fechaConsultaBuro;
    @DatabaseField(columnName = CODIGO_POSTAL_NEGOCIO)
    private int codigoPostalNegocio;
    @DatabaseField(columnName = ESTADO_NEGOCIO_ID)
    private int estadoNegocioId;
    @DatabaseField(columnName = LOCALIDAD_NEGOCIO)
    private String localidadNegocio;
    @DatabaseField(columnName = DELEGACION_NEGOCIO)
    private String delegacionNegocio;
    @DatabaseField(columnName = COLONIA_NEGOCIO)
    private String coloniaNegocio;
    @DatabaseField(columnName = CALLE_NEGOCIO)
    private String calleNegocio;
    @DatabaseField(columnName = NUMERO_EXTERIOR_NEGOCIO)
    private String numeroExteriorNegocio;
    @DatabaseField(columnName = NUMERO_INTERIOR_NEGOCIO)
    private String numeroInteriorNegocio;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(int tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getLugarNacimientoId() {
        return lugarNacimientoId;
    }

    public void setLugarNacimientoId(int lugarNacimientoId) {
        this.lugarNacimientoId = lugarNacimientoId;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(int estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public int getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(int nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public int getCompaniaCelularId() {
        return companiaCelularId;
    }

    public void setCompaniaCelularId(int companiaCelularId) {
        this.companiaCelularId = companiaCelularId;
    }

    public int getIdentificacionId() {
        return identificacionId;
    }

    public void setIdentificacionId(int identificacionId) {
        this.identificacionId = identificacionId;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getClienteCompetencia() {
        return clienteCompetencia;
    }

    public void setClienteCompetencia(int clienteCompetencia) {
        this.clienteCompetencia = clienteCompetencia;
    }

    public int getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(int competenciaId) {
        this.competenciaId = competenciaId;
    }

    public int getPrestamoSolicitadoId() {
        return prestamoSolicitadoId;
    }

    public void setPrestamoSolicitadoId(int prestamoSolicitadoId) {
        this.prestamoSolicitadoId = prestamoSolicitadoId;
    }

    public String getPrestamoSolicitado() {
        return prestamoSolicitado;
    }

    public void setPrestamoSolicitado(String prestamoSolicitado) {
        this.prestamoSolicitado = prestamoSolicitado;
    }

    public int getDestinoPrestamoId() {
        return destinoPrestamoId;
    }

    public void setDestinoPrestamoId(int destinoPrestamoId) {
        this.destinoPrestamoId = destinoPrestamoId;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
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

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public int getAutorizacionImpresa() {
        return autorizacionImpresa;
    }

    public void setAutorizacionImpresa(int autorizacionImpresa) {
        this.autorizacionImpresa = autorizacionImpresa;
    }

    public int getPreafiliado() {
        return preafiliado;
    }

    public void setPreafiliado(int preafiliado) {
        this.preafiliado = preafiliado;
    }

    public int getEstatusClienteId() {
        return estatusClienteId;
    }

    public void setEstatusClienteId(int estatusClienteId) {
        this.estatusClienteId = estatusClienteId;
    }

    public int getMotivoRechazoId() {
        return motivoRechazoId;
    }

    public void setMotivoRechazoId(int motivoRechazoId) {
        this.motivoRechazoId = motivoRechazoId;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public String getConsecutivoGrupo() {
        return consecutivoGrupo;
    }

    public void setConsecutivoGrupo(String consecutivoGrupo) {
        this.consecutivoGrupo = consecutivoGrupo;
    }

    public String getConsecutivoCliente() {
        return consecutivoCliente;
    }

    public void setConsecutivoCliente(String consecutivoCliente) {
        this.consecutivoCliente = consecutivoCliente;
    }

    public Date getFechaSincronizacion() {
        return fechaSincronizacion;
    }

    public void setFechaSincronizacion(Date fechaSincronizacion) {
        this.fechaSincronizacion = fechaSincronizacion;
    }

    public Date getFechaConsultaBuro() {
        return fechaConsultaBuro;
    }

    public void setFechaConsultaBuro(Date fechaConsultaBuro) {
        this.fechaConsultaBuro = fechaConsultaBuro;
    }

    public int getCodigoPostalNegocio() {
        return codigoPostalNegocio;
    }

    public void setCodigoPostalNegocio(int codigoPostalNegocio) {
        this.codigoPostalNegocio = codigoPostalNegocio;
    }

    public int getEstadoNegocioId() {
        return estadoNegocioId;
    }

    public void setEstadoNegocioId(int estadoNegocioId) {
        this.estadoNegocioId = estadoNegocioId;
    }

    public String getLocalidadNegocio() {
        return localidadNegocio;
    }

    public void setLocalidadNegocio(String localidadNegocio) {
        this.localidadNegocio = localidadNegocio;
    }

    public String getDelegacionNegocio() {
        return delegacionNegocio;
    }

    public void setDelegacionNegocio(String delegacionNegocio) {
        this.delegacionNegocio = delegacionNegocio;
    }

    public String getColoniaNegocio() {
        return coloniaNegocio;
    }

    public void setColoniaNegocio(String coloniaNegocio) {
        this.coloniaNegocio = coloniaNegocio;
    }

    public String getCalleNegocio() {
        return calleNegocio;
    }

    public void setCalleNegocio(String calleNegocio) {
        this.calleNegocio = calleNegocio;
    }

    public String getNumeroExteriorNegocio() {
        return numeroExteriorNegocio;
    }

    public void setNumeroExteriorNegocio(String numeroExteriorNegocio) {
        this.numeroExteriorNegocio = numeroExteriorNegocio;
    }

    public String getNumeroInteriorNegocio() {
        return numeroInteriorNegocio;
    }

    public void setNumeroInteriorNegocio(String numeroInteriorNegocio) {
        this.numeroInteriorNegocio = numeroInteriorNegocio;
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