package com.example.orcas.Api;

import com.example.orcas.Api.Model.TeamsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface WebServices {

    @GET("competitions/2021/teams")
    Single<TeamsResponse> getTeams(@Header("X-Auth-Token") String key);



}
