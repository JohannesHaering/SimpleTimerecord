package de.haepfl.timerecord.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = TimeEntry.class, version = 1, exportSchema = false)
public abstract class TimeEntryDatabase extends RoomDatabase {

    private static TimeEntryDatabase instance;

    public abstract TimeEntryDAO dayDao();

    public static synchronized TimeEntryDatabase getInstance(Context context) {
        if (instance == null) {
            //fallbackToDestructiveMigration deletes the old Database if the version is increased
            instance = Room.databaseBuilder(context.getApplicationContext(), TimeEntryDatabase.class, "day_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
