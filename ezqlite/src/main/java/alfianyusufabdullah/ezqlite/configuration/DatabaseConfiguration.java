package alfianyusufabdullah.ezqlite.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.List;

/**
 * Created by jonesrandom on 12/27/17.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class DatabaseConfiguration {

    private String DATABASE_NAME;
    private int DATABASE_VERSION;
    private List<String> QUERYS;
    private List<String> TABLES;
    private SQLiteDatabase.CursorFactory cursorFactory;

    private static DatabaseConfiguration configuration;

    private DatabaseConfiguration() {
    }

    public static DatabaseConfiguration getInstance() {
        if (configuration == null) {
            configuration = new DatabaseConfiguration();
        }
        return configuration;
    }

    public static String getDatabaseName() {
        return configuration.DATABASE_NAME;
    }

    public static void setDatabaseName(String databaseName) {
        configuration.DATABASE_NAME = databaseName;
    }

    public static int getDatabaseVersion() {
        return configuration.DATABASE_VERSION;
    }

    public static void setDatabaseVersion(int databaseVersion) {
        configuration.DATABASE_VERSION = databaseVersion;
    }

    public static List<String> getTableQuery() {
        return configuration.QUERYS;
    }

    public static void setTableQuery(List<String> tableQuery) {
        configuration.QUERYS = tableQuery;
    }

    public static List<String> getTableNames() {
        return configuration.TABLES;
    }

    public static void setTableNames(List<String> tableNames) {
        configuration.TABLES = tableNames;
    }

    public static void setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory){
        configuration.cursorFactory = cursorFactory;
    }

    public static SQLiteDatabase.CursorFactory getCursorFactory(){
        return configuration.cursorFactory;
    }

}
