package com.example.orcas.ViewModels;

import com.example.orcas.Api.Model.SquadItem;
import com.example.orcas.Api.Model.TeamResponse;
import com.example.orcas.Repositories.singleTeamRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class singleTeamViweModel extends ViewModel {
    public static MutableLiveData<List<SquadItem>> teamPlayers = new MutableLiveData<>();
    public static MutableLiveData<TeamResponse> team = new MutableLiveData<>();
    public static int id;

    singleTeamRepository singleTeamRepository = new singleTeamRepository(id);

    public singleTeamViweModel() {
        this.teamPlayers = singleTeamRepository.teamPlayers;
        this.team = singleTeamRepository.team;
    }

    public void getTeam() {
        singleTeamRepository.getTeam();
    }

}
