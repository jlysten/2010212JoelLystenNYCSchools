package com.nycschools.joel.presenter;

import com.nycschools.joel.data.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public interface IPresenter {
    void doNetworkCall();
    void loadSplash();

    void loadListFragment(ArrayList<Data> list);


    void loadDetailFragment(String title, String description, String image);

    void doNetworkCall1();
}
