package com.example.appsemana13.Adaptadores;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appsemana13.Estr.Episode;
import com.example.appsemana13.R;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private List<Episode> episodeList;

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_item, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        Episode episode = episodeList.get(position);
        holder.bind(episode);
    }

    @Override
    public int getItemCount() {
        return (episodeList != null) ? episodeList.size() : 0;
    }

    class EpisodeViewHolder extends RecyclerView.ViewHolder {
        TextView episodeTitleTextView, episodeAiredTextView;

        EpisodeViewHolder(View itemView) {
            super(itemView);
            episodeTitleTextView = itemView.findViewById(R.id.episodeTitleTextView);
            episodeAiredTextView = itemView.findViewById(R.id.episodeAiredTextView);
        }

        void bind(Episode episode) {
            episodeTitleTextView.setText(episode.getTitle());
            episodeAiredTextView.setText("Aired: " + episode.getAired().getString());
        }
    }
}