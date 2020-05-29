package com.example.bakingapp.viewModels;


import androidx.lifecycle.MutableLiveData;

import com.example.bakingapp.shared.Recipe;
import com.example.bakingapp.utils.ApiService;
import com.example.bakingapp.utils.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeRepository {
    private static final ApiService mApiService = RetroClient.getApiService();
    private final MutableLiveData<List<Recipe>> recipeLiveData = new MutableLiveData<>();
    private static RecipeRepository recipeRepository;

    public static RecipeRepository getInstance() {
        if (recipeRepository == null) {
            recipeRepository = new RecipeRepository();
        }
        return recipeRepository;
    }

    public RecipeRepository() {}

    public MutableLiveData<List<Recipe>> getRecipeLiveData() {
        Call<List<Recipe>> call = mApiService.getRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                recipeLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                recipeLiveData.setValue(null);
            }
        });

        return recipeLiveData;
    }
}
