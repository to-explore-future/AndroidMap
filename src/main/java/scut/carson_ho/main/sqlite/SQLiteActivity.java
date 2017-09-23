package scut.carson_ho.main.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import scut.carson_ho.main.R;


public class SQLiteActivity extends AppCompatActivity {


    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.btn_delete)
    Button mBtnDelete;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    @BindView(R.id.btn_search)
    Button mBtnSearch;
    @BindView(R.id.btn_zhangsan)
    Button mBtnZhangsan;
    @BindView(R.id.btn_lisi)
    Button mBtnLisi;
    @BindView(R.id.btn_wangwu)
    Button mBtnWangwu;
    @BindView(R.id.btn_zhaoliu)
    Button mBtnZhaoliu;
    @BindView(R.id.btn_red)
    Button mBtnRed;
    @BindView(R.id.btn_blue)
    Button mBtnBlue;
    @BindView(R.id.btn_green)
    Button mBtnGreen;
    @BindView(R.id.btn_yellow)
    Button mBtnYellow;
    @BindView(R.id.ll_name)
    LinearLayout mLlName;
    @BindView(R.id.ll_color)
    LinearLayout mLlColor;
    private Dao mDao;

    private String name;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        ButterKnife.bind(this);

        mDao = new Dao(this);

    }


    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_update, R.id.btn_search, R.id.btn_zhangsan, R.id.btn_lisi,
            R.id.btn_wangwu, R.id.btn_zhaoliu, R.id.btn_red, R.id.btn_blue, R.id.btn_green, R.id.btn_yellow,
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:

                /*插入数据的时候，name 和 color 不能是 null*/
                if (name == null && color == null) {
                    showAnimation(mLlColor);
                    showAnimation(mLlName);
                } else if (name == null) {
                    showAnimation(mLlName);
                } else if (color == null) {
                    showAnimation(mLlColor);
                } else {
                    mDao.insert(name, color);
                    name = null;
                    color = null;
                }
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_search:
                break;
            case R.id.btn_zhangsan:
                name = "张三";
                break;
            case R.id.btn_lisi:
                name = "李四";
                break;
            case R.id.btn_wangwu:
                name = "王五";
                break;
            case R.id.btn_zhaoliu:
                name = "赵六";
                break;
            case R.id.btn_red:
                color = "红色";
                break;
            case R.id.btn_blue:
                color = "蓝色";
                break;
            case R.id.btn_green:
                color = "绿色";
                break;
            case R.id.btn_yellow:
                color = "黄色";
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SQLiteDatabase writableDatabase = mDao.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.close();
        }
    }

    /**
     * 展示动画效果
     *
     * @param view
     */
    public void showAnimation(final View view) {
        view.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.01f, 1.0f);
        alphaAnimation.setDuration(500);
        /**
         * 这个保持状态 会导致这个view setVisibility 失效
         */
//        alphaAnimation.setFillAfter(true);
//        alphaAnimation.setFillBefore(true);
        alphaAnimation.setRepeatCount(3);
        alphaAnimation.setRepeatMode(AlphaAnimation.REVERSE);
        view.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }


}
