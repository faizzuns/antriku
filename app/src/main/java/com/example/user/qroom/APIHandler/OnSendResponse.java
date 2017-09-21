package com.example.user.qroom.APIHandler;

/**
 * Created by denail on 17/09/20.
 */

public interface OnSendResponse {
    void onSuccess(String result);
    void onFailure(String error);
}
