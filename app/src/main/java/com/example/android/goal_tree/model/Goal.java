package com.example.android.goal_tree.model;

import java.text.NumberFormat;

/**
 * Created by SolutionScience on 5/14/2016.
 */
public class Goal {
    private long id;
    private String title;
    private String description;
    private double StartDate;
    private double EndDate;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getStartDate() {
        return StartDate;
    }
    public void setStartDate(double StartDate) {
        this.StartDate = StartDate;
    }
    public double getEndDate() {
        return EndDate;
    }
    public void setEndDate(double EndDate) {
        this.EndDate = EndDate;
    }
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return title + "\n(" + nf.format(StartDate) + ")";
    }
}
