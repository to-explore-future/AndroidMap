package scut.carson_ho.main.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startService;
    private Button stopService;
    private Button bindService;
    private Button unbindService;

    private MyService.MyBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("serviceaa", "service--onServiceDisconnected");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("serviceaa", "service--onServiceConnected");
            myBinder = (MyService.MyBinder) service;
            myBinder.service_connect_Activity();
            myBinder.method1();
            myBinder.method2();
            myBinder.method3();
        }
    };

    private Button mFroegroudService;
    private Button mStopForService;
    private Button mForegroundServiceNoNotification;
    private Button mStopForegroundServiceNoNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startService = (Button) findViewById(R.id.startService);
        stopService = (Button) findViewById(R.id.stopService);

        bindService = (Button) findViewById(R.id.bindService);
        unbindService = (Button) findViewById(R.id.unbindService);

        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

        mFroegroudService = (Button) findViewById(R.id.btn_foreground_service);
        mFroegroudService.setOnClickListener(this);
        mStopForService = (Button) findViewById(R.id.btn_stop_foreground_service);
        mStopForService.setOnClickListener(this);

        mForegroundServiceNoNotification = (Button) findViewById(R.id.btn_f_service_no_notification);
        mStopForegroundServiceNoNotification = (Button) findViewById(R.id.btn_stop_f_service_no_notification);

        mForegroundServiceNoNotification.setOnClickListener(this);
        mStopForegroundServiceNoNotification.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("serviceaa", "activity--onDestory");
        /**
         * 如果用户强制杀死应用，是会走 onDestory()方法的，这个时候去判断 服务是否还在，如果不在 就再次开启服务
         */
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.startService:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;

            case R.id.stopService:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;

            case R.id.bindService:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;

            case R.id.unbindService:
                unbindService(connection);
                break;
            case R.id.btn_foreground_service:
                /**
                 * 开启前台的service 但是这里使用的是 MyService 为了不再写一遍service 给Intent 携带一个参数
                 */
                Intent intent = new Intent(this, ForegroundService.class);
                startService(intent);

                break;
            case R.id.btn_stop_foreground_service:
                stopService(new Intent(this, ForegroundService.class));
                break;

            case R.id.btn_f_service_no_notification:
                startService(new Intent(this, ForegroundService_NoNotification.class));
                break;
            case R.id.btn_stop_f_service_no_notification:
                break;

            default:
                break;

        }
    }


    @OnClick(R.id.btn_intent_service)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_intent_service:
                Intent i = new Intent(this,MyIntentService.class);
                i.putExtra("name","name");
                startService(i);
                String s = "";
                break;

        }
    }
}
