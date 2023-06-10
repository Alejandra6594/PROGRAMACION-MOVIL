package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofit.Interface.PokemonService;
import com.example.retrofit.models.Pokemon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtEesponse;
    EditText txtBuscador;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEesponse=findViewById(R.id.txt_r);
        txtBuscador = findViewById(R.id.edit_txt);
        btnBuscar = findViewById(R.id.btn_buscar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokemonService service = retrofit.create(PokemonService.class);
        Call<Pokemon> poke = service.getPokemon("jigglypuff");
        poke.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon p = response.body();
                txtEesponse.setText(p.id+"- "+p.name);

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) { call.cancel(); }
        });
    }
}