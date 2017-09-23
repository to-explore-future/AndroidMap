package scut.carson_ho.main.AsynTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.R;


public class AsynTaskActivity extends AppCompatActivity {

    @BindView(R.id.tv_down_content)
    TextView mTvDownContent;
    private DownTask mDownTask;
    private String[] urls = {
            "http://blog.csdn.net/iispring/article/details/47115879",
            "http://blog.csdn.net/iispring/article/details/47180325",
            "http://blog.csdn.net/iispring/article/details/47300819",
            "http://blog.csdn.net/iispring/article/details/47320407",
            "http://blog.csdn.net/iispring/article/details/47622705"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDownTask = new DownTask();
        setContentView(R.layout.activity_asyn_task);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start_downlord)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_downlord:
                mDownTask.execute(urls);
                break;
        }
    }

    /**
     * 这个类就是对Handler的封装，写在activity里面比较好，这样容易和activity进行交互啊，
     */
    public class DownTask extends AsyncTask<String, Object, Long> {

        /**
         * 看AsyncTask的源码，怎么回调这里的
         */
        @Override
        protected void onPreExecute() {
            mTvDownContent.setText("be downloading");
        }

        /**
         * 开始异步执行 你写的代码
         *
         * @param params
         * @return
         */
        @Override
        protected Long doInBackground(String... params) {
            for (String param : params) {
                downloadFile(param);
            }
            return null;
        }

        private void downloadFile(String param) {
            HttpURLConnection connection = null;
            URL url = null;
            try {
                url = new URL(param);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }



        }

        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onCancelled(Long aLong) {
            super.onCancelled(aLong);
        }
    }

}
