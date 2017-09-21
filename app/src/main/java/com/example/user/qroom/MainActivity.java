package com.example.user.qroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.user.qroom.APIHandler.APICallLib;
import com.example.user.qroom.APIHandler.OnSendResponse;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TEST", "SEND");
                Log.d("TEST", FirebaseInstanceId.getInstance().getToken());
                APICallLib.reserve(0, FirebaseInstanceId.getInstance().getToken(), new OnSendResponse() {
                    @Override
                    public void onSuccess(String result) {
                        Log.d("TEST", result);
                    }

                    @Override
                    public void onFailure(String error) {
                        Log.d("TEST", error);
                    }
                });
            }
        });
    }
}
