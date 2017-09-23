package scut.carson_ho.main.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by to-explore-future on 2017/9/22
 */
public class MyProvider extends ContentProvider {

    private static final int NAME = 1;

    private static final int PHONE = 2;

    /**
     * 这个类是个 uri 匹配器，这个类中可以add一些 uri，这些uri就相当于 密码
     * 当被人想访问数据库的时候 ，就必须提供 这个类中 存在的uri，才能确认合法身份。
     */
    private static UriMatcher matcher;

    static {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(MyProviderMetaData.AUTHORITY, "/name", NAME);
        matcher.addURI(MyProviderMetaData.AUTHORITY, "/phone", PHONE);
    }

    private MyContentProviderOpenHelper mMyContentProviderOpenHelper;


    @Override
    public boolean onCreate() {
        mMyContentProviderOpenHelper = new MyContentProviderOpenHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (matcher.match(uri)) {
            case NAME:
                Toast.makeText(getContext(), "姓名", Toast.LENGTH_SHORT).show();
                // TODO: 2017/9/22 更具不同的 uri 去操作数据库
                break;
            case PHONE:
                Toast.makeText(getContext(), "手机", Toast.LENGTH_SHORT).show();
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
