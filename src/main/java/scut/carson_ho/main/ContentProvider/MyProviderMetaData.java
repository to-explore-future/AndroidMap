package scut.carson_ho.main.ContentProvider;

import android.net.Uri;

/**
 * Created by to-explore-future on 2017/9/22
 */
public class MyProviderMetaData {

    public static final String AUTHORITY = "scut.carson_ho.main.ContentProvider.MyProvider";

    public static class UserTableMetaData {
        public static final Uri URI_NAME = Uri.parse("content://" + AUTHORITY + "/name");
        public static final Uri URI_PHONE = Uri.parse("content://" + AUTHORITY + "/phone");
    }


}
