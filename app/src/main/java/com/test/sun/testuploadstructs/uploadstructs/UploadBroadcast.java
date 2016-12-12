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

        if (CheckUtils.checkUserAct(context)) {
            return;
        }
        if (!CheckUtils.checkWifi(context)) {
            return;
        }
        Log.i(TAG, ":startService");
        UploadService.startService(context);

    }


}
