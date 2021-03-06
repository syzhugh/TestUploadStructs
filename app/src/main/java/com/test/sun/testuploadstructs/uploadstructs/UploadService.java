package com.test.sun.testuploadstructs.uploadstructs;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ZS27 on 2016/12/12.
 * intentservice多次发生调用请求，会添加到队列中，依次完成
 * 外部stopservice并不能终止service
 */

public class UploadService extends IntentService {

    public static final String SERVICE_ACTION = "test";
    public static final String TAG = "TestVar";


    public UploadService() {
        super("upload");
    }


    public static void startService(Context context) {
        Intent intentX = new Intent(context, UploadService.class);
        intentX.setAction(UploadService.SERVICE_ACTION);
        context.startService(intentX);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "UploadService:onHandleIntent----------------");
        /**
         * 上传逻辑
         *
         * 文件上传结果回调，并发送通知
         *
         * */
//        try {
//            Thread.sleep(30 * 1000);
//        } catch (InterruptedException e) {
//            Log.i(TAG, ":sleep error");
//        }

        int i = 0;
        while (true) {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i > 3) {
                break;
            }
            Log.i(TAG, "////////////running/////////////////" + " : " + (i++));
        }
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "UploadService:onCreate----------------");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "UploadService:onDestroy----------------");
        super.onDestroy();

        /*
        *
        * 结束后进行通知
        *
        * */
    }
}
