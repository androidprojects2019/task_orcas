package com.example.orcas.ViewModels;

import com.example.orcas.Api.Model.TeamsItem;
import com.example.orcas.Repositories.HomeRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class HomeViewModel extends ViewModel {
    public static MutableLiveData<List<TeamsItem>> teams = new MutableLiveData<>();
    HomeRepository homeRepository = new HomeRepository();

    public HomeViewModel() {

        teams = homeRepository.teams;
    }

    public void getTeams() {

        homeRepository.getTeams();
    }

}
