package com.example.orcas.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.orcas.Api.Model.SquadItem;
import com.example.orcas.Api.Model.TeamResponse;
import com.example.orcas.Base.BaseActivity;
import com.example.orcas.R;
import com.example.orcas.Repositories.HomeRepository;
import com.example.orcas.Repositories.singleTeamRepository;
import com.example.orcas.ViewModels.singleTeamViewModel;
import com.example.orcas.databinding.SingleTeamBinding;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class singleTeamActivity extends BaseActivity<SingleTeamBinding, singleTeamViewModel> {
    int id;
    PlayersAdapter adapter;
    singleTeamViewModel singleTeamViweModel = new singleTeamViewModel();
    RecyclerView.LayoutManager layoutManager;
    SimpleDateFormat input = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat output = new SimpleDateFormat("dd MMM yyyy");

    @Override
    public int getLayoutId() {
        return R.layout.single_team;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeRepository.context = this;
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        singleTeamRepository.id = this.id;

        singleTeamViweModel = ViewModelProviders.of(this)
                .get(singleTeamViewModel.class);
        initRecyclerView();
        observeLiveData();
        singleTeamViweModel.getTeam();
    }

    @Override
    protected singleTeamViewModel getViewModel() {
        return ViewModelProviders.of(this).get(singleTeamViewModel.class);

    }


    private void initRecyclerView() {

        adapter = new PlayersAdapter(null);
        layoutManager = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
        databinding.teamRecycler.setAdapter(adapter);
        databinding.teamRecycler.setLayoutManager(layoutManager);
    }

    private void initializeTeamData(final TeamResponse teamResponse) {
        databinding.name.setText("Name: " + teamResponse.getName());
        databinding.phone.setText("Phone: " + teamResponse.getPhone());
        databinding.address.setText("Address: " + teamResponse.getAddress());
        databinding.clubColors.setText("Colors: " + teamResponse.getClubColors());
        databinding.email.setText("Email: " + teamResponse.getEmail());
        databinding.site.setText("Website: " + teamResponse.getWebsite());
        databinding.venue.setText("Venue: " + teamResponse.getVenue());
        databinding.site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(teamResponse.getWebsite()));
                singleTeamActivity.this.startActivity(browserIntent);
            }
        });
    }

    private void observeLiveData() {
        singleTeamViweModel.teamPlayers.observe(this, new Observer<List<SquadItem>>() {
            @Override
            public void onChanged(List<SquadItem> teamsItems) {
                adapter.changeData(teamsItems);
                databinding.progress.setVisibility(View.INVISIBLE);
            }
        });
        singleTeamViweModel.team.observe(this, new Observer<TeamResponse>() {
            @Override
            public void onChanged(TeamResponse teamResponse) {
                initializeTeamData(teamResponse);
            }
        });

    }

}
