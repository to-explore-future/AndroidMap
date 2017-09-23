package scut.carson_ho.main.AsynTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.R;


public class AsyncTaskActivity extends AppCompatActivity {

    @BindView(R.id.tv_down_content)
    TextView mTvDownContent;

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
        setContentView(R.layout.activity_asyn_task);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start_downlord)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_downlord:
                /**
                 * 注意：这个AsyncTask任务执行以后 ，使用枚举给 这个类设置一个状态，只要这个类不销毁
                 * 当你再次调用execute()的时候，就会给你报一个 异常，告诉你一个AsyncTask对象，只能执行一次
                 */
                DownTask mDownTask = new DownTask();
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
            long totalByte = 0;
            for (String param : params) {
                Object object[] = downloadFile(param);
                int byteCount = (int) object[0];
                totalByte += byteCount;
                /*调用这个方法，底层使用handler发送消息，handlerMessage的时候，调用了onProgressUpdate*/
                publishProgress(object);
                if (isCancelled()) {
                    break;
                }
            }
            return totalByte;
        }

        private Object[] downloadFile(String param) {
            Object object[] = new Object[2];
            /* 记录每个网址下载的总字节数*/
            int byteCount = 0;
            HttpURLConnection connection = null;
            URL url = null;
            String blogName = "";
            try {
                url = new URL(param);
                /* URLConnection 是 HttpURLConnection的父类 */
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int length = -1;
                /**
                 * inputStream会一直，把数据写到1024的数组，如果写满就会返回一个length(duf的长度)
                 * 一直到 inputStream 没有数据了,length 再次被赋值为 -1
                 */
                while ((length = inputStream.read(buf)) != -1) {
                    baos.write(buf, 0, length);
                    byteCount += length;
                }
                String respons = new String(baos.toByteArray(), "utf-8");
                /**
                 * 解析博客中的标题
                 * 标题样式 *** <title>我是标题</title> ***
                 */
                int startIndex = respons.indexOf("<title>");
                if (startIndex > 0) {
                    startIndex += 7;
                    int endIndex = respons.indexOf("</title>");
                    if (endIndex > startIndex) {
                        blogName = respons.substring(startIndex, endIndex);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            object[0] = byteCount;
            object[1] = blogName;
            return object;

        }


        /**
         * 底层的 handler 把数据发送到主线程，HandlerMessage()，然后回到这个方法
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Object... values) {
            Object result[] = values;
            int byteCount = (int) values[0];
            String blogName = (String) values[1];
            String content = mTvDownContent.getText().toString();
            content += "\n博客《" + blogName + "》下载完成，共" + byteCount + "字节";
            mTvDownContent.setText(content);
        }

        /**
         * 后台的任务完成以后，handler 发送完成的消息，然后handlerMessage的时候，判断消息类型
         * 如果是 完成的消息就调用这个方法，
         *
         * @param aLong 是doInBackground 里面的 return totalByte;
         */
        @Override
        protected void onPostExecute(Long aLong) {
            String content = mTvDownContent.getText().toString();
            content += "\n全部下载完成，总共下载了" + aLong + "个字节";
            mTvDownContent.setText(content);

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
