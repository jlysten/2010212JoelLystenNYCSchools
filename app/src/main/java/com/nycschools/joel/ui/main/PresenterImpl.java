package com.nycschools.joel.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;

import com.nycschools.joel.R;
import com.nycschools.joel.data.network.Data;
import com.nycschools.joel.data.db.model.SchoolSatScore;
import com.nycschools.joel.data.db.*;
import com.nycschools.joel.data.network.model.IModel;
import com.nycschools.joel.data.network.model.ModelImpl;
import com.nycschools.joel.ui.details.DetailsFragment;
import com.nycschools.joel.view.IView;
import com.nycschools.joel.ui.splash.SplashFragment;
import com.nycschools.joel.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Joel on 2/12/2018.
 */

public class PresenterImpl implements IPresenter,IModel.onResponse{

    private IView iView;
    private IModel iModel;
    private Context c;
    private Toolbar toolbar;
    @Inject ArrayList<Data> list;
    private SplashFragment splashFragment;
    private ListFragment listFragment;
    private DetailsFragment detailsFragment;
    private FragmentManager fragmentManager;
    DbHelperImpl dbHelper;

    public PresenterImpl(IView iview, ModelImpl modelImpl, Toolbar mTopToolbar, Context context) {
        this.iView = iview;
        this.iModel = modelImpl;
        this.c = context;
        this.toolbar = mTopToolbar;
        dbHelper = new DbHelperImpl(context);
    }

    @Override
    public void doNetworkCall() {
        iModel.callAPI(this);
    }

    @Override
    public void doNetworkCall1() {
        iModel.callAPI1(this);
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

   /* @Override
    public void loadDetailFragment(String name, String details) {
        detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("schoolname",name);
        bundle.putString("dbn",details);
        detailsFragment.setArguments(bundle);
        ((View) c).setSupportActionBar(toolbar);
        ((View) c).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((View) c).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((View) c).getSupportActionBar().show();
        fragmentManager = ((View) c).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, detailsFragment, "sc")
                .commit();

    }*/

    @Override
    public void loadDetailFragment(SchoolSatScore schoolSatScore) {
        detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("satscore",schoolSatScore);
        detailsFragment.setArguments(bundle);
        ((View) c).setSupportActionBar(toolbar);
        ((View) c).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((View) c).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((View) c).getSupportActionBar().show();
        fragmentManager = ((View) c).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, detailsFragment, "sc")
                .commit();
    }

    @Override
    public void combineData(ArrayList<SchoolSatScore> score) {

    }

    @Override
    public void schoolList(ArrayList<Data> list) {
        iView.responseReceived(list);
    }
    @Override
    public void satScore(ArrayList<SchoolSatScore> satScoreArrayList) {
        dbHelper.populateDb(satScoreArrayList);
        iView.secondResponseReceived(satScoreArrayList);

    }

    @Override
    public void onFailure(String message) {

    }
}
