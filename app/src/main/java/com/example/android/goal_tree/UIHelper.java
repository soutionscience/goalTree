package com.example.android.goal_tree;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SolutionScience on 5/7/2016.
 * to help in interface design
 */
public class UIHelper {

    public static void displayText (Activity activity, int id, String text){
        TextView tv = (TextView) activity.findViewById(id);
        tv.setText(text);
    }

    public static  String getText(Activity activity, int id){
        EditText et= (EditText) activity.findViewById(id);
        return et.getText().toString();
    }

}

