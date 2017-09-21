package com.example.user.qroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.qroom.APIHandler.APICallLib;
import com.example.user.qroom.APIHandler.OnSendResponse;
import com.example.user.qroom.listener.OnReceiveCode;
import com.example.user.qroom.utils.MyFirebaseMessagingService;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;

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
        MyFirebaseMessagingService.setListener(new OnReceiveCode() {
            @Override
            public void onReceive(String antrianNumb, String antrianCode) {
                Intent intent = new Intent(getApplicationContext(),AntrianActivity.class);
                intent.putExtra("idTempat",id);
                intent.putExtra("antrian_numb", antrianNumb);
                intent.putExtra("antrian_code", antrianCode);
                startActivity(intent);
                finish();
            }
        });
        APICallLib.reserve(0, FirebaseInstanceId.getInstance().getToken(), new OnSendResponse() {
            @Override
            public void onSuccess(String result) {
                Log.d("TEST", result);
            }

            @Override
            public void onFailure(String error) {
                Log.d("TEST", error.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        goToList();
    }
}
