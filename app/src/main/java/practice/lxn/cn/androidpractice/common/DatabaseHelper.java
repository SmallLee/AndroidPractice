package practice.lxn.cn.androidpractice.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 *
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    //数据库名称
    private static final String DATABASE_NAME = "person.db";
    //数据库版本
    private static final int DATABASE_VERSION = 1;
    //表名称
    static final String TABLE_STUDENT = "student";
    static final String TABLE_TEACHER = "teacher";
    //创建表结构的语句，注意primary key必须是integer类型的
    private static final String SQL_CREATE_TABLE_STUDENT = "create table " + TABLE_STUDENT + "(" +
            BaseColumns._ID + " integer primary key autoincrement,name varchar(20)" + ");";
    private static final String SQL_CREATE_TABLE_TEACHER = "create table " + TABLE_TEACHER + "(" +
            BaseColumns._ID + " integer primary key autoincrement,name varchar(20)" + ");";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //第一次创建数据库的时候回调该方法
    //当使用getReadableDatabase()方法获取数据库实例的时候, 如果数据库不存在, 就会调用这个方法;
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: SQL_CREATE_TABLE_STUDENT" + SQL_CREATE_TABLE_STUDENT);
        db.execSQL(SQL_CREATE_TABLE_STUDENT);
        db.execSQL(SQL_CREATE_TABLE_TEACHER);
    }

    //版本号改变时会触发此方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
