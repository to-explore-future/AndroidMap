package scut.carson_ho.main.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by to-explore-future on 2017/9/21
 * 数据库接口
 */
public class Dao {

    private static final String TAG = "Dao";
    private final SQLiteDatabase mWritableDatabase;
    private Context mContext;
    private MySQliteOpenHelper mOpenHelper;
    private final ArrayList<String> mColors;

    public Dao(Context context) {
        mContext = context;
        mOpenHelper = new MySQliteOpenHelper(context);
        mWritableDatabase = mOpenHelper.getWritableDatabase();
        mColors = new ArrayList<>();
    }

    public SQLiteDatabase getWritableDatabase() {
        return mWritableDatabase;
    }

    /**
     * 插入数据
     *
     * @param name
     * @param color
     */
    public void insert(String name, String color) {
        Cursor cursor = null;
        String insert = "insert into user_info (name,color) values('" + name + "','" + color + "')";
        try {

            /**
             * 由于数据不能重复，插入之前要先查查 ，数据库中是否已经包含这条数据
             */
            query(name, color);
            if (mColors.contains(color)) {
                Toast.makeText(mContext, "已经存在：\"" + name + "\"和\"" + color + "\"", Toast.LENGTH_SHORT).show();
                return;
            }

            mWritableDatabase.execSQL(insert);
            Toast.makeText(mContext, "插入成功", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "走异常", e);
        } finally {
        }
    }

    /**
     * 查询数据
     * 这里要根据项目的需求 指定不同的查询方式
     *
     * @param name
     * @param color
     */
    public void query(String name, String color) {
        Cursor cursor = null;
        String query = "select color from user_info where name = '" + name + "'";
        try {
            cursor = mWritableDatabase.rawQuery(query, null);
            if (cursor != null) {
                String ph = null;
                while (cursor.moveToNext()) {
                    ph = cursor.getString(0);
                    mColors.add(ph);
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(TAG, "", e);
        } finally {
        }
    }


}
