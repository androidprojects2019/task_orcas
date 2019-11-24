package com.example.orcas.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.orcas.Api.Model.SquadItem;
import com.example.orcas.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.viewHolder> {

    List<SquadItem> players;

    public PlayersAdapter(List<SquadItem> players) {
        this.players = players;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SquadItem item = players.get(position);
        holder.name.setText("Name: " + item.getName());
        holder.position.setText("Position: " + item.getPosition());
        holder.nationality.setText("Nationality: " + item.getNationality());
        holder.role.setText("Role: " + item.getRole());
    }

    @Override
    public int getItemCount() {
        if (players == null) return 0;
        return players.size();
    }

    public void changeData(List<SquadItem> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, position, nationality, role;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.player_name);
            position = itemView.findViewById(R.id.player_position);
            role = itemView.findViewById(R.id.role);
            nationality = itemView.findViewById(R.id.nationality);
        }
    }
}
