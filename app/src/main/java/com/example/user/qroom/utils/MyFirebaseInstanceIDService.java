package com.example.user.qroom.utils;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by denail on 17/08/13.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
//        String token = FirebaseInstanceId.getInstance().getToken();
//        Log.d("TOKEN", token);
    }
}
