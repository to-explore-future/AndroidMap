package scut.carson_ho.main;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.AsynTask.AsyncTaskActivity;
import scut.carson_ho.main.Bar.BarActivity;
import scut.carson_ho.main.ContentProvider.ContentProviderActivity;
import scut.carson_ho.main.UI.UIActivity;
import scut.carson_ho.main.broadcast.BroadCastActivity;
import scut.carson_ho.main.service.ServiceActivity;
import scut.carson_ho.main.sqlite.SQLiteActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityss";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activiyt);
        ButterKnife.bind(this);
        Log.i(TAG, "onCreate:");
        bubble();
    }

    @OnClick({R.id.btn_about_service, R.id.btn_about_broadcast, R.id.btn_about_sqlite, R.id.btn_ui
            , R.id.btn_content_provider, R.id.btn_bar, R.id.btn_asyncTask,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_about_service:
                startActivity(new Intent(this, ServiceActivity.class));
                break;
            case R.id.btn_about_broadcast:
                startActivity(new Intent(this, BroadCastActivity.class));
                break;
            case R.id.btn_about_sqlite:
                startActivity(new Intent(this, SQLiteActivity.class));
                break;
            case R.id.btn_ui:
                startActivity(new Intent(this, UIActivity.class));
                break;
            case R.id.btn_content_provider:
                startActivity(new Intent(this, ContentProviderActivity.class));
                break;
            case R.id.btn_bar:
                startActivity(new Intent(this, BarActivity.class));
                break;
            case R.id.btn_asyncTask:
                startActivity(new Intent(this, AsyncTaskActivity.class));
                break;
        }
    }

    int a[] = {2, 78, 100, 34, 56, 78, 89, 23, 0, 40};
    int len = a.length;
    /**
     * 冒泡排序：
     */
    private void bubble() {


        int m = 0;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    m = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = m;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            Log.i(TAG, a[i] + "");
        }
    }

    /**
     * 选择排序：每次从数组中选择一个最小值，放到指定的位置
     */
    private void selectionSort() {
        for (int i = 0; i < len; i++) {

        }
    }

    /**
     * 应用在后台运行 也是占用着内存，
     *
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG, "onTrimMemory:");
        if (level == ComponentCallbacks2.TRIM_MEMORY_COMPLETE) {

        } else if (level == ComponentCallbacks2.TRIM_MEMORY_MODERATE) {

        } else if (level == ComponentCallbacks2.TRIM_MEMORY_BACKGROUND) {

        } else if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            /**
             * the process had been showing a user interface.and is no longer doing so,
             * large allocation with UI should be released at this point to allow memory to be better maneged.
             */
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "onLowMemory:");

    }

    public boolean checkSDKVersion() {
        return Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy:");
    }
}
