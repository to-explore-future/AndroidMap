package scut.carson_ho.main.ContentProvider;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.R;


public class ContentProviderActivity extends AppCompatActivity {

    private MyProvider mMyProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        mMyProvider = new MyProvider();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_insert, R.id.btn_delete, R.id.btn_update, R.id.btn_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_query:
                getContentResolver().query(MyProviderMetaData.UserTableMetaData.URI_NAME, null, null, null, null);
                getContentResolver().query(MyProviderMetaData.UserTableMetaData.URI_PHONE, null, null, null, null);
                break;
        }
    }
}
