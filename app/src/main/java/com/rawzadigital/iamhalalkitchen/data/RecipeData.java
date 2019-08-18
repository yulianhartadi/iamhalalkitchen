package com.rawzadigital.iamhalalkitchen.data;

import com.rawzadigital.iamhalalkitchen.R;
import com.rawzadigital.iamhalalkitchen.pojo.Image;
import com.rawzadigital.iamhalalkitchen.pojo.RecipeModel;

import java.util.ArrayList;

public class RecipeData {

    public static String[][] titleRecipe = new String[][]{
            {"Chill Coke and Full Burger", "20 min"},
            {"Mixed Fruit, Raspberry and Blueberry", "25 min"},
            {"Soto Bagas", "35 min"},
            {"Soto Bang Jack", "14 min"},
            {"Angkringan Bang Rozaq", "12 min"},
            {"Soto Gobyos", "15 min"},
            {"Susu Segar She Jack", "30 min"},
            {"Spesial Sambal", "20 min"},
            {"Steak Double", "18 min"},
            {"Wes ngantuk sesuk meneh", "23 min"}
    };

    public static int[] imageRecipe = new int[]{
            R.drawable.dummy_img_food1,
            R.drawable.dummy_img_food2,
            R.drawable.dummy_img_food3,
            R.drawable.dummy_img_food4,
            R.drawable.dummy_img_food5,
            R.drawable.dummy_img_random5,
            R.drawable.dummy_img_random7,
            R.drawable.dummy_img_food4,
            R.drawable.dummy_img_food2,
            R.drawable.dummy_img_food5
    };



    //TODO: ArrayList test cara 1
    /*
    public static ArrayList<RecipeModel> getListData() {
        RecipeModel recipeModel = null;
        ArrayList<RecipeModel> list = new ArrayList<>();
        for (String[] aTitleRecipe : titleRecipe) {
            recipeModel = new RecipeModel();
            recipeModel.setRecipeTitle(aTitleRecipe[0]);
            recipeModel.setRecipeTime(aTitleRecipe[1]);

            //recipeModel.setRecipeImage(imageRecipe[0]);
            recipeModel.setRecipeImage(imageRecipe[0]);
            list.add(recipeModel);

        }

        return list;
    } */


    //TODO: ArrayList test cara 2
    public static ArrayList<RecipeModel> getListData() {
        RecipeModel recipeModel = null;
        ArrayList<RecipeModel> listImage = new ArrayList<>();
        for (int i = 0; i < imageRecipe.length; i++) {
            recipeModel = new RecipeModel();
            recipeModel.setRecipeTitle(titleRecipe[i][0]);
            recipeModel.setRecipeTime(titleRecipe[i][1]);
            recipeModel.setRecipeImage(imageRecipe[i]);

            listImage.add(recipeModel);
        }
        return listImage;
    }


}
