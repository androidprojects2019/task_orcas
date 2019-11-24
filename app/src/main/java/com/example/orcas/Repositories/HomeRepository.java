package com.example.orcas.Repositories;

import android.content.Context;
import android.util.Log;

import com.example.orcas.Api.ApiManger;
import com.example.orcas.Api.Model.TeamsItem;
import com.example.orcas.Api.Model.TeamsResponse;
import com.example.orcas.Constants;
import com.example.orcas.DataBase.myDataBase;
import com.example.orcas.UI.HomeActivity;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeRepository {
    public MutableLiveData<List<TeamsItem>> teams = new MutableLiveData<>();

    public static Context context;

    public void getTeams() {
        ApiManger.getApis().getTeams(Constants.APIKEY).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<TeamsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(TeamsResponse teamsResponse) {
                        teams.setValue(teamsResponse.getTeams());
//                        myDataBase.
//                                getInstance(context)
//                                .teamsDao()
//                                .addTeams(teamsResponse.getTeams());
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }
}
