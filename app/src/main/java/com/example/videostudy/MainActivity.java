package com.example.videostudy;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.videostudy.activity.AudioRecordActivity;
import com.example.videostudy.activity.SurfaceImageActivity;
import com.example.videostudy.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainAdapter.ClickListener {

    private RecyclerView mRecyclerView;
    private List<String> mList;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    public void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainAdapter = new MainAdapter(this, mList);
        mRecyclerView.setAdapter(mMainAdapter);
        mMainAdapter.setClickListener(this);
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add("SurfaceImageView");
        mList.add("AudioRecord");

    }

    @Override
    public void onClick(View v, int position) {
        switch (position){
            case 0:
                SurfaceImageActivity.startCustomActivity(this);
                break;
            case 1:
                AudioRecordActivity.startCustomActivity(this);
                break;
        }
    }
}