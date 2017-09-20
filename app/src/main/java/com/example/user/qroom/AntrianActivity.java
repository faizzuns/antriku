package com.example.user.qroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AntrianActivity extends AppCompatActivity {

    @BindView(R.id.judul_antrian)
    TextView txtJudul;
    @BindView(R.id.img_loc_antrian)
    ImageView imgLokasi;
    @BindView(R.id.txt_loc_antrian) TextView txtLokasi;
    @BindView(R.id.btn_info_antrian)
    Button btnInfo;
    @BindView(R.id.btn_checkbox_antrian) Button btnCheckbox;
    @BindView(R.id.txt_loket_antrian) TextView txtLoketAntrian;
    @BindView(R.id.txt_nomor_antrian) TextView txtNomor;
    @BindView(R.id.img_info_antrian) ImageView imgInfoAntrian;
    @BindView(R.id.txt_estimasi_antrian) TextView txtEstimasi;
    @BindView(R.id.btn_batal_antrian) Button btnBatal;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrian);
        ButterKnife.bind(this);
        id = getIntent().getIntExtra("idTempat",0);

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInfo();
            }
        });

    }

    public void goToHome(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void goToInfo(){
        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
        intent.putExtra("idInfo",id);
        startActivity(intent);
    }
}
