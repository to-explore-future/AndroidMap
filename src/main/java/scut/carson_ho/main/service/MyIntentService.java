package scut.carson_ho.main.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by to-explore-future on 2017/9/22
 * 这个IntentService 处理完任务就会自动关闭，方法也简单
 */
public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {
        super("");
    }

    /**
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"--onCreat()--");
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG,"--onStart()--");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG,"--onStartCommand()--");
        return super.onStartCommand(intent, flags, startId);

    }

    /**
     * 这个方法会自动开启子线程（工作者线程）
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"--onHandleIntent()--");

        /**
         * 貌似这句没有作用，按说工作线程不能更新UI，但是这里也不报错，也没反应
         */
        Toast.makeText(this, "能更新UI吗", Toast.LENGTH_SHORT).show();

    }
}
