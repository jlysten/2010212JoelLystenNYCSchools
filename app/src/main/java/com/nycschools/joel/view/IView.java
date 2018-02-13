package com.nycschools.joel.view;

import com.nycschools.joel.data.network.Data;
import com.nycschools.joel.data.db.model.SchoolSatScore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public interface IView {
    void showError(String message);

    void responseReceived(ArrayList<Data> list);

    void secondResponseReceived(ArrayList<SchoolSatScore> score);
}
