package com.example.orcas.DataBase;

import android.content.Context;

import com.example.orcas.Api.Model.Converter;
import com.example.orcas.Api.Model.TeamResponse;
import com.example.orcas.Api.Model.TeamsItem;
import com.example.orcas.DataBase.DAOs.TeamDao;
import com.example.orcas.DataBase.DAOs.TeamsDao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {TeamsItem.class, TeamResponse.class}, version = 8, exportSchema = false)
@TypeConverters({Converter.class})

public abstract class myDataBase extends RoomDatabase {
    private static myDataBase myDataBase;
    private static final String DB_NAME = "TeamsDataBase";
    public abstract TeamsDao teamsDao();
    public abstract TeamDao teamDao();

    public myDataBase() {
    }

    public static myDataBase getInstance(Context context) {

        if (myDataBase == null) {
            myDataBase = Room.databaseBuilder(context, myDataBase.class,
                    DB_NAME).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return myDataBase;
    }
}
