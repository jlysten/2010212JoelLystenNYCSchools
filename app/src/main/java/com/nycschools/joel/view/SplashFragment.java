package com.nycschools.joel.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.nycschools.joel.R;

/**
 * Created by Joel on 2/12/2018.
 */

public class SplashFragment extends Fragment {

    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.fragment_splash, container, false);
        imageView = view.findViewById(R.id.splashImage);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        animation.setDuration(4000);
        imageView.startAnimation(animation);
        return view;
    }
}

