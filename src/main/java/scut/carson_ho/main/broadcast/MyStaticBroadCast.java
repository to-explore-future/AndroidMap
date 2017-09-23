package scut.carson_ho.main.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import scut.carson_ho.main.service.MyService;

/**
 * Created by to-explore-future on 2017/9/18
 */
public class MyStaticBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == intent.ACTION_POWER_CONNECTED) {
            Log.i("action", "actionas:" + "开始充电");
            Toast.makeText(context, "开始充电", Toast.LENGTH_SHORT).show();
        } else if (action == intent.ACTION_POWER_DISCONNECTED) {
            Log.i("action", "actionas:" + "断开电源");
            Toast.makeText(context, "断开电源", Toast.LENGTH_SHORT).show();
        }

        context.startService(new Intent(context, MyService.class));


    }
}
