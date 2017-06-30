package com.example.sip.controllers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sip.R;
import com.example.sip.models.Dao.ClientesFormacion;
import com.example.sip.models.Dao.GruposFormacion;

import java.util.ArrayList;

/**
 * Created by alusdev on 6/5/17.
 */

public class CustomAdapterClient extends BaseAdapter{
    Context context;
    ArrayList<ClientesFormacion> clientesFormaciones;
    LayoutInflater inflater;
    customClickListener customClickListener;



    public interface customClickListener{
        public void onImageClickListener(int position, int idGrupo, String description, int estatusGrupo);
    }

    public void setCustomClickListener(customClickListener listener){
        this.customClickListener = listener;
    }


    public CustomAdapterClient(Context context, ArrayList<ClientesFormacion> clientesFormaciones) {
        this.context = context;
        this.clientesFormaciones = clientesFormaciones;
    }

    @Override
    public int getCount() {
        return clientesFormaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return clientesFormaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientesFormaciones.get(position).getId();
    }

    public class ViewHolder{
        TextView description;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.client_list, null);
        }
        final CustomAdapterClient.ViewHolder holder = new CustomAdapterClient.ViewHolder();
        holder.description = (TextView) convertView.findViewById(R.id.text_option);
        holder.description.setText(clientesFormaciones.get(position).getNombre());
        holder.img = (ImageView) convertView.findViewById(R.id.img_sync);
        holder.img.setImageResource(R.drawable.arrow_update);
        /*if(clientesFormaciones.get(position).getStsGrupoclienteId() == 0){
            holder.img.setBackgroundResource(R.color.colorRed);
        }else if(clientesFormaciones.get(position).getStsGrupoclienteId() == 1) {
            holder.img.setBackgroundResource(R.color.colorWarning);
        }else if(clientesFormaciones.get(position).getStsGrupoclienteId() == 2) {
            holder.img.setBackgroundResource(R.color.colorSuccess);
        }
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(customClickListener != null){
                    customClickListener.onImageClickListener(position,
                                                            clientesFormaciones.get(position).getId(),
                                                            clientesFormaciones.get(position).getNombreGrupo(),
                                                            clientesFormaciones.get(position).getStsGrupoclienteId());
                }
            }
        });*/
        return convertView;
    }

    public void updateResults(ArrayList list){
        clientesFormaciones = list;
        notifyDataSetChanged();
    }
}
