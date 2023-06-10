package com.example.retrofit.Interface;

import com.example.retrofit.models.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    @GET ("pokemon/{pokemon}")
    Call<Pokemon> getPokemon(@Path("pokemon") String pokemon);
}
