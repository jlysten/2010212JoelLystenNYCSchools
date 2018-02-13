package com.nycschools.joel.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nycschools.joel.R;
import com.nycschools.joel.data.Data;
import com.nycschools.joel.data.SchoolSatScore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private final List<Data> list;
    private final List<SchoolSatScore> satScores;
    private final Context context;
    private ClickOnItemListener listener;
    private String schoolName,dbn;

    public interface ClickOnItemListener {
        void onClickOnItemListener(String name, String details);
    }

    public MyRecyclerViewAdapter(List<Data> list, List<SchoolSatScore> satScores, Context context) {
        this.list = list;
        this.satScores = satScores;
        listener = (ClickOnItemListener) context;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView text;
        MyViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.titles);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickOnItemListener(schoolName,dbn);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position) {
        schoolName = list.get(position).getSchoolName();
        dbn = list.get(position).getDbn();
        holder.text.setText(schoolName);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
