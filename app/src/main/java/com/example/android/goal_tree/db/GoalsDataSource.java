package com.example.android.goal_tree.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.goal_tree.model.Goal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SolutionScience on 5/13/2016.
 */
public class GoalsDataSource {
    public static final String LOGTAG ="Goal-TREE_LOG";

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

    private static  final String [] allColumns ={
            goaTreeDBOpenHelper.COLUMN_ID,
            goaTreeDBOpenHelper.COLUMN_TITLE,
            goaTreeDBOpenHelper.COLUMN_DESC,
            goaTreeDBOpenHelper.COLUMN_SDATE,
            goaTreeDBOpenHelper.COLUMN_EDATE
    };

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
    public List<Goal> findAll(){
        List<Goal> goals= new ArrayList<Goal>();
        Cursor cursor = database.query(goaTreeDBOpenHelper.TABLE_GOALS, allColumns, null, null, null, null, null);
        Log.i(LOGTAG, "RETURNED" + cursor.getCount() + "rows");
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Goal goal= new Goal();
                goal.setId(cursor.getLong(cursor.getColumnIndex(goaTreeDBOpenHelper.COLUMN_ID)));
                goal.setTitle(cursor.getString(cursor.getColumnIndex(goaTreeDBOpenHelper.COLUMN_TITLE)));
                goal.setDescription(cursor.getString(cursor.getColumnIndex(goaTreeDBOpenHelper.COLUMN_DESC)));
                goal.setStartDate(cursor.getDouble(cursor.getColumnIndex(goaTreeDBOpenHelper.COLUMN_SDATE)));
                goal.setEndDate(cursor.getDouble(cursor.getColumnIndex(goaTreeDBOpenHelper.COLUMN_EDATE)));
                goals.add(goal);
            }
        }
        return goals;
    }
}

