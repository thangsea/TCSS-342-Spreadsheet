package edu.uw.tacoma.thangvn.webserviceslab.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.uw.tacoma.thangvn.webserviceslab.R;

/**
 * Created by thangnguyen on 11/2/16.
 */

public class CourseDB {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Course.db";

    private CourseDBHelper mCourseDBHelper;
    private SQLiteDatabase mSQLiteDatabase;

    public CourseDB(Context context) {
        mCourseDBHelper = new CourseDBHelper(
                context, DB_NAME, null, DB_VERSION);
        mSQLiteDatabase = mCourseDBHelper.getWritableDatabase();
    }


    /**
     * Inserts the course into the local sqlite table. Returns true if successful, false otherwise.
     * @param id
     * @param shortDesc
     * @param longDesc
     * @param prereqs
     * @return true or false
     */
    public boolean insertCourse(String id, String shortDesc, String longDesc, String prereqs) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("shortDesc", shortDesc);
        contentValues.put("longDesc", longDesc);
        contentValues.put("prereqs", prereqs);

        long rowId = mSQLiteDatabase.insert("Course", null, contentValues);
        return rowId != -1;
    }

    public void closeDB() {
        mSQLiteDatabase.close();
    }


}

class CourseDBHelper extends SQLiteOpenHelper {

    private final String CREATE_COURSE_SQL;

    private final String DROP_COURSE_SQL;

    public CourseDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        CREATE_COURSE_SQL = context.getString(R.string.CREATE_COURSE_SQL);
        DROP_COURSE_SQL = context.getString(R.string.DROP_COURSE_SQL);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COURSE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_COURSE_SQL);
        onCreate(sqLiteDatabase);
    }
}
