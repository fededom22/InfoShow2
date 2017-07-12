package com.fededom.infoshow.ViewHolders;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fededom.infoshow.R;
import com.squareup.picasso.Picasso;


public  class CalendarViewHolder extends RecyclerView.ViewHolder {

    public CardView mCardView;
    public TextView mEventName;
    public TextView mEventPlace;
    public TextView mEventDateTime;
    public ImageView mEventImage;
    public Context ctx;


    public CalendarViewHolder(View v) {
        super(v);
        ctx = v.getContext();
        mCardView = (CardView) v.findViewById(R.id.simpleListItem_card_view);
        mEventName = (TextView) v.findViewById(R.id.simpleListItem_name);
        mEventDateTime = (TextView) v.findViewById(R.id.simpleListItem_dateTime);
        mEventPlace = (TextView) v.findViewById(R.id.simpleListItem_place);
        mEventImage = (ImageView) v.findViewById(R.id.simpleListItem_image);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());

            }
        });
    }

    public interface ClickListener{
        public void onItemClick(View view, int position);
    }

    private DestacadoViewHolder.ClickListener mClickListener;



    public void setOnClickListener(DestacadoViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
    public void setEventName(String name) {

        mEventName.setText(name);
    }
    public void setDateTime(String dateTime) {

        mEventDateTime.setText(dateTime);
    }
    public void setPlace(String place) {

        mEventPlace.setText(place);
    }

    public void setImagen( String imagen) {

        Picasso.with(this.ctx).load(imagen).into(mEventImage);
    }




}

