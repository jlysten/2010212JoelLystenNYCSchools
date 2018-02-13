package com.nycschools.joel.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.view.View;
import android.widget.TextView;

import com.nycschools.joel.R;
import com.nycschools.joel.data.network.Data;

import java.util.List;

/**
 * Created by Joel on 2/12/2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private final List<Data> list;
    private final Context context;
    private ClickOnItemListener listener;
    private String schoolName,dbn;

    public interface ClickOnItemListener {
        void onClickOnItemListener(String name, String details);
    }

    public MyRecyclerViewAdapter(List<Data> list, Context context) {
        this.list = list;
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
