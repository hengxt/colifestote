package com.example.colifestote.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.architecture.response.DataResult;
import com.example.architecture.response.ResponseStatus;
import com.example.architecture.response.ResultSource;
import com.example.colifestote.data.api.APIs;
import com.example.colifestote.data.api.HoleService;
import com.example.colifestote.data.bean.Hole;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HoleRepository {

    private static final HoleRepository S_REQUEST_MANAGER = new HoleRepository();
    private final Retrofit retrofit;
    private Call<List<Hole>> mUserCall;
    private Call<String> mInsertCall;

    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(8, TimeUnit.SECONDS)
                .readTimeout(8, TimeUnit.SECONDS)
                .writeTimeout(8, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(APIs.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private HoleRepository() {
    }

    public static HoleRepository getInstance() {
        return S_REQUEST_MANAGER;
    }

    public void getAllHoles(DataResult.Result<List<Hole>> result) {
        mUserCall = retrofit.create(HoleService.class).getAll();
        mUserCall.enqueue(new Callback<List<Hole>>() {
            @Override
            public void onResponse(@NonNull Call<List<Hole>> call, @NonNull Response<List<Hole>> response) {
                ResponseStatus responseStatus = new ResponseStatus(
                        String.valueOf(response.code()), response.isSuccessful(), ResultSource.NETWORK);
                Log.d("请求成功", "onResponse: " + response.code());
                result.onResult(new DataResult<>(response.body(), responseStatus));
                mUserCall = null;
            }

            @Override
            public void onFailure(@NonNull Call<List<Hole>> call, @NonNull Throwable t) {
                result.onResult(new DataResult<>(null,
                        new ResponseStatus(t.getMessage(), false, ResultSource.NETWORK)));
                Log.d("请求all失败", "onFailure: " + t.getMessage());
                mUserCall = null;
            }
        });
    }

    public void insertHole(Hole hole, DataResult.Result<String> result) {
        mInsertCall = retrofit.create(HoleService.class).insertOne(hole);
        mInsertCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                ResponseStatus responseStatus = new ResponseStatus(
                        String.valueOf(response.code()), response.isSuccessful(), ResultSource.NETWORK);
                result.onResult(new DataResult<>(response.body(), responseStatus));
                mInsertCall = null;
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                result.onResult(new DataResult<>(null,
                        new ResponseStatus(t.getMessage(), false, ResultSource.NETWORK)));
                Log.d("请求insert失败", "onFailure: " + t.getMessage());
                mInsertCall = null;
            }
        });

    }


}
