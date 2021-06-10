package com.example.videostudy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.videostudy.BaseActivity;
import com.example.videostudy.R;

public class AudioRecordActivity extends BaseActivity {

    public static void startCustomActivity(Context context){
        Intent intent = new Intent(context, AudioRecordActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);
    }
}