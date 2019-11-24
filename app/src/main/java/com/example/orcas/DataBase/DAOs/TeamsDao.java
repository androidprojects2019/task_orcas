package com.example.orcas.DataBase.DAOs;

 import com.example.orcas.Api.Model.TeamsItem;
 import com.example.orcas.DataBase.Models.Teams;

 import java.util.ArrayList;
 import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TeamsDao {

    @Insert()
    void addTeams(List<TeamsItem> teams);

    @Query("select * from Teams")
    List<Teams> getAllTeams();

}
