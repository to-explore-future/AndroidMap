package scut.carson_ho.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.Bar.BarActivity;
import scut.carson_ho.main.ContentProvider.ContentProviderActivity;
import scut.carson_ho.main.UI.UIActivity;
import scut.carson_ho.main.broadcast.BroadCastActivity;
import scut.carson_ho.main.service.ServiceActivity;
import scut.carson_ho.main.sqlite.SQLiteActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activiyt);
        ButterKnife.bind(this);

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
                
                break;
        }
    }


}
