package de.haepfl.timerecord.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "timeentry_table")
public class TimeEntry {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int year;
    private int month;
    private int day;

    private String tag;

    private int duration;

    public TimeEntry(int year, int month, int day, String tag, int duration){
        this.year = year;
        this.month = month;
        this.day = day;
        this.tag = tag;
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getTag() {
        return tag;
    }

    public int getDuration() {
        return duration;
    }
}
