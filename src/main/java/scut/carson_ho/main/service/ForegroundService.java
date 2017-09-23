package scut.carson_ho.main.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import scut.carson_ho.main.R;
import scut.carson_ho.main.service.ServiceActivity;

/**
 * Created by to-explore-future on 2017/9/15
 */
public class ForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("serviceaa", "service--onCreate");

        Intent intent = new Intent(this, ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("coreground content title");
        builder.setContentText("foreground service content");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);

        Notification notification = builder.getNotification();
        startForeground(1, notification);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("serviceaa", "service--onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("serviceaa", "service--onBind");
        return null;
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
    }
}
