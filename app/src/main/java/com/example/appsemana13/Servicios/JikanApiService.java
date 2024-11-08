package com.example.appsemana13.Servicios;

import com.example.appsemana13.Estr.AnimeResponse;
import com.example.appsemana13.Estr.EpisodeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JikanApiService {
    @GET("anime")
    Call<AnimeResponse> getAnimeList();

   @GET("anime/{id}/episodes")
    Call<EpisodeResponse> getAnimeEpisodes(@Path("id") int animeId);
}
