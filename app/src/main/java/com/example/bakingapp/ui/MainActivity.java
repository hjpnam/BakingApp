package com.example.bakingapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bakingapp.R;
import com.example.bakingapp.shared.Recipe;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.RecipeAdapterOnClickHandler {
    private RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildRecyclerView();
    }


    private void buildRecyclerView() {
        RecyclerView recipeListRecyclerView = (RecyclerView) findViewById(R.id.rv_recipe_list);
        recipeListRecyclerView.setHasFixedSize(true);
        recipeListRecyclerView.setLayoutManager(new GridLayoutManager(this, R.integer.recipe_list_columns));
        recipeAdapter = new RecipeAdapter(this);
    }
// TODO check internet connection before making retrofit api call
    @Override
    public void onClick(Recipe recipe) {
        // TODO (2) implement onClick for recipe item
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT);
    }
}
