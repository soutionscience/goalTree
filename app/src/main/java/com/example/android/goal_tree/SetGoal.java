package com.example.android.goal_tree;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.android.goal_tree.db.GoalsDataSource;
import com.example.android.goal_tree.model.Goal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class SetGoal extends ListActivity {

    public static final String LOGTAG="Goal-TREE_LOG";
    GoalsDataSource datasource;
    public static final String USERNAME="username";
    //    set of preference saved as xml file
    private SharedPreferences settings;
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        settings= getPreferences(MODE_PRIVATE);
//
//        File f= getFilesDir();
//        String path = f.getAbsolutePath();
//        UIHelper.displayText(this,R.id.goalPreview, path);



    }
//    1st step to user directory


    public void setGoal (View v)  {
////        Button setGoalbutton = (Button) view;
////        startActivity(new Intent(getApplicationContext(), goalCalenderPicker.class));
////         Find the title of goal
//        EditText titleField = (EditText) findViewById(R.id.contentTitleText);
//        String title = titleField.getText().toString();
//
////        Find the content of my goal
//        EditText contentField= (EditText)findViewById(R.id.contentText);
//        String content =contentField.getText().toString();
//
//        Intent intent = new Intent(Intent.ACTION_INSERT)
//                .setData(CalendarContract.Events.CONTENT_URI)
//                .putExtra(CalendarContract.Events.TITLE, title);
//
////                .putExtra(Events.EVENT_LOCATION, location)
////                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
////                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//        Log.i(LOGTAG, "Clicked set goal");
//
////        SharedPreferences.Editor editor = settings.edit();
//        String text = UIHelper.getText(this, R.id.contentTitleText);
//        FileOutputStream fos= openFileOutput("GoalsDirectory", MODE_PRIVATE);
//        fos.write(text.getBytes());
//        fos.close();
//
//        UIHelper.displayText(this,R.id.goalPreview,"Goal Set proceed to set Deadline");


//        editor.putString(USERNAME, prefValue);
//        editor.commit();
//        UIHelper.displayText(this, R.id.goalPreview,"Preference text");
        datasource= new GoalsDataSource(this);
//        just incase database is not opened
        datasource.open();
        createData();
//        creates a list layout of goals
        List<Goal> goals = datasource.findAll();
        if(goals.size()==0) {
            createData();
            goals = datasource.findAll();
        }

        ArrayAdapter<Goal> adapter = new ArrayAdapter<Goal>(this,
                android.R.layout.simple_list_item_1, goals);
        setListAdapter(adapter);


    }
    public  void showGoalButton(View v) throws IOException {
//              Log.i(LOGTAG, "Clicked show");
//          String prefValue = settings.getString(USERNAME, "not Found");
        FileInputStream fis =openFileInput("GoalsDirectory");
        BufferedInputStream bis = new BufferedInputStream(fis);
        StringBuffer b =new StringBuffer();
        while (bis.available() !=0){
            char c = (char) bis.read();
            b.append(c);

        }
        UIHelper.displayText(this, R.id.goalPreview, b.toString());
        bis.close();
        fis.close();



    }

    private void createData(){
        Goal goal= new Goal();
        goal.setTitle("Lose Weight");
        goal.setDescription(" Go to 100Kgs");
        goal.setStartDate(10000);
        goal.setEndDate(2);
        goal=datasource.create(goal);
        Log.i(LOGTAG, "Lose Weight goal created" + goal.getId());

        goal= new Goal();
        goal.setTitle("Finish android");
        goal.setDescription(" Master Database");
        goal.setStartDate(10000);
        goal.setEndDate(2);
        goal=datasource.create(goal);
        Log.i(LOGTAG,"Finish android goal created"+ goal.getId());

        goal= new Goal();
        goal.setTitle("Finish Unity");
        goal.setDescription(" Learn how to fix camera");
        goal.setStartDate(10000);
        goal.setEndDate(2);
        goal=datasource.create(goal);
        Log.i(LOGTAG,"Finish Unity goal created"+ goal.getId());
    }





}

