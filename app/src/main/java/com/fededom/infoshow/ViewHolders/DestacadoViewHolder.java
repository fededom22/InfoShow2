package com.fededom.infoshow.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fededom.infoshow.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Fededom on 16/05/2017.
 */
public class DestacadoViewHolder extends RecyclerView.ViewHolder {

    View mView;


    public DestacadoViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());

            }
        });
    }

    //Interface to send callbacks...
    public interface ClickListener{
        public void onItemClick(View view, int position);
    }

    private ClickListener mClickListener;



    public void setOnClickListener(ClickListener clickListener){
        mClickListener = clickListener;
    }


    public void setTitulo(String titulo) {

        TextView evento_titulo = (TextView) mView.findViewById(R.id.desTxtNombreEvento);
        evento_titulo.setText(titulo);
    }

    public void setHora(String horaFecha) {

        TextView evento_Hora = (TextView) mView.findViewById(R.id.desTxtTime);
        evento_Hora.setText("8:00");
    }
    public void setFecha(String horaFecha) {

        TextView evento_Fecha = (TextView) mView.findViewById(R.id.desTxtFecha);
        evento_Fecha.setText("Martes , 22 Julio");
    }


    public void setLugar(String lugar) {

        TextView evento_lugar = (TextView) mView.findViewById(R.id.desTxtLugarEvento);
        evento_lugar.setText("Teatro Argentino 50 e/ 9 Y 10 ");
    }

    public void setAmPM() {

        TextView evento_descripcion = (TextView) mView.findViewById(R.id.desTxtAmPm);
        evento_descripcion.setText("pm");
    }

    public void setDescripcion(String descripcion) {

        TextView evento_descripcion = (TextView) mView.findViewById(R.id.desTxtEntrada);
        evento_descripcion.setText("Valor Entrada $300");
    }

    public void setImagen(Context ctx , String imagen) {
        ImageView evento_imagen = (ImageView)mView.findViewById(R.id.desImgEvento);
        Picasso.with(ctx).load(imagen).into(evento_imagen);
    }


/*
    public void setTitulo(String titulo) {

        TextView evento_titulo = (TextView) mView.findViewById(R.id.evento_titulo);
        evento_titulo.setText(titulo);
    }

    public void setHoraFecha(String horaFecha) {

        TextView evento_HoraFecha = (TextView) mView.findViewById(R.id.evento_horaFecha);
        evento_HoraFecha.setText(horaFecha);
    }


    public void setLugar(String lugar) {

        TextView evento_lugar = (TextView) mView.findViewById(R.id.evento_lugar);
        evento_lugar.setText(lugar);
    }

    public void setDescripcion(String descripcion) {

        TextView evento_descripcion = (TextView) mView.findViewById(R.id.evento_desc);
        evento_descripcion.setText(descripcion);
    }


    public void setImagen(Context ctx , String imagen) {
        ImageView evento_imagen = (ImageView)mView.findViewById(R.id.evento_imagen);
        Picasso.with(ctx).load(imagen).into(evento_imagen);
    }*/
}