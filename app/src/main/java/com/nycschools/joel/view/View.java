package com.nycschools.joel.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.nycschools.joel.R;
import com.nycschools.joel.ui.main.adapter.MyRecyclerViewAdapter;
import com.nycschools.joel.data.network.Data;
import com.nycschools.joel.data.db.model.SchoolSatScore;
import com.nycschools.joel.data.db.DbHelperImpl;
import com.nycschools.joel.data.network.model.ModelImpl;
import com.nycschools.joel.ui.main.IPresenter;
import com.nycschools.joel.ui.main.PresenterImpl;
import com.nycschools.joel.ui.main.ListFragment;

import java.util.ArrayList;

public class View extends AppCompatActivity implements IView,MyRecyclerViewAdapter.ClickOnItemListener{

    private IPresenter iPresenter;
    private Toolbar mTopToolbar;
    private LinearLayout linearLayout;
    ArrayList<Data> mlist = new ArrayList<>();
    private ListFragment listFragment = new ListFragment();
    DbHelperImpl dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    isNetworkAvailable();
        linearLayout = findViewById(R.id.linear_layout);
        mTopToolbar = findViewById(R.id.my_toolbar);
        iPresenter = new PresenterImpl(this, new ModelImpl(),mTopToolbar, this);
        iPresenter.doNetworkCall();
        iPresenter.doNetworkCall1();
        iPresenter.loadSplash();
        dbHelper = new DbHelperImpl(this);
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void responseReceived(ArrayList<Data> list) {
        iPresenter.loadListFragment(list);
    }

    @Override
    public void secondResponseReceived(ArrayList<SchoolSatScore> score) {
        iPresenter.combineData(score);
    }

    @Override
    public void onClickOnItemListener(String name, String dbn) {
        SchoolSatScore schoolSatScore = dbHelper.getSchoolSatScore(dbn);
        iPresenter.loadDetailFragment(schoolSatScore);

        //iPresenter.loadDetailFragment(name, dbn);
    }
}
