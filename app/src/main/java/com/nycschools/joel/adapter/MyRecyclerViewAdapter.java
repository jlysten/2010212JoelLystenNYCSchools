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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private final List<Data> list;
    private final Context context;

    public MyRecyclerViewAdapter(List<Data> list, FragmentActivity activity) {
        this.list = list;
        this.context = activity;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView text;
        MyViewHolder(android.view.View view) {
            super(view);
            text = view.findViewById(R.id.titles);
            view.setOnClickListener(new android.view.View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {

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

        holder.text.setText(list.get(position).getSchoolName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
