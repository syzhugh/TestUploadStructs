package com.test.sun.testuploadstructs;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.test.sun.testuploadstructs.uploadstructs.UserActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TestVar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout inflate = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(inflate);

        Button button = new Button(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(150, 150);
        button.setLayoutParams(params);
        button.setText("to user");
        inflate.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentX = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intentX);
            }
        });

    }
}
