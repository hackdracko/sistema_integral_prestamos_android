package com.example.sip.controllers;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sip.R;
import com.example.sip.controllers.adapters.combos.AdapterSpinnerCatCompaniaCelulares;
import com.example.sip.controllers.adapters.combos.AdapterSpinnerCatEstadosCiviles;
import com.example.sip.controllers.adapters.combos.AdapterSpinnerCatGeneros;
import com.example.sip.controllers.adapters.combos.AdapterSpinnerCatNacionalidades;
import com.example.sip.models.Dao.CatCompaniaCelulares;
import com.example.sip.models.Dao.CatEstadosCiviles;
import com.example.sip.models.Dao.CatGeneros;
import com.example.sip.models.Dao.CatNacionalidades;
import com.example.sip.models.Dao.ClientesFormacion;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class ClientAddFragment extends Fragment {
    private View view;
    private LinearLayout linearlayout_cliente, linearlayout_prestamo, linearlayout_negocio;
    private Button btn_add, btn_cliente, btn_prestamo, btn_negocio;
    private EditText txt_nombre, txt_paterno, txt_materno;
    private Spinner cmb_estado_civil_id, cmb_genero_id, cmb_nacionalidad_id, cmb_compania_celular_id;
    private AdapterSpinnerCatEstadosCiviles adapterSpinnerCatEstadosCiviles;
    private AdapterSpinnerCatGeneros adapterSpinnerCatGeneros;
    private AdapterSpinnerCatNacionalidades adapterSpinnerCatNacionalidades;
    private AdapterSpinnerCatCompaniaCelulares adapterSpinnerCatCompaniaCelulares;
    public static String SessionPreference = "SessionPreference";
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.client_add_layout,container,false);
        final DBHelper helper = OpenHelperManager.getHelper(getActivity(), DBHelper.class);
        ArrayList<CatEstadosCiviles> valuesCatEstadosCiviles = getComboEstadosCiviles(helper);
        ArrayList<CatGeneros> valuesCatGeneros = getComboGeneros(helper);
        ArrayList<CatNacionalidades> valuesCatNacionalidades = getComboNacionalidades(helper);
        ArrayList<CatCompaniaCelulares> valuesCatCompaniaCelulares = getComboCompaniaCelulares(helper);

        btn_cliente = (Button) view.findViewById(R.id.btn_cliente);
        btn_prestamo = (Button) view.findViewById(R.id.btn_prestamo);
        btn_negocio = (Button) view.findViewById(R.id.btn_negocio);

        linearlayout_cliente = (LinearLayout) view.findViewById(R.id.linearlayout_cliente);
        linearlayout_prestamo = (LinearLayout) view.findViewById(R.id.linearlayout_prestamo);
        linearlayout_negocio = (LinearLayout) view.findViewById(R.id.linearlayout_negocio);

        btn_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearlayout_cliente.setVisibility(View.VISIBLE);
                linearlayout_prestamo.setVisibility(View.GONE);
                linearlayout_negocio.setVisibility(View.GONE);
            }
        });

        btn_prestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearlayout_cliente.setVisibility(View.GONE);
                linearlayout_prestamo.setVisibility(View.VISIBLE);
                linearlayout_negocio.setVisibility(View.GONE);
            }
        });

        btn_negocio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearlayout_cliente.setVisibility(View.GONE);
                linearlayout_prestamo.setVisibility(View.GONE);
                linearlayout_negocio.setVisibility(View.VISIBLE);
            }
        });

        cmb_estado_civil_id = (Spinner)view.findViewById(R.id.cmb_estado_civil_id);
        cmb_genero_id = (Spinner)view.findViewById(R.id.cmb_genero_id);
        cmb_nacionalidad_id = (Spinner)view.findViewById(R.id.cmb_nacionalidad_id);
        cmb_compania_celular_id = (Spinner)view.findViewById(R.id.cmb_compania_celular_id);

        adapterSpinnerCatEstadosCiviles = new AdapterSpinnerCatEstadosCiviles(getActivity(), android.R.layout.simple_spinner_item, valuesCatEstadosCiviles);
        cmb_estado_civil_id.setAdapter(adapterSpinnerCatEstadosCiviles);

        adapterSpinnerCatGeneros = new AdapterSpinnerCatGeneros(getActivity(), android.R.layout.simple_spinner_item, valuesCatGeneros);
        cmb_genero_id.setAdapter(adapterSpinnerCatGeneros);

        adapterSpinnerCatNacionalidades = new AdapterSpinnerCatNacionalidades(getActivity(), android.R.layout.simple_spinner_item, valuesCatNacionalidades);
        cmb_nacionalidad_id.setAdapter(adapterSpinnerCatNacionalidades);

        adapterSpinnerCatCompaniaCelulares = new AdapterSpinnerCatCompaniaCelulares(getActivity(), android.R.layout.simple_spinner_item, valuesCatCompaniaCelulares);
        cmb_compania_celular_id.setAdapter(adapterSpinnerCatCompaniaCelulares);
        /*cmb_estado_civil_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CatEstadosCiviles catEstadosCiviles = adapterSpinnerCatEstadosCiviles.getItem(position);
                System.out.println(catEstadosCiviles.getId() + "--" + catEstadosCiviles.getDescripcion());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        txt_nombre = (EditText)view.findViewById(R.id.txt_nombre);
        txt_paterno = (EditText)view.findViewById(R.id.txt_paterno);
        txt_materno = (EditText)view.findViewById(R.id.txt_materno);

        btn_add = (Button)view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientesFormacion clientesFormacion = new ClientesFormacion();
                clientesFormacion.setNombre(txt_nombre.getText().toString());
                createClient(helper, clientesFormacion);
            }
        });


        return view;
    }

    public void createClient (DBHelper helper, ClientesFormacion clientesFormacion){
        sharedPreferences = getActivity().getSharedPreferences(SessionPreference, Context.MODE_PRIVATE);
        final int sucursal_id = sharedPreferences.getInt("usuario_id", 0);
        final int promotor_id = sharedPreferences.getInt("promotor_id", 0);
        Dao dao;
        dao = helper.getClientesFormacionDao();

        try {
            dao.create(clientesFormacion);
            Context context = getActivity();
            CharSequence text = "Se creo el cliente exitosamente";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
            return;
        } catch (java.sql.SQLException e) {
            System.out.println("Error creando");
            e.printStackTrace();
        }
    }

    public ArrayList<CatEstadosCiviles> getComboEstadosCiviles (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getEstadosCivilesDao();
            QueryBuilder<CatEstadosCiviles, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.query();
            PreparedQuery<CatEstadosCiviles> preparedQuery = queryBuilder.prepare();

            ArrayList<CatEstadosCiviles> estadosCiviles = new ArrayList<>();
            List<CatEstadosCiviles> res = dao.query(preparedQuery);
            CatEstadosCiviles catEstadoCivilSelect = new CatEstadosCiviles();
            catEstadoCivilSelect.setId(0);
            catEstadoCivilSelect.setDescripcion("Selecciona el Estado Civil");
            estadosCiviles.add(catEstadoCivilSelect);
            for (CatEstadosCiviles catEstadoCivil : res){
                CatEstadosCiviles catEstadoCivilResult = new CatEstadosCiviles();
                catEstadoCivilResult.setId(catEstadoCivil.getId());
                catEstadoCivilResult.setDescripcion(catEstadoCivil.getDescripcion());
                estadosCiviles.add(catEstadoCivilResult);
            }
            return estadosCiviles;
        } catch (SQLException e) {
            System.out.println("Error " + e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CatGeneros> getComboGeneros (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getCatGenerosDao();
            QueryBuilder<CatGeneros, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.query();
            PreparedQuery<CatGeneros> preparedQuery = queryBuilder.prepare();

            ArrayList<CatGeneros> generos = new ArrayList<>();
            List<CatGeneros> res = dao.query(preparedQuery);
            CatGeneros catGeneroSelect = new CatGeneros();
            catGeneroSelect.setId(0);
            catGeneroSelect.setDescripcion("Selecciona un Genero");
            generos.add(catGeneroSelect);
            for (CatGeneros catGenero : res){
                CatGeneros catGeneroResult = new CatGeneros();
                catGeneroResult.setId(catGenero.getId());
                catGeneroResult.setDescripcion(catGenero.getDescripcion());
                generos.add(catGeneroResult);
            }
            return generos;
        } catch (SQLException e) {
            System.out.println("Error " + e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CatNacionalidades> getComboNacionalidades (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getCatNacionalidadesDao();
            QueryBuilder<CatNacionalidades, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.query();
            PreparedQuery<CatNacionalidades> preparedQuery = queryBuilder.prepare();

            ArrayList<CatNacionalidades> nacionalidades = new ArrayList<>();
            List<CatNacionalidades> res = dao.query(preparedQuery);
            CatNacionalidades catNacionalidadSelect = new CatNacionalidades();
            catNacionalidadSelect.setId(0);
            catNacionalidadSelect.setDescripcion("Selecciona una Nacionalidad");
            nacionalidades.add(catNacionalidadSelect);
            for (CatNacionalidades catNacionalidad : res){
                CatNacionalidades catNacionalidadResult = new CatNacionalidades();
                catNacionalidadResult.setId(catNacionalidad.getId());
                catNacionalidadResult.setDescripcion(catNacionalidad.getDescripcion());
                nacionalidades.add(catNacionalidadResult);
            }
            return nacionalidades;
        } catch (SQLException e) {
            System.out.println("Error " + e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CatCompaniaCelulares> getComboCompaniaCelulares (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getCatCompaniaCelularesDao();
            QueryBuilder<CatCompaniaCelulares, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.query();
            PreparedQuery<CatCompaniaCelulares> preparedQuery = queryBuilder.prepare();

            ArrayList<CatCompaniaCelulares> companiaCelulares = new ArrayList<>();
            List<CatCompaniaCelulares> res = dao.query(preparedQuery);
            CatCompaniaCelulares catCompaniaCelularSelect = new CatCompaniaCelulares();
            catCompaniaCelularSelect.setId(0);
            catCompaniaCelularSelect.setDescripcion("Selecciona una Compañia Celular");
            companiaCelulares.add(catCompaniaCelularSelect);
            for (CatCompaniaCelulares catCompaniaCelular : res){
                CatCompaniaCelulares catCompaniaCelularResult = new CatCompaniaCelulares();
                catCompaniaCelularResult.setId(catCompaniaCelular.getId());
                catCompaniaCelularResult.setDescripcion(catCompaniaCelular.getDescripcion());
                companiaCelulares.add(catCompaniaCelularResult);
            }
            return companiaCelulares;
        } catch (SQLException e) {
            System.out.println("Error " + e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
