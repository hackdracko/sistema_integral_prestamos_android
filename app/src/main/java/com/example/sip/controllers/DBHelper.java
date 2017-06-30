package com.example.sip.controllers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.sip.models.Dao.CatCompaniaCelulares;
import com.example.sip.models.Dao.CatEstadosCiviles;
import com.example.sip.models.Dao.CatGeneros;
import com.example.sip.models.Dao.CatGrupos;
import com.example.sip.models.Dao.CatNacionalidades;
import com.example.sip.models.Dao.ClientesFormacion;
import com.example.sip.models.Dao.GruposFormacion;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.Date;

/**
 * Created by alusdev on 5/31/17.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "sistema_local.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<CatEstadosCiviles, Integer> catEstadosCivilesDao;
    private Dao<CatGeneros, Integer> catGenerosDao;
    private Dao<CatNacionalidades, Integer> catNacionalidadesDao;
    private Dao<CatCompaniaCelulares, Integer> catCompaniaCelularesDao;
    private Dao<CatGrupos, Integer> gruposDao;
    private Dao<GruposFormacion, Integer> gruposFormacionDao;
    private Dao<ClientesFormacion, Integer> clientesFormacionDao;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, CatEstadosCiviles.class);
            TableUtils.createTable(connectionSource, CatGeneros.class);
            TableUtils.createTable(connectionSource, CatNacionalidades.class);
            TableUtils.createTable(connectionSource, CatCompaniaCelulares.class);
            TableUtils.createTable(connectionSource, CatGrupos.class);
            TableUtils.createTable(connectionSource, GruposFormacion.class);
            TableUtils.createTable(connectionSource, ClientesFormacion.class);
            /*
                CREATE CAT ESTADOS CIVILES
             */
            createCatEstadosCiviles("Soltero/a");
            createCatEstadosCiviles("Casado/a");
            createCatEstadosCiviles("Divorciado/a");
            createCatEstadosCiviles("Viudo/a");
            createCatEstadosCiviles("Separado/a");
            /*
                CREATE CAT GENEROS
             */
            createCatGeneros("Masculino");
            createCatGeneros("Femenino");
            /*
                CREATE CAT NACIONALIDADES
             */
            createCatNacionalidades("Mexicana");
            createCatNacionalidades("Extranjera");
            /*
                CREATE CAT COMPANIA CELULARES
             */
            createCatCompaniaCelulares("Telcel");
            createCatCompaniaCelulares("Movistar");
            createCatCompaniaCelulares("Iusacell");
            createCatCompaniaCelulares("Otros");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        onCreate(db, connectionSource);
    }

    public Dao<CatEstadosCiviles, Integer> getEstadosCivilesDao() throws SQLException {
        if (catEstadosCivilesDao == null) {
            try {
                catEstadosCivilesDao = getDao(CatEstadosCiviles.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return catEstadosCivilesDao;
    }

    public Dao<CatGeneros, Integer> getCatGenerosDao() throws SQLException {
        if (catGenerosDao == null) {
            try {
                catGenerosDao = getDao(CatGeneros.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return catGenerosDao;
    }

    public Dao<CatNacionalidades, Integer> getCatNacionalidadesDao() throws SQLException {
        if (catNacionalidadesDao == null) {
            try {
                catNacionalidadesDao = getDao(CatNacionalidades.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return catNacionalidadesDao;
    }

    public Dao<CatCompaniaCelulares, Integer> getCatCompaniaCelularesDao() throws SQLException {
        if (catCompaniaCelularesDao == null) {
            try {
                catCompaniaCelularesDao = getDao(CatCompaniaCelulares.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return catCompaniaCelularesDao;
    }

    public Dao<CatGrupos, Integer> getCatGrupoDao() throws SQLException {
        if (gruposDao == null) {
            try {
                gruposDao = getDao(CatGrupos.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return gruposDao;
    }

    public Dao<GruposFormacion, Integer> getGruposFormacionDao() throws SQLException {
        if (gruposFormacionDao == null) {
            try {
                gruposFormacionDao = getDao(GruposFormacion.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return gruposFormacionDao;
    }

    public Dao<ClientesFormacion, Integer> getClientesFormacionDao() throws SQLException {
        if (clientesFormacionDao == null) {
            try {
                clientesFormacionDao = getDao(ClientesFormacion.class);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return clientesFormacionDao;
    }

    @Override
    public void close() {
        super.close();
        catEstadosCivilesDao = null;
        catGenerosDao = null;
        catNacionalidadesDao = null;
        catCompaniaCelularesDao = null;
        gruposDao = null;
        gruposFormacionDao = null;
        clientesFormacionDao = null;

    }

    public void createCatEstadosCiviles (String description){
        Dao dao;
        dao = this.getEstadosCivilesDao();
        CatEstadosCiviles estadoCivil = new CatEstadosCiviles();
        estadoCivil.setDescripcion(description);
        estadoCivil.setCreatedAt(new Date());
        estadoCivil.setUpdatedAt(new Date());

        try {
            dao.create(estadoCivil);
            return;
        } catch (java.sql.SQLException e) {
            System.out.println("Error creando Catalogo Estados Civiles");
            e.printStackTrace();
        }
    }

    public void createCatGeneros (String description){
        Dao dao;
        dao = this.getCatGenerosDao();
        CatGeneros genero = new CatGeneros();
        genero.setDescripcion(description);
        genero.setCreatedAt(new Date());
        genero.setUpdatedAt(new Date());

        try {
            dao.create(genero);
            return;
        } catch (java.sql.SQLException e) {
            System.out.println("Error creando Catalogo Generos");
            e.printStackTrace();
        }
    }

    public void createCatNacionalidades (String description){
        Dao dao;
        dao = this.getCatNacionalidadesDao();
        CatNacionalidades nacionalidad = new CatNacionalidades();
        nacionalidad.setDescripcion(description);
        nacionalidad.setCreatedAt(new Date());
        nacionalidad.setUpdatedAt(new Date());

        try {
            dao.create(nacionalidad);
            return;
        } catch (java.sql.SQLException e) {
            System.out.println("Error creando Catalogo Nacionalidades");
            e.printStackTrace();
        }
    }

    public void createCatCompaniaCelulares (String description){
        Dao dao;
        dao = this.getCatCompaniaCelularesDao();
        CatCompaniaCelulares companiaCelular = new CatCompaniaCelulares();
        companiaCelular.setDescripcion(description);
        companiaCelular.setCreatedAt(new Date());
        companiaCelular.setUpdatedAt(new Date());

        try {
            dao.create(companiaCelular);
            return;
        } catch (java.sql.SQLException e) {
            System.out.println("Error creando Catalogo Compania Celulares");
            e.printStackTrace();
        }
    }
}
