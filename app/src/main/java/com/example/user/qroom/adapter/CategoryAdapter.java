package com.example.user.qroom.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.qroom.R;
import com.example.user.qroom.data.Category;
import com.example.user.qroom.listener.CategoryListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 19/09/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    ArrayList<Category> listCategory;
    CategoryListener listener;

    public CategoryAdapter(ArrayList<Category> listCategory, CategoryListener listener) {
        this.listCategory = listCategory;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.category)
        FrameLayout card;
        @BindView(R.id.icon_category) ImageView img;
        @BindView(R.id.judul_category) TextView judul;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }
    }


    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_category, parent, false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        final Category category = listCategory.get(position);

        holder.img.setImageResource(category.getIcon());
        holder.judul.setText(category.getNamaKategori());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCardClicked(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(ArrayList<Category> listCategory){
        this.listCategory = listCategory;
        notifyDataSetChanged();
    }
}
