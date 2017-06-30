package com.example.sip.controllers.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sip.R;

import java.util.ArrayList;

/**
 * Created by alusdev on 4/28/17.
 */

public class AdapterFormationMenu extends ArrayAdapter<String> {
    ArrayList<String> options;
    Context c;
    LayoutInflater inflater;

    public AdapterFormationMenu(Context context, ArrayList options){
        super(context, R.layout.formacion_list, options);
        this.c = context;
        this.options = options;
    }

    public class ViewHolder{
        TextView description;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.formacion_list, null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.description = (TextView) convertView.findViewById(R.id.text_option);
        holder.description.setText(options.get(position));
        return convertView;
    }
}
