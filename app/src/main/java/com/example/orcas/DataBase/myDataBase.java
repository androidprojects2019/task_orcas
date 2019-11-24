package com.example.orcas.DataBase;

import android.content.Context;

import com.example.orcas.Api.Model.TeamsItem;
import com.example.orcas.DataBase.DAOs.TeamsDao;
import com.example.orcas.DataBase.Models.Teams;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Teams.class}, version = 1, exportSchema = false)

public abstract class myDataBase extends RoomDatabase {
    private static myDataBase myDataBase;
    private static final String DB_NAME = "TeamsDataBase";
    public abstract TeamsDao teamsDao();
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
