package com.example.orcas.DataBase.DAOs;

import com.example.orcas.Api.Model.TeamsItem;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TeamsDao {

    @Insert()
    void addTeams(List<TeamsItem> teams);

    @Query("select * from teamsitem")
    List<TeamsItem> getTeams();

    @Query("Update TeamsItem Set isFavourite =:isFavourite")
    void updateTeam(boolean isFavourite);

}
