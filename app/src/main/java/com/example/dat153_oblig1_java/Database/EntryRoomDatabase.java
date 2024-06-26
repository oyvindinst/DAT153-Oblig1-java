package com.example.dat153_oblig1_java.Database;

import android.app.Application;
import android.content.Context;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.Room;

import com.example.dat153_oblig1_java.DAO.EntryDao;

@Database(entities = {Entry.class}, version = 1)
public abstract class EntryRoomDatabase extends RoomDatabase {

    public abstract EntryDao entryDao();
    private static EntryRoomDatabase INSTANCE;

    public static EntryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EntryRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EntryRoomDatabase.class, "entry_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
