package com.nycschools.joel.network;

import com.nycschools.joel.data.Data;
import com.nycschools.joel.data.SchoolSatScore;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Joel on 2/12/2018.
 */

public interface ApiInterface {
    @GET("97mf-9njv.json")
    public Call<ArrayList<Data>> getData();
    @GET("734v-jeq5.json")
    public Call<ArrayList<SchoolSatScore>> getData1();
}
