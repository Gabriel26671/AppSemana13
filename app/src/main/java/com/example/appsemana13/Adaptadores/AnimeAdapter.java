package com.example.appsemana13.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appsemana13.Estr.Anime;
import com.example.appsemana13.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private List<Anime> animeList;

    public void setAnimeList(List<Anime> animeList) {
        this.animeList = animeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_item, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.bind(anime);

    }

    @Override
    public int getItemCount() {
        return (animeList != null) ? animeList.size() : 0;
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView animeImageView;
        TextView animeTitleTextView, animeEpisodesTextView;

        AnimeViewHolder(View itemView) {
            super(itemView);
            animeImageView = itemView.findViewById(R.id.animeImageView);
            animeTitleTextView = itemView.findViewById(R.id.animeTitleTextView);
            animeEpisodesTextView = itemView.findViewById(R.id.animeEpisodesTextView);
        }

        void bind(Anime anime) {
            animeTitleTextView.setText(anime.getTitle());
            animeEpisodesTextView.setText("Episodes: " + anime.getEpisodes());
            Glide.with(itemView.getContext())
                    .load(anime.getImageUrl())
                    .into(animeImageView);
        }
    }
}
