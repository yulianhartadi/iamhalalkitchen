package com.rawzadigital.iamhalalkitchen.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rawzadigital.iamhalalkitchen.R;
import com.rawzadigital.iamhalalkitchen.pojo.RecipeModel;

import java.util.ArrayList;

public class RecipeCardAdapter extends RecyclerView.Adapter<RecipeCardAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<RecipeModel> listRecipe;

    public RecipeCardAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<RecipeModel> getListRecipe() {
        return listRecipe;
    }

    public void setListRecipe(ArrayList<RecipeModel> listRecipe) {
        this.listRecipe = listRecipe;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View viewRecipe = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_recipes,
                viewGroup, false);
        return new CardViewHolder(viewRecipe);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {

        RecipeModel recipeModel = getListRecipe().get(i);

        Glide.with(context)
                .load(recipeModel.getRecipeImage())
                .apply(new RequestOptions().override(500,500))
                .into(cardViewHolder.recipeImage);

        cardViewHolder.recipeTitle.setText(recipeModel.getRecipeTitle());
        cardViewHolder.recipeTime.setText(recipeModel.getRecipeTime());

        cardViewHolder.recipeTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Try Clicked", Toast.LENGTH_SHORT).show();
                // TODO: To detail recipe article

            }
        });

    }

    @Override
    public int getItemCount() {
        return getListRecipe().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView recipeImage;
        TextView recipeTitle, recipeTime, recipeTry;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            recipeImage = itemView.findViewById(R.id.img_recipe);
            recipeTitle = itemView.findViewById(R.id.title_recipe);
            recipeTime = itemView.findViewById(R.id.time_recipe);
            recipeTry = itemView.findViewById(R.id.try_recipe);

        }
    }


}
