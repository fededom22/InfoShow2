package com.fededom.infoshow.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fededom.infoshow.Activities.DetailActivity;
import com.fededom.infoshow.Genre;
import com.fededom.infoshow.Pojos.Evento;
import com.fededom.infoshow.R;
import com.fededom.infoshow.ViewHolders.DestacadoViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DestacadoFragment extends Fragment implements FragmentRefresher {

    private Context context;

    private DatabaseReference mDataBase;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBase = FirebaseDatabase.getInstance().getReference().child("Eventos");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_fragment, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);

        FirebaseRecyclerAdapter<Evento,DestacadoViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Evento, DestacadoViewHolder>(
                Evento.class,
                R.layout.fragment_destacado_item,
                DestacadoViewHolder.class,
                mDataBase
        ) {
            @Override
            protected void populateViewHolder(DestacadoViewHolder viewHolder, Evento model, int position) {


                viewHolder.setTitulo(model.getTitulo());
                viewHolder.setAmPM();
                viewHolder.setHora(model.getFechaHora());
                viewHolder.setFecha(model.getFechaHora());
                viewHolder.setLugar(model.getLugar());
                viewHolder.setDescripcion(model.getDescripcion());
                viewHolder.setImagen(getActivity(),model.getImagen());
            }
            @Override
            public DestacadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                 DestacadoViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                viewHolder.setOnClickListener(new DestacadoViewHolder.ClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        startActivity(intent);
                    }

                });
                return viewHolder;
            }
        };
        rv.setAdapter(firebaseRecyclerAdapter);
        rv.setAdapter(firebaseRecyclerAdapter);
        rv.setLayoutManager( (new LinearLayoutManager(this.getActivity())));
        return rootView;
    }

    @Override
    public void updateUI(Genre genre) {
        Toast.makeText(getActivity(), "update to position " + genre.getValue() + " inside DestacadoFragment", Toast.LENGTH_SHORT).show();
    }
}

