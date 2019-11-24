package com.example.orcas.UI;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.example.orcas.Api.Model.TeamsItem;
import com.example.orcas.Base.BaseActivity;
import com.example.orcas.R;
import com.example.orcas.Repositories.HomeRepository;
import com.example.orcas.ViewModels.HomeViewModel;
import com.example.orcas.databinding.ActivityHomeBinding;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {
    LinearLayoutManager layoutManager;
    List<TeamsItem> teams = new ArrayList<>();
    List<TeamsItem> pagginatedTeams = new ArrayList<>();
    HomeAdapter adapter;
    HomeViewModel homeViewModel = new HomeViewModel();
    private EndlessRecycler scrollListener;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeRepository.context = this;
        homeViewModel = ViewModelProviders.of(this)
                .get(HomeViewModel.class);
        initRecyclerView();
        observeLiveData();
        homeViewModel.getTeams();
    }

    @Override
    protected HomeViewModel getViewModel() {
        return ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    private void initRecyclerView() {

        adapter = new HomeAdapter(null);
        adapter.setOnLinkClick(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, TeamsItem team) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(team.getWebsite()));
                HomeActivity.this.startActivity(browserIntent);
            }
        });

        adapter.setOnFavouriteClick(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, TeamsItem team) {
                Log.e("error", "favourite");
            }
        });

        adapter.setOnItemClick(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, TeamsItem team) {
                Intent intent = new Intent(HomeActivity.this,singleTeamActivity.class);
                intent.putExtra("id", team.getId());
                startActivity(intent);
            }
        });
        layoutManager = new LinearLayoutManager(this);
        databinding.homeRecycler.setAdapter(adapter);
        databinding.homeRecycler.setLayoutManager(layoutManager);
        scrollListener = new EndlessRecycler(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                databinding.progress.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        add();
                    }
                }, 3000);
            }
        };
        databinding.homeRecycler.addOnScrollListener(scrollListener);

    }

    private void observeLiveData() {
        HomeViewModel.teams.observe(this, new Observer<List<TeamsItem>>() {
            @Override
            public void onChanged(List<TeamsItem> teamsItems) {
                teams = teamsItems;
                add();
            }
        });
    }

    private void add() {

        int iterator = 0;
        while (iterator != 6) {
            if (counter + 1 >= teams.size()) {
                break;
            } else {
                pagginatedTeams.add(teams.get(counter));
                iterator++;
                counter++;
            }

        }
        adapter.changeData(pagginatedTeams);
        databinding.progress.setVisibility(View.INVISIBLE);

    }

}
