package com.koshkin.android.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    @GET("messages1.json")
    Call<List<RetroMessage>> getAllMessages();
}
