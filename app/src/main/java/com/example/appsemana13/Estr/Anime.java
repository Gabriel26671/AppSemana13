package com.example.appsemana13.Estr;

import com.google.gson.annotations.SerializedName;

public class Anime{
    private int mal_id;
    private String title;
    private int episodes;
    @SerializedName("images.jpg.image_url")
    private String imageUrl;

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
