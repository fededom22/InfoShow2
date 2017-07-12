package com.fededom.infoshow.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fededom.infoshow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private DatabaseReference mDataBase;

    private ImageView mImage;
    private TextView mTitulo;
    private TextView mDescripcion;
    private TextView mFechaHora;
    private TextView mLugar;
    private String mURLEntrdas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
       /*Intent idDest = getIntent();*/

        mImage = (ImageView) findViewById(R.id.detail_evento_imagen);
        mDescripcion = (TextView) findViewById(R.id.detail_evento_desc);
        mTitulo = (TextView) findViewById(R.id.detail_evento_titulo);
        mFechaHora = (TextView)findViewById(R.id.detail_horaFecha);
        mLugar = (TextView)findViewById(R.id.detail_lugar);

        mDataBase = FirebaseDatabase.getInstance().getReference().child("Destacadas").child("D2");
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               mDescripcion.setText(String.valueOf(dataSnapshot.child("Descripcion").getValue()));
                Picasso.with(DetailActivity.this).load(String.valueOf(dataSnapshot.child("Imagen").getValue())).into(mImage);
                mLugar.setText(String.valueOf(dataSnapshot.child("Lugar").getValue()));
                mTitulo.setText(String.valueOf(dataSnapshot.child("Titulo").getValue()));
                mFechaHora.setText(String.valueOf(dataSnapshot.child("FechaHora").getValue()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mDataBase.addListenerForSingleValueEvent(postListener);
        Button map = (Button) this.findViewById(R.id.detail_map);
        Button entradas = (Button) this.findViewById(R.id.detail_entradas);


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                startActivity(intent);

            }
        });
      entradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("http://www.plateanet.com/Teatros/COLISEO-PODESTA"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

}
