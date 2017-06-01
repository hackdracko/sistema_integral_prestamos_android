package com.example.sip.controllers;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sip.R;
import com.example.sip.controllers.adapters.AdapterFormation;

import java.util.ArrayList;

public class FormationFragment extends Fragment {
    View view;
    ListView lv_formacion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.formacion_layout,container,false);
        ArrayList<String> options = new ArrayList<String>();
        options.add("Formación");
        options.add("Prestamos");
        options.add("Configuración");

        lv_formacion=(ListView)view.findViewById(R.id.list_formacion);
        AdapterFormation adapterFormation = new AdapterFormation(getActivity(), options);
        lv_formacion.setAdapter(adapterFormation);
        lv_formacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
                if (position == 0){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left);
                    fragmentTransaction
                            .replace(R.id.content_main, new GroupFragment())
                            .addToBackStack(null)
                            .commit();
                    fragmentManager.executePendingTransactions();
                }
            }
        });

        return view;
    }
}
