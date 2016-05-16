package com.example.android.goal_tree.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by SolutionScience on 5/12/2016.
 */
public class goaTreeDBOpenHelper extends SQLiteOpenHelper {

    private static final String LOGTAG ="Goal-TREE_LOG";

    private static final String DATABASE_NAME ="goaltree.db";
    private static final int DATABASE_VERSION= 1;

    public static final String TABLE_GOALS="goals";
    public static final String COLUMN_ID="goalsId";
    public static final String COLUMN_TITLE="title";
    public static final String COLUMN_DESC="description";
    public static final String COLUMN_SDATE="start";
    public static final String COLUMN_EDATE="end";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_GOALS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_DESC + " TEXT, " +
                    COLUMN_SDATE + " TEXT, " +
                    COLUMN_EDATE + " TEXT" +
                    ")";


    public goaTreeDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.i(LOGTAG, "Table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOALS);
        onCreate(db);
    }


    }
