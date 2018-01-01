package alfianyusufabdullah.ezqlite.configuration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

/**
 * Created by jonesrandom on 12/27/17.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class DatabaseHelperConfiguration extends SQLiteOpenHelper {

    public DatabaseHelperConfiguration(Context context) {
        super(context, DatabaseConfiguration.getDatabaseName(), DatabaseConfiguration.getCursorFactory(), DatabaseConfiguration.getDatabaseVersion());

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String Query : DatabaseConfiguration.getTableQuery()) {
            sqLiteDatabase.execSQL(Query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (String Tables : DatabaseConfiguration.getTableNames()) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Tables);
            onCreate(sqLiteDatabase);
        }
    }
}
