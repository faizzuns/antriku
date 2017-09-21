package com.example.user.qroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.qroom.data.Info;
import com.example.user.qroom.data.Info_Table;
import com.raizlabs.android.dbflow.sql.language.Select;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

        checkDataCheckBox();

        btnCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> listSyarat = new ArrayList<String>();
                ArrayList<String> listStatus = new ArrayList<String>();

                Info info = new Select()
                        .from(Info.class)
                        .where(Info_Table.id.is(1))
                        .querySingle();

                JSONArray jsArr;

                try {
                    jsArr = new JSONArray(info.getListSyarat());
                    if (jsArr != null) {
                        for (int i=0;i<jsArr.length();i++){
                            listSyarat.add(jsArr.getString(i));
                        }
                    }
                } catch (JSONException | NullPointerException e) {
                    e.printStackTrace();
                }

                if (info !=null){
                    Toast.makeText(AntrianActivity.this, listSyarat.get(0) + " , "+listSyarat.get(1), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void checkDataCheckBox() {
        Info info = new Select()
                .from(Info.class)
                .where(Info_Table.id.is(1))
                .querySingle();
        if (info == null){
            btnCheckbox.setVisibility(View.GONE);
        }else{
            btnCheckbox.setVisibility(View.VISIBLE);
        }
    }

    public void goToHome(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void goToInfo(){
        Intent intent = new Intent(getApplicationContext(),InfoActivity.class);
        intent.putExtra("idInfo",id);
        intent.putExtra("statusAntrian",1);
        startActivity(intent);
    }

    @Override
    protected void onResume() {

        checkDataCheckBox();

        super.onResume();
    }

    @Override
    protected void onDestroy() {

        deleteDataList();

        super.onDestroy();
    }

    private void deleteDataList() {

        Info info = new Select()
                .from(Info.class)
                .where(Info_Table.id.is(1))
                .querySingle();

        if (info != null){
            info.delete();
        }

    }
}
