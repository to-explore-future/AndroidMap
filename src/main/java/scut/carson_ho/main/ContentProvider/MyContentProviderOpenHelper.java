package scut.carson_ho.main.ContentProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by to-explore-future on 2017/9/22
 */
public class MyContentProviderOpenHelper extends SQLiteOpenHelper {

    String createTable = "create table contentProvider (_id integer primary key autoincrement,name varchar(20),phone varchar(20))";

    public MyContentProviderOpenHelper(Context context) {
        super(context, "MyContentProviderOpenHelper.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
