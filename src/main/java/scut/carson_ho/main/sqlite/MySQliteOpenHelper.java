package scut.carson_ho.main.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by to-explore-future on 2017/9/21
 * 这里面的每个方法都会根据version的不同而进行回调
 */
public class MySQliteOpenHelper extends SQLiteOpenHelper {

    private static int version = 1;

    /**
     * 看父类的构造并没有创建数据库，只是把这些信息保存了起来
     *
     * @param context
     */
    public MySQliteOpenHelper(Context context) {
        super(context, "database.db", null, 1);
    }

    /**
     * SQLiteOpenHelper 第一次创建会执行这个方法，以后不会执行这个方法，这个方法不要主动调用，否则可能会覆盖数据，我猜测
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * 我这个产品可能已经升级到 4.0 版本，但是这个时候有新的用户 该开始使用本产品，这个 该怎么写 这个方法
         * 新用户应该拥有和从3.0升级到4.0的用户一样的数据库才对啊
         */
        /**
         * 建表之前要想清楚，我需要创建哪些参数，考虑周全，不要频繁的升级
         */
        String createTable = "create table user_info (_id integer primary key autoincrement,name varchar(20),color varchar(20))";
        db.execSQL(createTable);

    }

    /**
     * version 变大，回调
     * 数据库升级：比如添加新的表，或者删除表，或者修改已经有的表的结构。
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**
         * oldVersion:可能是各种版本，如果我要针对各种低版本进行升级，我就要写各种升级方案
         * 但是这样对用户很友好，无论从那个版本都可以顺利的升级。
         */

    }

    /**
     * 当 version 降低，回调
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
