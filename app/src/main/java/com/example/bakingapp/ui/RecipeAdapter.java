package com.example.bakingapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new RecipeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeAdapterViewHolder holder, int position) {
        Recipe recipe = mRecipeList.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    public void setRecipeList(List<Recipe> recipeList) {
        mRecipeList = recipeList;
    }

    public interface RecipeAdapterOnClickHandler {
        void onClick(Recipe recipe);
    }

    class RecipeAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RecipeListItemBinding binding;

        public RecipeAdapterViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind (Recipe item) {
            binding.setRecipe(item);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Recipe selectedRecipe = mRecipeList.get(adapterPosition);
            mClickHandler.onClick(selectedRecipe);
        }
    }
}
