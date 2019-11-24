package com.example.orcas.Repositories;

import android.content.Context;
import android.util.Log;

import com.example.orcas.Api.ApiManger;
import com.example.orcas.Api.Model.SquadItem;
import com.example.orcas.Api.Model.TeamResponse;
import com.example.orcas.Constants;
import com.example.orcas.DataBase.myDataBase;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class singleTeamRepository {
    public static int id;
    public MutableLiveData<List<SquadItem>> teamPlayers = new MutableLiveData<>();
    public static MutableLiveData<TeamResponse> team = new MutableLiveData<>();

    public singleTeamRepository(int id) {
        this.id = id;
    }

    public static Context context;


    public void getTeam() {
        ApiManger.getApis().getTeam(Constants.APIKEY, Integer.toString(id)).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<TeamResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("team", d.toString());
                    }

                    @Override
                    public void onSuccess(TeamResponse teamResponse) {
                        team.setValue(teamResponse);
                        teamPlayers.setValue(teamResponse.getSquad());
                        if( myDataBase.
                                getInstance(context)
                                .teamDao()
                                .getTeams() == null)
                        {
                            myDataBase.
                                    getInstance(context)
                                    .teamDao()
                                    .addTeamData(teamResponse);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        team.setValue(
                                myDataBase
                                        .getInstance(context)
                                        .teamDao()
                                        .getTeamById(id)
                        );
                        teamPlayers.setValue(
                                myDataBase
                                        .getInstance(context)
                                        .teamDao()
                                        .getTeamById(id).getSquad()
                        );

                    }
                });
    }


}

