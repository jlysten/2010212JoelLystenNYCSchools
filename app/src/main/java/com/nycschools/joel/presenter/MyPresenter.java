package com.nycschools.joel.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.nycschools.joel.R;
import com.nycschools.joel.adapter.MyRecyclerViewAdapter;
import com.nycschools.joel.data.Data;
import com.nycschools.joel.data.SchoolSatScore;
import com.nycschools.joel.model.IModel;
import com.nycschools.joel.model.MyModel;
import com.nycschools.joel.view.IView;
import com.nycschools.joel.view.ListFragment;
import com.nycschools.joel.view.SplashFragment;
import com.nycschools.joel.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public class MyPresenter implements IPresenter,IModel.onResponse{

    private IView iView;
    private IModel iModel;
    private Context c;
    private Toolbar toolbar;
    private SplashFragment splashFragment;
    private ListFragment listFragment;
    private FragmentManager fragmentManager;
    //private List<String> schoolNames = new ArrayList<>();
  //  private List<String> schoolDbn = new ArrayList<>();
    private ArrayList<Data> mlist;

    public MyPresenter(IView iview, MyModel myModel, Toolbar mTopToolbar, Context context) {
            this.iView = iview;
            this.iModel = myModel;
            this.c = context;
            this.toolbar = mTopToolbar;
    }

    @Override
    public void doNetworkCall() {
        iModel.callAPI(this);
    }

    @Override
    public void loadSplash() {
        splashFragment = new SplashFragment();
        ((View) c).setSupportActionBar(toolbar);
        ((View) c).getSupportActionBar().hide();
        new Handler().post(new Runnable() {
            public void run() {
                if (!((View) c).isFinishing() && !((View) c).isDestroyed()) {
                    fragmentManager = ((View) c).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, splashFragment)
                            .commit();
                }
            }
        });
    }

    @Override
    public void loadListFragment(ArrayList<Data> list) {

        listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        Log.e("Bundle","Check:  " +mlist);
        listFragment.setArguments(bundle);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((View) c).setSupportActionBar(toolbar);
                ((View) c).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                ((View) c).getSupportActionBar().setDisplayShowHomeEnabled(true);
                ((View) c).getSupportActionBar().show();
                fragmentManager = ((View) c).getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, listFragment, "list")
                        .commit();
            }
    }, 4000);
    }

    @Override
    public void loadDetailFragment(String title, String description, String image) {

    }

    @Override
    public void doNetworkCall1() {
        iModel.callAPI1(this);
    }

    @Override
    public void schoolList(ArrayList<Data> list) {
        loadListFragment(list);
    }

    @Override
    public void satScore(ArrayList<SchoolSatScore> score) {
        iView.scoreDetails(score);
    }

    @Override
    public void onFailure(String message) {

    }
}
