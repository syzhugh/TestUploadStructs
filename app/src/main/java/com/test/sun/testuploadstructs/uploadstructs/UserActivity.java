package com.test.sun.testuploadstructs.uploadstructs;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.test.sun.testuploadstructs.MainActivity;
import com.test.sun.testuploadstructs.R;

import java.util.List;

/**
 * Created by ZS27 on 2016/12/12.
 */

public class UserActivity extends AppCompatActivity {
    public static final String TAG = "TestVar";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "UserActivity:onCreate----------------");
        /*
        * 1.初始view
        * 2.判断service的状态，更改view
        * 3.加载数据，刷新
        * */

        initView();
    }

    private void checkService() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = manager.getRunningServices(50);
        for (ActivityManager.RunningServiceInfo runningService : runningServices) {
            if (runningService.service.getClassName().equals("com.test.sun.testuploadstructs.uploadstructs.UploadService")) {
                Log.i(TAG, "*********************service exists***************************");
                break;
            }
        }
    }

    private void initView() {
        LinearLayout inflate = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main2_for_test, null);
        setContentView(inflate);

        Button button = new Button(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(150, 150);
        button.setLayoutParams(params);
        button.setText("finish");
        inflate.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserActivity.this.finish();
            }
        });

        Button button1 = new Button(this);
        button1.setLayoutParams(params);
        button1.setText("stop");
        inflate.addView(button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentX = new Intent(UserActivity.this, UploadService.class);
                stopService(intentX);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "UserActivity:onStart----------------");
        checkService();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "UserActivity:onRestart----------------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "UserActivity:onResume----------------");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
