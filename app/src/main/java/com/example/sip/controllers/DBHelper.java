package com.example.sip.controllers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.sip.models.Dao.CatGrupos;
import com.example.sip.models.Dao.GruposFormacion;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by alusdev on 5/31/17.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "sistema_local.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<CatGrupos, Integer> gruposDao;
    private Dao<GruposFormacion, Integer> gruposFormacionDao;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, CatGrupos.class);
            TableUtils.createTable(connectionSource, GruposFormacion.class);
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

    @Override
    public void close() {
        super.close();
        gruposDao = null;
        gruposFormacionDao = null;
    }
}
