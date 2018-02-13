package com.nycschools.joel.data.network.model;

import com.nycschools.joel.data.db.model.SchoolSatScore;
import com.nycschools.joel.data.network.ApiInterface;
import com.nycschools.joel.data.network.RetrofitClient;
import com.nycschools.joel.data.network.Data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by Joel on 2/12/2018.
 */

public class ModelImpl implements IModel {
    private final ApiInterface apiClient = RetrofitClient.getRetrofit().create(ApiInterface.class);

    @Override
    public void callAPI1(final onResponse listener) {
        Call<ArrayList<SchoolSatScore>> call = apiClient.getData1();
        call.enqueue(new Callback<ArrayList<SchoolSatScore>>() {

            @Override
            public void onResponse(Call<ArrayList<SchoolSatScore>> call, retrofit2.Response<ArrayList<SchoolSatScore>> response) {
                ArrayList<SchoolSatScore> score = response.body();
                listener.satScore(score);
            }

            @Override
            public void onFailure(Call<ArrayList<SchoolSatScore>> call, Throwable t) {

            }
        });
    }

    @Override
    public void callAPI(final onResponse listener) {
        Call<ArrayList<Data>> call = apiClient.getData();
        call.enqueue(new Callback<ArrayList<Data>>() {

            @Override
            public void onResponse(Call<ArrayList<Data>> call, retrofit2.Response<ArrayList<Data>> response) {
                ArrayList<Data> list = response.body();
                listener.schoolList(list);
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {

            }
        });
    }
}
