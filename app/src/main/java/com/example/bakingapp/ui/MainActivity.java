package com.example.bakingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bakingapp.R;
import com.example.bakingapp.shared.Recipe;
import com.example.bakingapp.viewModels.RecipeViewModel;

import java.util.List;



public class MainActivity extends AppCompatActivity implements RecipeAdapter.RecipeAdapterOnClickHandler {
    private RecipeAdapter mRecipeAdapter;
    private RecipeViewModel mRecipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildRecyclerView();
        initViewModel();
    }

    private void buildRecyclerView() {
        RecyclerView recipeListRecyclerView = (RecyclerView) findViewById(R.id.rv_recipe_list);
        recipeListRecyclerView.setHasFixedSize(true);
        recipeListRecyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.grid_col_count)));
        mRecipeAdapter = new RecipeAdapter(this);
        recipeListRecyclerView.setAdapter(mRecipeAdapter);
    }

    private void initViewModel() {
        mRecipeViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);
        mRecipeViewModel.getRecipeLiveData().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                mRecipeAdapter.setRecipeList(recipes);
            }
        });
    }

    @Override
    public void onClick(Recipe recipe) {
        // TODO (2) implement onClick for recipe item
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();

    }
}
