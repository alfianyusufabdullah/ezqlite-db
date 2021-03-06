package alfianyusufabdullah.ezqlite.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonesrandom on 12/27/17.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class TableConfiguration {

    public static final String TYPE_TEXT = "TEXT";

    public static String TEXT_TEXT_WITH_LENGHT(int lenght) {
        return "TEXT(" + lenght + ")";
    }

    public static final String TYPE_VARCHAR = "VARCHAR";

    public static String TEXT_VARCHAR_WITH_LENGHT(int lenght) {
        return "VARCHAR(" + lenght + ")";
    }

    public static final String TYPE_REAL = "REAL";

    public static String TEXT_REAL_WITH_LENGHT(int lenght) {
        return "REAL(" + lenght + ")";
    }

    public static final String TYPE_INTEGER = "INTEGER";

    public static String TEXT_INTEGER_WITH_LENGHT(int lenght) {
        return "INTEGER(" + lenght + ")";
    }

    public static final String TYPE_BLOB = "BLOB";

    public static String TEXT_BLOB_WITH_LENGHT(int lenght) {
        return "BLOB(" + lenght + ")";
    }

    public static final String TYPE_BOOL = "BOOL";

    private static List<String> Column = new ArrayList<>();
    private static String TableName;

    public TableConfiguration(String tableName) {
        TableName = tableName;
    }

    public String getTableName() {
        return TableName;
    }

    public void addColumn(String ColumnName, String DataType) {
        Column.add(ColumnName + " " + DataType);
    }

    public void addColumn(String ColumnName, String DataType, String ColumnProperties) {
        Column.add(ColumnName + " " + DataType + " " + ColumnProperties);
    }

    public String getQueryCreate() {

        if (Column.size() == 0) {
            throw new RuntimeException("Table Not Have Column");
        }

        StringBuilder queryBuilder = new StringBuilder().append("CREATE TABLE IF NOT EXISTS ").append(TableName).append(" (");
        for (String column : Column) {
            queryBuilder.append(column).append(",");
        }
        queryBuilder.append(")");
        return queryBuilder.toString().replace(",)", ")");
    }
}