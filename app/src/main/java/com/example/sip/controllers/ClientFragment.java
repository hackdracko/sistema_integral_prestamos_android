package com.example.sip.controllers;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.example.sip.R;
import com.example.sip.controllers.adapters.CustomAdapterClient;
import com.example.sip.controllers.adapters.CustomAdapterGroup;
import com.example.sip.models.Dao.ClientesFormacion;
import com.example.sip.models.Dao.GruposFormacion;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientFragment extends Fragment implements CustomAdapterClient.customClickListener {
    private View view;
    private ListView lv_client;
    private FloatingActionButton fab;
    public static String SessionPreference = "SessionPreference";
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.client_layout,container,false);
        final DBHelper helper = OpenHelperManager.getHelper(getActivity(), DBHelper.class);
        ArrayList<ClientesFormacion> list = getListClients(helper);

        lv_client = (ListView)view.findViewById(R.id.list_client);

        final CustomAdapterClient customAdapterClient = new CustomAdapterClient(getActivity(), list);
        lv_client.setAdapter(customAdapterClient);
        customAdapterClient.setCustomClickListener(this);
        /*lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("grupo_id", (int) id);
                GroupDetailFragment groupDetailFragment = new GroupDetailFragment();
                groupDetailFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
                fragmentTransaction
                        .replace(R.id.content_main, groupDetailFragment)
                        .addToBackStack(null)
                        .commit();
                fragmentManager.executePendingTransactions();
            }
        });*/

        fab = (FloatingActionButton)view.findViewById(R.id.fab_client);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Agrega Cliente");
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
                fragmentTransaction
                        .replace(R.id.content_main, new ClientAddFragment())
                        .addToBackStack(null)
                        .commit();
                fragmentManager.executePendingTransactions();
            }
        });

        return view;
    }

    public void getListAdapter (DBHelper helper) {
        ArrayList<ClientesFormacion> list = getListClients(helper);
        final CustomAdapterClient customAdapterClient = new CustomAdapterClient(getActivity(), list);
        lv_client.setAdapter(customAdapterClient);
        customAdapterClient.setCustomClickListener(this);
    }

    @Override
    public void onImageClickListener(int position, final int idGrupo, String description, int estatusGrupo) {
        if(estatusGrupo == 0) {
            final DBHelper helper = OpenHelperManager.getHelper(getActivity(), DBHelper.class);
            final Map<String, String> params = new HashMap<>();
            sharedPreferences = getActivity().getSharedPreferences(SessionPreference, Context.MODE_PRIVATE);
            final int sucursal_id = sharedPreferences.getInt("usuario_id", 0);
            final int promotor_id = sharedPreferences.getInt("promotor_id", 0);

            DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            System.out.println("Hecho");
                            GruposFormacion grupo = getGroup(helper, idGrupo);
                            String fecha_alat_grupo = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS").format(grupo.getFechaAltaGrupo());
                            params.put("sucursal_id", String.valueOf(sucursal_id));
                            params.put("promotor_id", String.valueOf(promotor_id));
                            params.put("sts_grupocliente_id", "1");
                            params.put("nombre_grupo", grupo.getNombreGrupo());
                            params.put("fecha_alta_grupo", fecha_alat_grupo);
                            params.put("promotor_alta", String.valueOf(sucursal_id));
                            params.put("consecutivo_grupo", "1");

                            System.out.println("Creando Grupo ...");
                            final ProgressDialog loading = Utils.loading(getActivity(), "Información", "Subiendo Información.");
                            loading.show();
                            AsyncController.volleyCallbackString(getActivity(), Request.Method.POST, AppConfig.URL_GRUPOFORMACION_CREATE, loading, null, null, params, new AsyncController.VolleyCallback() {
                                @Override
                                public void onSuccessResponse(String result) {
                                    updateGroup(helper, idGrupo);
                                    getListAdapter(helper);
                                    loading.hide();
                                }
                            });
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Estas seguro de subir el grupo " + description + "?").setPositiveButton("Aceptar", dialog)
                    .setNegativeButton("Cancelar", dialog).show();
        }else{
            Context context = getActivity().getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, "El grupo " + description + " ya se encuentra en la base principal", duration);
            toast.show();
        }
    }

    public GruposFormacion getGroup (DBHelper helper, int id){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            GruposFormacion grupo = (GruposFormacion) dao.queryForId(id);
            return grupo;
        } catch (SQLException e) {
            System.out.println("Error creando usuario");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ClientesFormacion> getListClients (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getClientesFormacionDao();
            QueryBuilder<ClientesFormacion, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.query();
            PreparedQuery<ClientesFormacion> preparedQuery = queryBuilder.prepare();

            ArrayList<ClientesFormacion> clientes = new ArrayList<ClientesFormacion>();
            List<ClientesFormacion> res = dao.query(preparedQuery);
            for (ClientesFormacion clientesFormacion : res){
                ClientesFormacion clientesFormacionResult = new ClientesFormacion();
                clientesFormacionResult.setId(clientesFormacion.getId());
                clientesFormacionResult.setNombre(clientesFormacion.getNombre());
                clientes.add(clientesFormacion);
            }
            return clientes;
        } catch (SQLException e) {
            System.out.println("Error creando usuario");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createGroup (DBHelper helper, String description){
        sharedPreferences = getActivity().getSharedPreferences(SessionPreference, Context.MODE_PRIVATE);
        final int sucursal_id = sharedPreferences.getInt("usuario_id", 0);
        final int promotor_id = sharedPreferences.getInt("promotor_id", 0);
        Dao dao;
        dao = helper.getGruposFormacionDao();
        GruposFormacion gruposFormacion = new GruposFormacion();
        gruposFormacion.setSucursalId(sucursal_id);
        gruposFormacion.setPromotorId(promotor_id);
        gruposFormacion.setStsGrupoclienteId(0);
        gruposFormacion.setNombreGrupo(description);
        gruposFormacion.setFechaAltaGrupo(new Date());
        gruposFormacion.setConsecutivoGrupo("1");
        gruposFormacion.setCreatedAt(new Date());
        gruposFormacion.setUpdatedAt(new Date());

        try {
            dao.create(gruposFormacion);
            Context context = getActivity();
            CharSequence text = "Se creo el grupo exitosamente";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
            return;
        } catch (java.sql.SQLException e) {
            System.out.println("Error creando");
            e.printStackTrace();
        }
    }

    public void updateGroup (DBHelper helper, int id){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            UpdateBuilder<GruposFormacion, String> updateBuilder = dao.updateBuilder();
            updateBuilder.updateColumnValue(GruposFormacion.STS_GRUPOCLIENTE_ID, 1);
            updateBuilder.where().eq(GruposFormacion.ID, id);
            dao.update(updateBuilder.prepare());
        } catch (SQLException e) {
            System.out.println("Error al Actualizar Usuario");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
