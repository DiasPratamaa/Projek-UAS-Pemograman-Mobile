package com.example.projekuas.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {EndemikEntity.class},
        version = 1,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {

    public abstract EndemikDao endemikDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context){

        if(INSTANCE==null){

            INSTANCE =
                    Room.databaseBuilder(
                                    context,
                                    AppDatabase.class,
                                    "endemik_db"
                            )
                            .allowMainThreadQueries()
                            .build();

        }

        return INSTANCE;

    }

}