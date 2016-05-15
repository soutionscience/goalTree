package com.example.android.goal_tree.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.goal_tree.model.Goal;

/**
 * Created by SolutionScience on 5/13/2016.
 */
public class GoalsDataSource {
    public static final String LOGTAG ="Goal-TREE_LOG";

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    public GoalsDataSource(Context context){
        dbhelper= new goaTreeDBOpenHelper(context);



    }
    public void open(){
        Log.i(LOGTAG,"Marsh Database opened");
        database= dbhelper.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG,"Marsh Database closed");
        dbhelper.close();

    }
    public Goal create(Goal goal){
        ContentValues values= new ContentValues();
        values.put(goaTreeDBOpenHelper.COLUMN_TITLE, goal.getTitle());
        values.put(goaTreeDBOpenHelper.COLUMN_DESC, goal.getDescription());
        values.put(goaTreeDBOpenHelper.COLUMN_SDATE, goal.getStartDate());
        values.put(goaTreeDBOpenHelper.COLUMN_EDATE, goal.getEndDate());

        long insertid = database.insert(goaTreeDBOpenHelper.TABLE_GOALS, null, values);
        goal.setId(insertid);
        return goal;

    }
}

