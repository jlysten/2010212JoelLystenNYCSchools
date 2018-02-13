package com.nycschools.joel.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.nycschools.joel.R;
import com.nycschools.joel.data.SchoolSatScore;
import com.nycschools.joel.model.MyModel;
import com.nycschools.joel.presenter.IPresenter;
import com.nycschools.joel.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

public class View extends AppCompatActivity implements IView{

    private IPresenter iPresenter;
    private Toolbar mTopToolbar;
    private LinearLayout linearLayout;

    private ListFragment listFragment = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    isNetworkAvailable();
        linearLayout = findViewById(R.id.linear_layout);
        mTopToolbar = findViewById(R.id.my_toolbar);
        iPresenter = new MyPresenter(this, new MyModel(),mTopToolbar, this);
        iPresenter.doNetworkCall();
        iPresenter.doNetworkCall1();
        iPresenter.loadSplash();

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void navigatetoListFragment(List<String> list, List<String> urls) {

    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void scoreDetails(ArrayList<SchoolSatScore> score) {

    }

}
