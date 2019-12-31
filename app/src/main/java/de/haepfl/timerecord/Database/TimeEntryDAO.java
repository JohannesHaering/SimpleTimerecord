package de.haepfl.timerecord.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TimeEntryDAO {

    @Insert
    void insert(TimeEntry timeEntry);

    @Delete
    void delete(TimeEntry timeEntry);

    @Query("DELETE FROM timeentry_table")
    void deleteAllTimeentries();

    @Query("SELECT * FROM timeentry_table")
    List<TimeEntry> getAllTimeentries();
}
