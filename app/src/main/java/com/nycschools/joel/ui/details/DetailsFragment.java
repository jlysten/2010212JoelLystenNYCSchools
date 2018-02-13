package com.nycschools.joel.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.TextView;

import com.nycschools.joel.R;

import java.util.List;


/**
 * Created by Joel on 2/12/2018.
 */

public class DetailsFragment extends Fragment {
    private List<String> schoolSatScores;
    TextView schoolName;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            schoolSatScores = bundle.getParcelable("satscore");
            Log.e("SAT","SCORES"+bundle.getParcelable("satscore"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        schoolName = view.findViewById(R.id.schoolname);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for(int i=0; i<schoolSatScores.size();i++){
            schoolName.setText(schoolSatScores.get(i));
        }
    }
}
