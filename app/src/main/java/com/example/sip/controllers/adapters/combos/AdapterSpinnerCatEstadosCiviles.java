package com.example.sip.controllers.adapters.combos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sip.R;
import com.example.sip.controllers.GroupFragment;
import com.example.sip.models.Dao.CatEstadosCiviles;
import com.example.sip.models.Dao.GruposFormacion;

import java.util.ArrayList;

/**
 * Created by alusdev on 4/28/17.
 */

public class AdapterSpinnerCatEstadosCiviles extends ArrayAdapter<CatEstadosCiviles> {
    ArrayList<CatEstadosCiviles> values;
    Context context;

    public AdapterSpinnerCatEstadosCiviles(Context context, int resourceId, ArrayList values){
        super(context, resourceId, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Nullable
    @Override
    public CatEstadosCiviles getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(values.get(position).getDescripcion());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(values.get(position).getDescripcion());
        return label;
    }
}
