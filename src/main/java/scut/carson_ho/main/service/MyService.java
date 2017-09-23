package scut.carson_ho.main.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Carson_Ho on 16/11/5.
 */
public class MyService extends Service {

    private MyBinder mBinder = new MyBinder();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            if (what == 6) {
                Log.i("serviceaa", "service--alive--I'm alive !!");
                if (mHandler != null) {
                    mHandler.sendEmptyMessageDelayed(6, 2000);
                }
            }

        }
    };
    private boolean isSend = true;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "服务已经启动", Toast.LENGTH_SHORT).show();
        Log.i("serviceaa", "service--onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            Log.i("serviceaa", "service--onStartCommand -- (intent==null)");
        } else {
            Log.i("serviceaa", "service--onStartCommand");
        }

        /**
         * 走一次再也不走了
         */
        if(isSend){
            mHandler.sendEmptyMessageDelayed(6, 2000);
            isSend = false;
        }


        return super.onStartCommand(intent, flags, START_STICKY);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("serviceaa", "service--onBind");
        return mBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("serviceaa", "service--onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("serviceaa", "service--onDestroy");
        mHandler = null;
//        startService(new Intent(this, MyService.class));
    }


    class MyBinder extends Binder {

        public void service_connect_Activity() {

        }

        public void method1() {

        }

        public void method2() {

        }

        public void method3() {

        }
    }
}
