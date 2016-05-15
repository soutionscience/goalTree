package com.example.android.goal_tree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.example.android.goal_tree.db.GoalsDataSource;
import com.example.android.goal_tree.model.Goal;

public class MainActivity extends AppCompatActivity {
    public static final String LOGTAG ="Goal-TREE_LOG";

   GoalsDataSource datasource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        datasource= new GoalsDataSource(this);
//        just incase database is not opened
        datasource.open();
        createData();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    public void setNewGoal (View view) {
//        Button button = (Button) view;
//        startActivity(new Intent(getApplicationContext(), SetGoal.class));
//    }
//    // List view from main page
//    ListView myListView = (ListView)findViewById(R.id.goalListView);
//    // Edit Element for set goal
//    EditText titleField= (EditText) findViewById(R.id.contentTitleText);
//
////    goal list arraylist
//    ArrayList<String> goalList = new ArrayList<String>();
////    Declare array adapter - binds data to views
//    ArrayAdapter<String>aa= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,goalList);
//
////    myListView.setAdapter(aa);
////    now for the button
//     Button setGoalBtn = (Button)findViewById(R.id.setGoal);
////    listen for click
//    setGoalBtn.setOnClickListener(new OnClickListener(){
//        public void onClick(View v)
//        {
////            add the note
//            goalList.add(0, titleField.getText().toString());
////            update view
//            aa.notifyDataSetChanged();
//
//        }
//    });


    @Override
    protected void onResume() {
        super.onResume();
        datasource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        datasource.close();
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
