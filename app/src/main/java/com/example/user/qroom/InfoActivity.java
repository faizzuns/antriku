package com.example.user.qroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.user.qroom.adapter.InfoAdapter;
import com.example.user.qroom.data.Info;
import com.example.user.qroom.listener.InfoListener;

import org.json.JSONArray;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity implements InfoListener{

    @BindView(R.id.rv_info)
    RecyclerView rvInfo;

    ArrayList<Info> listInfo = new ArrayList<>();
    InfoAdapter adapter;
    int statusAntrian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Info");
        ButterKnife.bind(this);

        statusAntrian = getIntent().getIntExtra("statusAntrian",0);

        rvInfo.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvInfo.setLayoutManager(llm);

        adapter = new InfoAdapter(listInfo,this,statusAntrian);
        rvInfo.setAdapter(adapter);
        callInfoData();


    }

    private void callInfoData() {

        listInfo = new ArrayList<>();

        Info info;

        ArrayList<String> listSyarat = new ArrayList<>();
        listSyarat.add("KK");
        listSyarat.add("AKte");

        ArrayList<String> listStatus = new ArrayList<>();
        listStatus.add("false");
        listStatus.add("false");

        JSONArray jsArraySyarat = new JSONArray(listSyarat);
        JSONArray jsArrayStatus = new JSONArray(listStatus);

        info = new Info("Pembuatan E-Ktp","sumpah gua bingung bet nihh apa yak jadi yaudah lah aku ngasal aja bdd",jsArraySyarat.toString(),jsArrayStatus.toString());
        listInfo.add(info);
        listInfo.add(info);
        listInfo.add(info);
        listInfo.add(info);
        listInfo.add(info);
        listInfo.add(info);

        adapter.refreshData(listInfo);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnButtonClick(Info info) {

        info.save();
    }
}
