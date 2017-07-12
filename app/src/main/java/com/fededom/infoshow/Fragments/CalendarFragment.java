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
import com.fededom.infoshow.ViewHolders.CalendarViewHolder;
import com.fededom.infoshow.ViewHolders.DestacadoViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class CalendarFragment extends Fragment implements FragmentRefresher {

        private Context context;

        private DatabaseReference mDataBase;
        private RecyclerView mRecyclerView;
        private FirebaseRecyclerAdapter<Evento,CalendarViewHolder> mFirebasAdapter;

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
            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.tab_fragment, container, false);

            mRecyclerView  = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
            mRecyclerView.setHasFixedSize(true);

            setAdapter(mDataBase);
            return rootView;
        }

    private void setAdapter(DatabaseReference databaseReference) {
        mFirebasAdapter = new FirebaseRecyclerAdapter<Evento, CalendarViewHolder>(
                Evento.class,
                R.layout.fragment_calendar_item,
                CalendarViewHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(CalendarViewHolder viewHolder, Evento model, int position) {

                viewHolder.setEventName(model.getTitulo());
                viewHolder.setDateTime(model.getFechaHora());
                viewHolder.setPlace(model.getLugar());
                viewHolder.setImagen(model.getImagen());

            }
            @Override
            public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                CalendarViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
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
        mRecyclerView.setAdapter(mFirebasAdapter);
        mRecyclerView.setLayoutManager( (new LinearLayoutManager(this.getActivity())));
    }

    @Override
    public void updateUI(Genre genre) {
       // Toast.makeText(getActivity(), "update to position " + genre.getValue() + " inside CalendarFragment", Toast.LENGTH_SHORT).show();

        switch (genre.getValue()){
             case 0:
                 setAdapter(FirebaseDatabase.getInstance().getReference().child("Eventos"));
                 break;
            case 1:
                setAdapter(FirebaseDatabase.getInstance().getReference().child("Eventos").child("MUSICA"));
                break;
            }

        mFirebasAdapter.notifyDataSetChanged();

    }

}

