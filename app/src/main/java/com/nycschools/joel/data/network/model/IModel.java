package com.nycschools.joel.data.network.model;

import com.nycschools.joel.data.network.Data;
import com.nycschools.joel.data.db.model.SchoolSatScore;

import java.util.ArrayList;

/**
 * Created by Joel on 2/12/2018.
 */

public interface IModel {

        void callAPI1(onResponse listener);
        void callAPI(onResponse listener);

    interface onResponse {
        //void onSuccess(List<String>listofschools, List<String>dbn);
        void schoolList(ArrayList<Data>list);
        void satScore(ArrayList<SchoolSatScore> score);
        void onFailure(String message);
    }
}

