package com.example.sip.controllers;

import android.app.AlertDialog;
import android.app.Fragment;
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
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupDetailFragment extends Fragment {
    private View view;
    private ListView lv_group;
    private Button btn_edit, btn_auth, btn_delete;
    private EditText txt_description;
    private String str_description;
    public static String SessionPreference = "SessionPreference";
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.group_detail_layout,container,false);
        Bundle bundle = this.getArguments();
        final int id = bundle.getInt("grupo_id");

        final DBHelper helper = OpenHelperManager.getHelper(getActivity(), DBHelper.class);
        GruposFormacion gruposFormacion = getGroup(helper, id);

        txt_description = (EditText)view.findViewById(R.id.txt_description);
        txt_description.setText(gruposFormacion.getNombreGrupo());

        btn_edit = (Button)view.findViewById(R.id.btn_edit);
        btn_auth = (Button)view.findViewById(R.id.btn_auth);
        btn_delete = (Button)view.findViewById(R.id.btn_delete);

        if(gruposFormacion.getStsGrupoclienteId() == 0){
            btn_auth.setVisibility(View.INVISIBLE);
        }else if(gruposFormacion.getStsGrupoclienteId() == 1){
            btn_edit.setVisibility(View.INVISIBLE);
            btn_delete.setVisibility(View.INVISIBLE);
        }else if(gruposFormacion.getStsGrupoclienteId() == 2){
            btn_edit.setVisibility(View.INVISIBLE);
            btn_auth.setVisibility(View.INVISIBLE);
            btn_delete.setVisibility(View.INVISIBLE);
        }

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                if(txt_description.getText().length() < 3){
                                    Context context = getActivity();
                                    CharSequence text = "La descripción del grupo debe tener al menos 3 caracteres";
                                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                str_description = txt_description.getText().toString();
                                updateGroup(helper, id, str_description);
                                /*
                                * HIDE KEYBOARD
                                */
                                InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                Context context = getActivity();
                                CharSequence text = "El grupo se edito correctamente";
                                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Estas seguro de Editar este grupo?").setPositiveButton("Aceptar", dialog)
                        .setNegativeButton("Cancelar", dialog).show();
            }
        });

        btn_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_description = txt_description.getText().toString();
                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                authGroup(helper, id);
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Estas seguro de Autorizar el grupo " + str_description + "?").setPositiveButton("Aceptar", dialog)
                        .setNegativeButton("Cancelar", dialog).show();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_description = txt_description.getText().toString();
                DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                deleteGroup(helper, id);
                                Context context = getActivity();
                                CharSequence text = "El grupo se elimino correctamente";
                                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                                toast.show();
                                getFragmentManager().popBackStack();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Estas seguro de Borrar el grupo " + str_description + "?").setPositiveButton("Aceptar", dialog)
                        .setNegativeButton("Cancelar", dialog).show();
            }
        });

        return view;
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

    public void updateGroup (DBHelper helper, int id, String name){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            UpdateBuilder<GruposFormacion, String> updateBuilder = dao.updateBuilder();
            updateBuilder.updateColumnValue(GruposFormacion.NOMBRE_GRUPO, name);
            updateBuilder.updateColumnValue(GruposFormacion.UPDATED_AT, new Date());
            updateBuilder.where().eq(GruposFormacion.ID, id);
            dao.update(updateBuilder.prepare());
        } catch (SQLException e) {
            System.out.println("Error al Actualizar Usuario");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup (DBHelper helper, int id){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            DeleteBuilder<GruposFormacion, String> deleteBuilder = dao.deleteBuilder();
            deleteBuilder.where().eq(GruposFormacion.ID, id);
            dao.delete(deleteBuilder.prepare());
        } catch (SQLException e) {
            System.out.println("Error al Borrar Grupo");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public void authGroup (DBHelper helper, int id){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            UpdateBuilder<GruposFormacion, String> updateBuilder = dao.updateBuilder();
            updateBuilder.updateColumnValue(GruposFormacion.STS_GRUPOCLIENTE_ID, 2);
            updateBuilder.where().eq(GruposFormacion.ID, id);
            dao.update(updateBuilder.prepare());
        } catch (SQLException e) {
            System.out.println("Error al Actualizar Usuario");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
