package com.example.orcas.Api;

import com.example.orcas.Api.Model.SquadItem;
import com.example.orcas.Api.Model.TeamResponse;
import com.example.orcas.Api.Model.TeamsResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface WebServices {

    @GET("competitions/2021/teams")
    Single<TeamsResponse> getTeams(@Header("X-Auth-Token") String key);

//    @GET("teams/{id}")
//    Single<List<SquadItem>> getTeamSquad(@Header("X-Auth-Token") String key,
//                                         @Path("id") String id);
    @GET("teams/{id}")
    Single<TeamResponse> getTeam(@Header("X-Auth-Token") String key,
                                 @Path("id") String id);

}
