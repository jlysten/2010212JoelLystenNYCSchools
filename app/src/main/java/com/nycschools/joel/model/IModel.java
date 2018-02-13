package com.nycschools.joel.model;

import com.nycschools.joel.data.Data;
import com.nycschools.joel.data.SchoolSatScore;
import com.nycschools.joel.presenter.MyPresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

