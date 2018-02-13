package com.nycschools.joel.view;

import com.nycschools.joel.data.SchoolSatScore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public interface IView {
    void navigatetoListFragment(List<String> list, List<String> urls);
    void showError(String message);

    void scoreDetails(ArrayList<SchoolSatScore> score);
}
