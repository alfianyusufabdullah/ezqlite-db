package alfianyusufabdullah.ezqlite;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import alfianyusufabdullah.ezqlite.configuration.DatabaseConfiguration;
import alfianyusufabdullah.ezqlite.configuration.TableConfiguration;

/**
 * Created by jonesrandom on 12/27/17.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class EZQLiteDatabaseConfiguration {

    private String DatabaseName;
    private int DatabaseVersion;
    private List<TableConfiguration> tableConfigurations = new ArrayList<>();
    private List<String> Query = new ArrayList<>();
    private List<String> Tables = new ArrayList<>();
    private SQLiteDatabase.CursorFactory CursorFactory;

    private static EZQLiteDatabaseConfiguration configuration;

    private EZQLiteDatabaseConfiguration() {
    }

    public static EZQLiteDatabaseConfiguration getInstance() {
        if (configuration == null){
            configuration = new EZQLiteDatabaseConfiguration();
        }

        DatabaseConfiguration.getInstance();
        return configuration;
    }

    public EZQLiteDatabaseConfiguration setDatabaseName(String DatabaseNames) {
        DatabaseName = DatabaseNames;
        return configuration;
    }

    public EZQLiteDatabaseConfiguration setDatabaseVersion(int DatabaseVersions) {
        DatabaseVersion = DatabaseVersions;
        return configuration;
    }

    public EZQLiteDatabaseConfiguration setCursorFactory(SQLiteDatabase.CursorFactory cursorFactory){
        CursorFactory = cursorFactory;
        return configuration;
    }

    public EZQLiteDatabaseConfiguration addTableConfiguration(TableConfiguration tableConfiguration) {
        tableConfigurations.add(tableConfiguration);
        return configuration;
    }

    public void build() {
        for (TableConfiguration tableConfiguration : tableConfigurations) {
            Query.add(tableConfiguration.getQueryCreate());
            Tables.add(tableConfiguration.getTableName());
        }

        DatabaseConfiguration.setDatabaseName(DatabaseName);
        DatabaseConfiguration.setDatabaseVersion(DatabaseVersion);
        DatabaseConfiguration.setTableQuery(Query);
        DatabaseConfiguration.setTableNames(Tables);
        DatabaseConfiguration.setCursorFactory(CursorFactory);
    }

}
