package com.nycschools.joel.ui.main;

import com.nycschools.joel.data.network.Data;
import com.nycschools.joel.data.db.model.SchoolSatScore;

import java.util.ArrayList;

/**
 * Created by Joel on 2/12/2018.
 */

public interface IPresenter {
    void doNetworkCall();
    void loadSplash();

    void loadListFragment(ArrayList<Data> list);

    void doNetworkCall1();

    void combineData(ArrayList<SchoolSatScore> score);

    //void loadDetailFragment(String name, String details);

    void loadDetailFragment(SchoolSatScore schoolSatScore);
}
