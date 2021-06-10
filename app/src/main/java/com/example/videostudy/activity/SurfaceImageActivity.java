package com.example.videostudy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.videostudy.BaseActivity;
import com.example.videostudy.R;
import com.example.videostudy.util.Util;

public class SurfaceImageActivity extends BaseActivity {


    private SurfaceView mSurfaceView;
    private Context mContext;

    public static void startCustomActivity(Context context){
        Intent intent = new Intent(context, SurfaceImageActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_image);
        mContext = this;
        initView();
    }

    public void initView() {
        mSurfaceView = findViewById(R.id.surface_view);
        Resources resources = getResources();
        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (holder == null)return;

                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);

                BitmapDrawable drawable = (BitmapDrawable) mContext.getDrawable(R.mipmap.zui_049);
                Bitmap bitmap = drawable.getBitmap();
                Canvas canvas = holder.lockCanvas();//先锁定当前surfaceView的画布
                int left = Util.getScreenShowWidth(mContext)/2 - bitmap.getWidth()/2;
                int top = Util.getScreenShowHeight(mContext)/2 - 100 - bitmap.getHeight()/2;
                canvas.drawBitmap(bitmap, left, top, paint);//执行绘制操作
                holder.unlockCanvasAndPost(canvas);//解除锁定显示在当前页面
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
}