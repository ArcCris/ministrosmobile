package com.example.copazo.ministros.Model.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.copazo.ministros.MapsActivity;
import com.example.copazo.ministros.Model.Persona;
import com.example.copazo.ministros.R;

import java.util.ArrayList;
import java.util.List;

public class ListadoPersonasAdapter extends BaseAdapter{

    private List<Persona> lPersona;
    private Context mContext;

    public ListadoPersonasAdapter(Context mContext, List<Persona> persona){
        this.mContext = mContext;
        this.lPersona = persona;
    }


    @Override
    public int getCount() {
        return lPersona.size();
    }

    @Override
    public Object getItem(int position) {
        return lPersona.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View view;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.helper_listado_personas, null);

        final TextView numeroPersona = view.findViewById(R.id.numeroPersona);
        final TextView nombrePersona = view.findViewById(R.id.nombrePersona);
        final TextView direccionPersona = view.findViewById(R.id.direccionPersona);
        final TextView telefonoPersona = view.findViewById(R.id.llamarPersona);


        numeroPersona.setText(String.valueOf(position+1));
        nombrePersona.setText(lPersona.get(position).getNombreCompleto());
        direccionPersona.setText(lPersona.get(position).getDireccion().getNombre());

        telefonoPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + lPersona.get(position).getTelefono()));
                mContext.startActivity(intent);
            }
        });

        direccionPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MapsActivity.class);
                intent.putExtra("lat", lPersona.get(position).getDireccion().getLat());
                intent.putExtra("lng", lPersona.get(position).getDireccion().getLng());
                intent.putExtra("nombre", lPersona.get(position).getDireccion().getNombre());
                mContext.startActivity(intent);
            }
        });



        return view;
    }
}
