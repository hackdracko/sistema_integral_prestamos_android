package com.example.sip.controllers.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sip.R;
import com.example.sip.models.Dao.GruposFormacion;

import java.util.ArrayList;

/**
 * Created by alusdev on 6/5/17.
 */

public class CustomAdapterGroup extends BaseAdapter{
    Context context;
    ArrayList<GruposFormacion> gruposFormaciones;
    LayoutInflater inflater;
    customClickListener customClickListener;



    public interface customClickListener{
        public void onImageClickListener(int position, int idGrupo, String description, int estatusGrupo);
    }

    public void setCustomClickListener(customClickListener listener){
        this.customClickListener = listener;
    }


    public CustomAdapterGroup(Context context, ArrayList<GruposFormacion> gruposFormaciones) {
        this.context = context;
        this.gruposFormaciones = gruposFormaciones;
    }

    @Override
    public int getCount() {
        return gruposFormaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return gruposFormaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return gruposFormaciones.get(position).getId();
    }

    public class ViewHolder{
        TextView description;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.group_list, null);
        }
        final CustomAdapterGroup.ViewHolder holder = new CustomAdapterGroup.ViewHolder();
        holder.description = (TextView) convertView.findViewById(R.id.text_option);
        holder.description.setText(gruposFormaciones.get(position).getNombreGrupo());
        holder.img = (ImageView) convertView.findViewById(R.id.img_sync);
        holder.img.setImageResource(R.drawable.arrow_update);
        if(gruposFormaciones.get(position).getStsGrupoclienteId() == 0){
            holder.img.setBackgroundResource(R.color.colorRed);
        }else if(gruposFormaciones.get(position).getStsGrupoclienteId() == 1) {
            holder.img.setBackgroundResource(R.color.colorWarning);
        }else if(gruposFormaciones.get(position).getStsGrupoclienteId() == 2) {
            holder.img.setBackgroundResource(R.color.colorSuccess);
        }
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customClickListener != null){
                    customClickListener.onImageClickListener(position,
                                                            gruposFormaciones.get(position).getId(),
                                                            gruposFormaciones.get(position).getNombreGrupo(),
                                                            gruposFormaciones.get(position).getStsGrupoclienteId());
                }
            }
        });
        return convertView;
    }

    public void updateResults(ArrayList list){
        gruposFormaciones = list;
        notifyDataSetChanged();
    }
}
