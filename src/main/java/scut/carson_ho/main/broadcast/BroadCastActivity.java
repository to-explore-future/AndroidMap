package scut.carson_ho.main.broadcast;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import scut.carson_ho.main.R;


public class BroadCastActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStaticRegestraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        initView();
        initListener();
    }


    private void initView() {
        mStaticRegestraction = (Button) findViewById(R.id.btn_about_static_registration);
    }

    private void initListener() {
        mStaticRegestraction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_about_static_registration:
                showMyDialog();
                break;
        }
    }

    /**
     *
     */
    private void showMyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("静态注册说明");
        builder.setMessage("虽然是静态注册，但是应用如果被用户杀死，一切都玩儿完" +
                "（静态注册的广播也会被销毁），华为4.x的手机都这样，更何况更高版本的平台" +
                "指望这个拉起服务不靠谱，随着android版本的不断升级，" +
                "越来越多的控件的能力被缩减，service，broadcastRecever他们变得依赖进程");
        builder.show();
    }
}
