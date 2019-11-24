package com.example.orcas.UI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orcas.Api.Model.TeamsItem;
import com.example.orcas.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.homeViewHolder> {
    List<TeamsItem> teams;

    public HomeAdapter(List<TeamsItem> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public homeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new homeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final homeViewHolder holder, final int position) {
        TeamsItem team = teams.get(position);
        holder.team_name.setText(team.getName());
        holder.website.setText(team.getWebsite());
        holder.colors.setText(team.getClubColors());
        holder.venu.setText(team.getVenue());
        if (onFavouriteClick != null) {
            holder.favourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFavouriteClick.onItemClick(position, teams.get(position));
                }
            });
        }
        if (onLinkClick != null) {
            holder.website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onLinkClick.onItemClick(position, teams.get(position));
                }
            });
        }
        if (onItemClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onItemClick(position, teams.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (teams == null) return 0;
        return teams.size();
    }

    public void changeData(List<TeamsItem> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    public void setOnItemClick(OnItemClickListener onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void setOnLinkClick(OnItemClickListener onLinkClick) {
        this.onLinkClick = onLinkClick;
    }

    public void setOnFavouriteClick(OnItemClickListener onFavouriteClick) {
        this.onFavouriteClick = onFavouriteClick;
    }

    OnItemClickListener onFavouriteClick;
    OnItemClickListener onLinkClick;
    OnItemClickListener onItemClick;

    public interface OnItemClickListener {
        void onItemClick(int pos, TeamsItem team);
    }


    public class homeViewHolder extends RecyclerView.ViewHolder {
        TextView team_name, website, colors, venu;
        ImageView favourite;

        public homeViewHolder(@NonNull View itemView) {
            super(itemView);
            team_name = itemView.findViewById(R.id.team_name);
            website = itemView.findViewById(R.id.teamWebsite);
            colors = itemView.findViewById(R.id.team_colors);
            venu = itemView.findViewById(R.id.venu);
            favourite = itemView.findViewById(R.id.favourite);
        }
    }
}
