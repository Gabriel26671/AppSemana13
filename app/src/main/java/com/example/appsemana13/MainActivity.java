package com.example.appsemana13;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsemana13.Adaptadores.AnimeAdapter;
import com.example.appsemana13.Adaptadores.EpisodeAdapter;
import com.example.appsemana13.Estr.Anime;
import com.example.appsemana13.Estr.AnimeResponse;
import com.example.appsemana13.Estr.Episode;
import com.example.appsemana13.Estr.EpisodeResponse;
import com.example.appsemana13.Retrofit.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AnimeAdapter animeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView animeRecyclerView = findViewById(R.id.animeRecyclerView);
        animeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        animeAdapter = new AnimeAdapter();
        animeRecyclerView.setAdapter(animeAdapter);

        fetchAnimeList();
    }

    private void fetchAnimeList() {
        Call<AnimeResponse> call = RetrofitInstance.getApi().getAnimeList();
        call.enqueue(new Callback<AnimeResponse>() {
            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Anime> animeList = response.body().getData();
                    animeAdapter.setAnimeList(animeList);
                }
            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}