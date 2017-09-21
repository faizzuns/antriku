package com.example.user.qroom.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.qroom.R;
import com.example.user.qroom.data.Place;
import com.example.user.qroom.listener.ListCategoryListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 19/09/2017.
 */

public class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.ViewHolder>{

    ArrayList<Place> listPlace;
    ListCategoryListener listCategoryListener;

    public ListCategoryAdapter(ArrayList<Place> listPlace, ListCategoryListener listCategoryListener){
        this.listPlace = listPlace;
        this.listCategoryListener = listCategoryListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.list)
        LinearLayout card;
        @BindView(R.id.img_list) ImageView img;
        @BindView(R.id.judul_list) TextView judul;
        @BindView(R.id.lokasi_list) TextView lokasi;
        @BindView(R.id.jam_list) TextView jam;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }
    }


    @Override
    public ListCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_category, parent, false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListCategoryAdapter.ViewHolder holder, int position) {
        final Place place = listPlace.get(position);

        holder.img.setImageResource(place.getFoto());
        holder.judul.setText(place.getNamaTempat());
        holder.lokasi.setText(place.getLocation());
        String mulai = SetDetailWaktu(place.getJamBuka());
        String selesai = SetDetailWaktu(place.getJamTutup());
        holder.jam.setText(mulai + " - "+selesai);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listCategoryListener.onClickList(place);
            }
        });

    }

    private String SetDetailWaktu(int jamBuka) {
        String edt;

        if (jamBuka<10){
            edt = "0"+jamBuka+".00";
        }else{
            edt = jamBuka+".00";
        }

        return edt;
    }

    @Override
    public int getItemCount() {
        return listPlace.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(ArrayList<Place> listPlace){
        this.listPlace = listPlace;
        notifyDataSetChanged();
    }
}
