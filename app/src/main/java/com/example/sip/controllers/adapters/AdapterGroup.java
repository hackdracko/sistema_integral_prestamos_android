package com.example.sip.controllers.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sip.R;
import com.example.sip.controllers.GroupFragment;
import com.example.sip.models.Dao.GruposFormacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alusdev on 4/28/17.
 */

public class AdapterGroup extends ArrayAdapter<GroupFragment> {
    ArrayList<GruposFormacion> list;
    Context c;
    LayoutInflater inflater;
    customClickListener customClickListener;



    public interface customClickListener{
        public void onImageClickListener(int position);
    }

    public void setCustomClickListener(customClickListener listener){
        this.customClickListener = listener;
    }

    public AdapterGroup(Context context, ArrayList list){
        super(context, R.layout.group_list, list);
        //super(context, R.layout.group_list, list);
        this.c = context;
        this.list = list;
    }

    public class ViewHolder{
        TextView description;
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.group_list, null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.description = (TextView) convertView.findViewById(R.id.text_option);
        holder.description.setText(list.get(position).getNombreGrupo());
        holder.img = (ImageView) convertView.findViewById(R.id.img_sync);
        holder.img.setImageResource(R.drawable.ic_menu_camera);
        System.out.println("-------------");
        System.out.println(list.get(position).getNombreGrupo());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customClickListener != null){
                    customClickListener.onImageClickListener(position);
                }
            }
        });
        return convertView;
    }
}
