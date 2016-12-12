package com.test.sun.testuploadstructs.uploadstructs;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.List;

/**
 * Created by ZS27 on 2016/12/12.
 */

public class UploadBroadcast extends BroadcastReceiver {

    public static final String TAG = "TestVar";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "UploadBroadcast:onReceive----------------");
        /**
         *
         *  1.判断act
         *  2.判断网络状态
         *  3.开启后台服务
         *
         * */

        if (checkUserAct(context)) {
            return;
        }
        if (!checkWifi(context)) {
            return;
        }
        Log.i(TAG, ":startService");
        UploadService.startService(context);

    }

    private boolean checkWifi(Context context) {
        Log.i(TAG, "UploadBroadcast:checkWifi----------------");
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private boolean checkUserAct(Context context) {
        Log.i(TAG, "UploadBroadcast:checkUserAct----------------");
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (manager.getRunningTasks(1).get(0).topActivity.getClassName().equals("com.test.sun.testuploadstructs.uploadstructs.UserActivity")) {
            return true;
        } else {
            return false;
        }
//      显示所有打开的app的顶端activity
//      当前显示的act永远在第一位
//        List<ActivityManager.RunningTaskInfo> runningTasks = manager.getRunningTasks(100);
//        for (ActivityManager.RunningTaskInfo runningTask : runningTasks) {
//            Log.i(TAG, ":" + runningTask.topActivity.getClassName());
//        }
    }
}
