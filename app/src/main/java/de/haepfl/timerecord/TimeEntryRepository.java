package de.haepfl.timerecord;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import de.haepfl.timerecord.Database.TimeEntry;
import de.haepfl.timerecord.Database.TimeEntryDAO;
import de.haepfl.timerecord.Database.TimeEntryDatabase;

public class TimeEntryRepository {

    private TimeEntryDAO timeEntryDAO;
    private List<TimeEntry> timeEntries;

    public TimeEntryRepository(Context application) {
        TimeEntryDatabase database = TimeEntryDatabase.getInstance(application);
        timeEntryDAO = database.dayDao();
        timeEntries = timeEntryDAO.getAllTimeentries();
    }

    public void insert(TimeEntry timeEntry) {
        new InsertDayAsyncTask(timeEntryDAO).execute(timeEntry);
    }

    public void delete(TimeEntry timeEntry) {
        new DeleteDayAsyncTask(timeEntryDAO).execute(timeEntry);
    }

    public void deleteAllDays() {
        new DeleteAllDaysNoteAsyncTask(timeEntryDAO).execute();
    }

    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }


    //Can fit all classes in to one

    private static class InsertDayAsyncTask extends AsyncTask<TimeEntry, Void, Void> {
        private TimeEntryDAO timeEntryDAO;

        private InsertDayAsyncTask(TimeEntryDAO timeEntryDao) {
            this.timeEntryDAO = timeEntryDao;
        }

        @Override
        protected Void doInBackground(TimeEntry... timeEntries) {
            timeEntryDAO.insert((timeEntries[0]));
            return null;
        }
    }

    private static class DeleteDayAsyncTask extends AsyncTask<TimeEntry, Void, Void> {
        private TimeEntryDAO timeEntryDAO;

        private DeleteDayAsyncTask(TimeEntryDAO timeEntryDAO) {
            this.timeEntryDAO = timeEntryDAO;
        }

        @Override
        protected Void doInBackground(TimeEntry... timeEntries) {
            timeEntryDAO.delete((timeEntries[0]));
            return null;
        }
    }

    private static class DeleteAllDaysNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private TimeEntryDAO timeEntryDAO;

        private DeleteAllDaysNoteAsyncTask(TimeEntryDAO dayDao) {
            this.timeEntryDAO = timeEntryDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            timeEntryDAO.deleteAllTimeentries();
            return null;
        }
    }
}
