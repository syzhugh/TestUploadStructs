package com.test.sun.testuploadstructs.uploadstructs;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.List;

/**
 * Created by ZS27 on 2016/12/12.
 */

public class CheckUtils {

    public static final String TAG = "TestVar";

    public static void checkService(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = manager.getRunningServices(50);
        for (ActivityManager.RunningServiceInfo runningService : runningServices) {
            if (runningService.service.getClassName().equals("com.test.sun.testuploadstructs.uploadstructs.UploadService")) {
                Log.i(TAG, "*********************service exists***************************");
                break;
            }
        }
    }

    public static boolean checkUserAct(Context context) {
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

    public static boolean checkWifi(Context context) {
        Log.i(TAG, "UploadBroadcast:checkWifi----------------");
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
