package com.example.bakingapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.databinding.RecipeListItemBinding;
import com.example.bakingapp.shared.Recipe;

import java.util.ArrayList;
import java.util.List;


public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeAdapterViewHolder> {
    private List<Recipe> mRecipeList;
    private final RecipeAdapterOnClickHandler mClickHandler;

    RecipeAdapter(RecipeAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
        mRecipeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecipeAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        RecipeListItemBinding itemBinding = RecipeListItemBinding.inflate(inflater, parent, false);
        return new RecipeAdapterViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(RecipeAdapterViewHolder holder, int position) {
        Recipe recipe = mRecipeList.get(position);
        holder.recipeNameView.setText(recipe.getName());
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    public void setRecipeList(List<Recipe> recipeList) {
        if (recipeList == null) mRecipeList = null;
        mRecipeList = new ArrayList<>(recipeList);
        notifyDataSetChanged();
    }

    public interface RecipeAdapterOnClickHandler {
        void onClick(Recipe recipe);
    }

    class RecipeAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView recipeNameView;

        public RecipeAdapterViewHolder(RecipeListItemBinding binding) {
            super(binding.getRoot());
            recipeNameView = binding.tvRecipeName;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Recipe selectedRecipe = mRecipeList.get(adapterPosition);
            mClickHandler.onClick(selectedRecipe);
        }
    }
}
