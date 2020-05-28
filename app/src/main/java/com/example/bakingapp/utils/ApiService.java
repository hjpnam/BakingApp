package com.example.bakingapp.utils;

import com.example.bakingapp.shared.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/baking.json")
    Call<List<Recipe>> getRecipesJSON();
}
