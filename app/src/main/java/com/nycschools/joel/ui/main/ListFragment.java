package com.nycschools.joel.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;

import com.nycschools.joel.R;
import com.nycschools.joel.ui.main.adapter.MyRecyclerViewAdapter;
import com.nycschools.joel.data.network.Data;

import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public class ListFragment extends Fragment {

    private List<Data> list;
    public RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            list = bundle.getParcelableArrayList("list");
        }
    }
    public MyRecyclerViewAdapter getAdapter() {
        return adapter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MyRecyclerViewAdapter(list,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}