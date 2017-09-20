package com.example.user.qroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTempatActivity extends AppCompatActivity {

    @BindView(R.id.img_detail)
    ImageView imgDetail;
    @BindView(R.id.judul_detail)
    TextView txtJudul;
    @BindView(R.id.txt_loc_detail) TextView txtLokasi;
    @BindView(R.id.img_loc_detail) ImageView imgLokasi;
    @BindView(R.id.txt_jam_detail) TextView txtJam;
    @BindView(R.id.btn_info_detail)
    Button btnInfo;
    @BindView(R.id.spinner_detail)
    Spinner spinAntrian;
    @BindView(R.id.deskripsi_detail) TextView txtDeskripsiAntrian;
    @BindView(R.id.nmr_sekarang_detail) TextView txtAntrianSekarang;
    @BindView(R.id.txt_ambil_antrian_detail) TextView txtAmbilAntrian;
    @BindView(R.id.estimasi_detail) TextView txtEstimasi;
    @BindView(R.id.btn_ambil_detail) Button btnAmbil;

    int status;
    String judul;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat);
        status = getIntent().getIntExtra("stat",0);
        judul = getIntent().getStringExtra("jud");
        id  = getIntent().getIntExtra("id",id);
        ButterKnife.bind(this);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInfo();
            }
        });

        btnAmbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAntrian();
            }
        });
    }

    public void goToList(){
        Intent intent = new Intent(getApplicationContext(),ListCategoryActivity.class);
        intent.putExtra("status",status);
        intent.putExtra("judul",judul);
        startActivity(intent);
        finish();
    }

    public void goToInfo(){
        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
        intent.putExtra("idInfo",id);
        startActivity(intent);
    }

    public void goToAntrian(){
        Intent intent = new Intent(getApplicationContext(),AntrianActivity.class);
        intent.putExtra("idTempat",id);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        goToList();
    }
}
