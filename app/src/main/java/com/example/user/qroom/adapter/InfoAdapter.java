package com.example.user.qroom.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.qroom.R;
import com.example.user.qroom.data.Info;
import com.example.user.qroom.listener.InfoListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 20/09/2017.
 */

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    ArrayList<Info> listInfo;
    InfoListener listener;
    int status;

    public InfoAdapter(ArrayList<Info> listInfo, InfoListener listener, int status) {
        this.listInfo = listInfo;
        this.listener = listener;
        this.status = status;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.judul_info) TextView txtJudul;
        @BindView(R.id.btn_expand_info) ImageView btnExpand;
        @BindView(R.id.txt_deskripsi_info) TextView txtDeskripsi;
        @BindView(R.id.btn_list_info)
        Button btnMakeList;
        @BindView(R.id.expand_info) LinearLayout expand;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }
    }

    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_info, parent, false);

        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final InfoAdapter.ViewHolder holder, int position) {
        final Info info = listInfo.get(position);

        holder.txtJudul.setText(info.getJudul());
        holder.txtDeskripsi.setText(info.getDeskripsi());

        holder.expand.setVisibility(View.GONE);

        if (status == 0){
            holder.btnMakeList.setVisibility(View.GONE);
        }else{
            holder.btnMakeList.setVisibility(View.VISIBLE);
        }

        holder.btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.expand.getVisibility() == View.GONE ){
                    holder.expand.setVisibility(View.VISIBLE);
                }else{
                    holder.expand.setVisibility(View.GONE);
                }
            }
        });

        holder.btnMakeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnButtonClick(info);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listInfo.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(ArrayList<Info> listInfo){
        this.listInfo = listInfo;
        notifyDataSetChanged();
    }


}
