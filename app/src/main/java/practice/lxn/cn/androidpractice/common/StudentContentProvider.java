package practice.lxn.cn.androidpractice.common;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 *
 */

public class StudentContentProvider extends ContentProvider {
    //ContentProvider唯一标识符，一般是ContentProvier的全类名，要和清单文件中的保持一致
    public static final String AUTHORITY = "com.example.app.StudentContentProvider";
    //路径部分，一般代表数据的集合，一般用表的名字
    public static final String STUDENT = "student";
    public static final String TEACHER = "teacher";
    //代表特定的记录，如果没有指定，返回全部数据
    public static final int MATCH_STUDENT = 1;
    public static final int MATCH_TEACHER = 2;
    private Uri CONTENT_URI_STUDENT = Uri.parse("content://" + AUTHORITY + "/" + STUDENT);
    private Uri CONTENT_URI_TEACHER = Uri.parse("content://" + AUTHORITY + "/" + TEACHER);
    //访问多条记录
    public static final String CONTENT_STUDENT_TYPE = "vnd.android.cursor.dir/student";
    //访问单个记录
    public static final String CONTENT_TEACHER_TYPE = "vnd.android.cursor.item/teacher";
    private static UriMatcher uriMatcher;

    static {
        //完整的匹配路径为content://com.example.app.StudentContentProvider/student/1
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        //表示匹配com.example.app.StudentContentProvider/student,如果匹配成功，返回1
        uriMatcher.addURI(AUTHORITY, STUDENT, MATCH_STUDENT);
        uriMatcher.addURI(AUTHORITY, TEACHER, MATCH_TEACHER);
    }

    private DatabaseHelper mDataBaseHelper;

    @Override
    public boolean onCreate() {
        mDataBaseHelper = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        SQLiteDatabase database = mDataBaseHelper.getReadableDatabase();
        switch (uriMatcher.match(uri)) {
            case MATCH_STUDENT:
                queryBuilder.setTables(DatabaseHelper.TABLE_STUDENT);
                break;
            case MATCH_TEACHER:
                queryBuilder.setTables(DatabaseHelper.TABLE_TEACHER);
                break;
        }
        return queryBuilder.query(database, projection, selection, selectionArgs, null, null, null);
    }

    /**
     *  在query方法中返回Cursor的时候，系统要对Cursor进行分析，进而得出结论，知道该Cursor是多条还是一条记录，
     *  如果我们按照谷歌的建议，手动返回了一个能识别的MIME类型，那么系统就不用自己分析，相当于提高了一点点性能
     */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case MATCH_STUDENT:
                return CONTENT_STUDENT_TYPE;
            case MATCH_TEACHER:
                return CONTENT_TEACHER_TYPE;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase database = mDataBaseHelper.getReadableDatabase();
        switch (uriMatcher.match(uri)) {
            case MATCH_STUDENT: {
                long rowId = database.insert(DatabaseHelper.TABLE_STUDENT, null, values);
                if (rowId > 0) {
                    return ContentUris.withAppendedId(CONTENT_URI_STUDENT, rowId);
                }
                break;
            }
            case MATCH_TEACHER:
                long rowId = database.insert(DatabaseHelper.TABLE_TEACHER, null, values);
                if (rowId > 0) {
                    return ContentUris.withAppendedId(CONTENT_URI_TEACHER, rowId);
                }
                break;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mDataBaseHelper.getWritableDatabase();
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case MATCH_STUDENT:
                count = database.delete(DatabaseHelper.TABLE_STUDENT, selection, selectionArgs);
                break;
            case MATCH_TEACHER:
                count = database.delete(DatabaseHelper.TABLE_STUDENT, selection, selectionArgs);
                break;
        }
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mDataBaseHelper.getWritableDatabase();
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case MATCH_STUDENT:
                count = database.update(DatabaseHelper.TABLE_STUDENT, values, selection, selectionArgs);
                break;
            case MATCH_TEACHER:
                count = database.update(DatabaseHelper.TABLE_STUDENT, values, selection, selectionArgs);
                break;
        }
        if (getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return count;
    }
}
