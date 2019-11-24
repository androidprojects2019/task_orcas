package com.example.orcas.DataBase.DAOs;

import com.example.orcas.Api.Model.TeamResponse;
import com.example.orcas.Api.Model.TeamsItem;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TeamDao {

    @Insert()
    void addTeamData(TeamResponse item);

    @Query("select * from TeamsItem where id =:id ")
    TeamResponse getTeamById(int id);
    @Query("select * from TeamsItem ")
    List<TeamsItem> getTeams();
}
