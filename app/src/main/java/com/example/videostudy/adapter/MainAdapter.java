package com.example.videostudy.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.videostudy.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mList;
    private ClickListener clickListener;

    public MainAdapter(Context context, List<String> list){
        mContext = context;
        mList = list;
    }

    public interface ClickListener{
        void onClick(View v, int position);
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.btn.setText(mList.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.onClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button btn;

        public ViewHolder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
