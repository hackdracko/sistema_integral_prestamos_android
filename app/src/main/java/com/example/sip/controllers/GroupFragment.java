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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.example.sip.R;
import com.example.sip.controllers.adapters.CustomAdapterGroup;
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

public class GroupFragment extends Fragment implements CustomAdapterGroup.customClickListener {
    private View view;
    private ListView lv_group;
    private Button btn_add;
    private EditText txt_description;
    private String str_description;
    public static String SessionPreference = "SessionPreference";
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.group_layout,container,false);
        final DBHelper helper = OpenHelperManager.getHelper(getActivity(), DBHelper.class);
        ArrayList<GruposFormacion> list = getListGroups(helper);

        lv_group = (ListView)view.findViewById(R.id.list_group);

        final CustomAdapterGroup customAdapterGroup = new CustomAdapterGroup(getActivity(), list);
        lv_group.setAdapter(customAdapterGroup);
        customAdapterGroup.setCustomClickListener(this);
        lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        });

        btn_add = (Button)view.findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_description = (EditText)view.findViewById(R.id.txt_description);
                if(txt_description.getText().length() < 3){
                    Context context = getActivity();
                    CharSequence text = "La descripción del grupo debe tener al menos 3 caracteres";
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                System.out.println(txt_description.getText().length());
                str_description = txt_description.getText().toString();
                createGroup(helper, str_description);
                /*
                * HIDE KEYBOARD
                */
                InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                /*
                * CLEAR EDITTEXT
                */
                txt_description.setText("");
                ArrayList<GruposFormacion> list = getListGroups(helper);
                customAdapterGroup.notifyDataSetChanged();
                customAdapterGroup.updateResults(list);

            }
        });

        return view;
    }

    public void getListAdapter (DBHelper helper) {
        ArrayList<GruposFormacion> list = getListGroups(helper);
        final CustomAdapterGroup customAdapterGroup = new CustomAdapterGroup(getActivity(), list);
        lv_group.setAdapter(customAdapterGroup);
        customAdapterGroup.setCustomClickListener(this);
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

    public ArrayList<GruposFormacion> getListGroups (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            QueryBuilder<GruposFormacion, Integer> queryBuilder = dao.queryBuilder();
            queryBuilder.query();
            PreparedQuery<GruposFormacion> preparedQuery = queryBuilder.prepare();

            ArrayList<GruposFormacion> grupos = new ArrayList<GruposFormacion>();
            List<GruposFormacion> res = dao.query(preparedQuery);
            for (GruposFormacion gruposFormacion : res){
                GruposFormacion gruposFormacionResult = new GruposFormacion();
                gruposFormacionResult.setId(gruposFormacion.getId());
                gruposFormacionResult.setNombreGrupo(gruposFormacion.getNombreGrupo());
                gruposFormacionResult.setStsGrupoclienteId(gruposFormacion.getStsGrupoclienteId());
                grupos.add(gruposFormacionResult);
            }
            return grupos;
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
