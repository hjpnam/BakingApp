package com.example.bakingapp.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bakingapp.shared.Recipe;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {
    RecipeRepository repository;
    private LiveData<List<Recipe>> recipeLiveData;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        repository = RecipeRepository.getInstance();
        recipeLiveData = repository.getRecipeLiveData();
    }

    public LiveData<List<Recipe>> getRecipeLiveData() {
        return recipeLiveData;
    }

}
