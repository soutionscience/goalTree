package com.example.android.goal_tree;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SetGoal extends AppCompatActivity {

    public static final String LOGTAG="Goal-TREE_LOG";
    public static final String USERNAME="username";
    //    set of preference saved as xml file
    private SharedPreferences settings;
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        settings= getPreferences(MODE_PRIVATE);

        File f= getFilesDir();
        String path = f.getAbsolutePath();
        UIHelper.displayText(this,R.id.goalPreview, path);

    }
//    1st step to user directory


    public void setGoal (View v) throws IOException {
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
        Log.i(LOGTAG, "Clicked set goal");

//        SharedPreferences.Editor editor = settings.edit();
        String text = UIHelper.getText(this, R.id.contentTitleText);
        FileOutputStream fos= openFileOutput("GoalsDirectory", MODE_PRIVATE);
        fos.write(text.getBytes());
        fos.close();

        UIHelper.displayText(this,R.id.goalPreview,"Goal Set proceed to set Deadline");

//        editor.putString(USERNAME, prefValue);
//        editor.commit();
//        UIHelper.displayText(this, R.id.goalPreview,"Preference text");
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





    }


