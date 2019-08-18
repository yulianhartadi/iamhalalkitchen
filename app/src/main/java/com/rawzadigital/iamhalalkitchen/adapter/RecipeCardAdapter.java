package com.rawzadigital.iamhalalkitchen.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rawzadigital.iamhalalkitchen.R;
import com.rawzadigital.iamhalalkitchen.pojo.Recipe;

import java.util.ArrayList;

public class RecipeCardAdapter extends RecyclerView.Adapter<RecipeCardAdapter.CardViewHolder> {

    private ArrayList<Recipe> listRecipe;

    public RecipeCardAdapter(ArrayList<Recipe> listRecipe) {
        this.listRecipe = listRecipe;
    }

    @NonNull
    @Override
    public RecipeCardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_recipes, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeCardAdapter.CardViewHolder holder, int position) {

        Recipe recipe = listRecipe.get(position);

        holder.tvTitleRecipe.setText(recipe.getRecipeTitle());
        holder.tvAuthorRecipe.setText(recipe.getRecipeAuthor());
        holder.tvBtnTryRecipe.setText(recipe.getRecipeContent());

        Glide.with(holder.itemView.getContext())
                .load(recipe.getRecipeImage())
                .apply(new RequestOptions().override(500, 500))
                .into(holder.imgRecipes);
    }

    @Override
    public int getItemCount() {
        return listRecipe.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgRecipes;
        TextView tvTitleRecipe, tvAuthorRecipe, tvBtnTryRecipe;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgRecipes = itemView.findViewById(R.id.img_recipe);
            tvTitleRecipe = itemView.findViewById(R.id.tv_title_recipe);
            tvAuthorRecipe = itemView.findViewById(R.id.tv_author_recipe);
            tvBtnTryRecipe = itemView.findViewById(R.id.tv_btn_try_recipe);
        }
    }
}
