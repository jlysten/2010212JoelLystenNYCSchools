package com.nycschools.joel.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import com.nycschools.joel.R;
import com.nycschools.joel.adapter.MyRecyclerViewAdapter;
import com.nycschools.joel.data.Data;
import com.nycschools.joel.data.SchoolSatScore;

import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public class ScoreFragment extends Fragment {

    private TextView title;
    private TextView description;
    private String schoolname,dbn;
    public RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            schoolname= bundle.getString("schoolname");
            dbn= bundle.getString("dbn");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        title = view.findViewById(R.id.detailstitles);
        description = view.findViewById(R.id.detailsdescription);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args = getArguments();
        if (args == null) {
            title.setText("NULL");
            description.setText("NULL");
        } else {
            title.setText(args.get("schoolname").toString());
            description.setText(args.get("dbn").toString());
        }
    }
}
