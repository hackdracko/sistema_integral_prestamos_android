package com.example.sip.controllers;

import android.app.Fragment;
import android.content.Context;
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

import com.example.sip.R;
import com.example.sip.controllers.adapters.AdapterFormation;
import com.example.sip.controllers.adapters.AdapterGroup;
import com.example.sip.models.Dao.CatGrupos;
import com.example.sip.models.Dao.GruposFormacion;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupFragment extends Fragment {
    private View view;
    private ListView lv_group;
    private Button btn_add;
    private EditText txt_description;
    private String str_description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.group_layout,container,false);
        final DBHelper helper = OpenHelperManager.getHelper(getActivity(), DBHelper.class);
        ArrayList<String> options = getListGroups(helper);

        lv_group=(ListView)view.findViewById(R.id.list_group);
        final AdapterGroup adapterGroup = new AdapterGroup(getActivity(), options);
        lv_group.setAdapter(adapterGroup);
        lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("TEST");
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
                ArrayList<String> options = getListGroups(helper);
                adapterGroup.clear();
                adapterGroup.addAll(options);
                adapterGroup.notifyDataSetChanged();

            }
        });

        return view;
    }

    public void createGroup (DBHelper helper, String description){
        Dao dao;
        dao = helper.getGruposFormacionDao();
        GruposFormacion gruposFormacion = new GruposFormacion();
        //gruposFormacion.setSucursalId(1);
        //gruposFormacion.setPromotorId(1);
        //gruposFormacion.setStsGrupoclienteId(1);
        gruposFormacion.setNombreGrupo(description);
        gruposFormacion.setFechaAltaGrupo(new Date());
        //gruposFormacion.setConsecutivoGrupo(1);
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

    public ArrayList getListGroups (DBHelper helper){
        Dao dao;
        try {
            dao = helper.getGruposFormacionDao();
            List<GruposFormacion> grupos = dao.queryForAll();
            ArrayList<String> options = new ArrayList<String>();
            for (GruposFormacion gruposFormacion: grupos){
                options.add(gruposFormacion.getNombreGrupo());
                System.out.println(gruposFormacion.getFechaAltaGrupo());
            }
            return options;
        } catch (SQLException e) {
            System.out.println("Error creando usuario");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
