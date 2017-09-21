package com.example.user.qroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.user.qroom.adapter.ListCategoryAdapter;
import com.example.user.qroom.data.Place;
import com.example.user.qroom.listener.ListCategoryListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListCategoryActivity extends AppCompatActivity implements ListCategoryListener {
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    ListCategoryAdapter adapter;
    ArrayList<Place> listPlace;
    int status;
    String judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        judul = getIntent().getStringExtra("judul");
        status = getIntent().getIntExtra("status",0);
        getSupportActionBar().setTitle(judul);

        rvList.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(llm);
        listPlace = new ArrayList<>();
        adapter = new ListCategoryAdapter(listPlace,this);
        rvList.setAdapter(adapter);
        callListData(status);
    }

    private void callListData(int status) {
        listPlace = new ArrayList<>();

        Place place;
        place = new Place(1,"Gedung Sate","jalan Bagusrangin I nomor 69,Lebak Siliwangi, Coblong",8,20,R.drawable.test2);
        listPlace.add(place);
        place = new Place(2,"Gedung ITB","jalan Bagusrangin I nomor 69,Lebak Siliwangi, Coblong",8,20,R.drawable.test2);
        listPlace.add(place);
        place = new Place(3,"Gedung Sate","jalan Bagusrangin I nomor 69,Lebak Siliwangi, Coblong",8,20,R.drawable.test2);
        listPlace.add(place);
        place = new Place(4,"Gedung Sate","jalan Bagusrangin I nomor 69,Lebak Siliwangi, Coblong",8,20,R.drawable.test2);
        listPlace.add(place);

        adapter.refreshData(listPlace);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                goToHome();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        goToHome();
    }

    @Override
    public void onClickList(Place place) {
        goToDetail(place.getId());
    }

    public void goToHome(){
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void goToDetail(int id){
        Intent intent = new Intent(getApplicationContext(),DetailTempatActivity.class);
        intent.putExtra("stat",status);
        intent.putExtra("jud",judul);
        intent.putExtra("id",id);
        startActivity(intent);
        finish();
    }
}
