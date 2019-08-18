package com.rawzadigital.iamhalalkitchen.data;

import com.rawzadigital.iamhalalkitchen.pojo.Recipe;

import java.util.ArrayList;

public class RecipeData {

    public static String[][] recipeData = new String[][]{
            {"Butter Chicken", "Ruhana Ebrahim","detail a", "https://images.halaal.recipes/18-08-19/2019-08-18-11-57-40-41KCk.jpg"},
            {"Carrot Cakes", "Najiya", "detail ", "https://images.halaal.recipes/17-08-19/2019-08-17-15-55-20-mVcmF.jpg"},
            {"Potato Salad", "Aqueelah Hadia", "content", "https://images.halaal.recipes/17-08-19/2019-08-17-13-04-02-j9pPo.jpg"},
            {"Tomato Mac & Cheezy", "Shaheema Khan", "content", "https://images.halaal.recipes/15-08-19/2019-08-15-16-03-41-b3JWF.jpg"},
            {"Kaleji", "Naeema Mia", "content", "https://images.halaal.recipes/14-08-19/2019-08-14-16-57-56-he36u.jpg"},
            {"Roasted Vegetables", "Sumayah Ebrahim", "content", "https://images.halaal.recipes/09-08-19/2019-08-09-19-10-04-s5Sb7.jpg"},
            {"Roti Wraps", "Fatima A Latif", "content","https://images.halaal.recipes/08-08-19/2019-08-08-11-33-51-Lf4gX.jpg"},
            {"Green Chilli Akni", "Naseema Khan", "content", "https://images.halaal.recipes/07-08-19/2019-08-07-07-57-09-Eq7Jj.jpg"},
            {"Turkish Apricot & Roasted Butternut Biryani", "Fatima noor Chand", "content", "https://images.halaal.recipes/23-07-19/2019-07-23-12-59-11-PwmOZ.jpg"},
            {"Flat Naan Pita", "Mashuda", "content", "https://images.halaal.recipes/16-07-19/2019-07-16-22-11-29-0xEtw.jpg"},
            {"Prego Pitas", "mashuda", "content", "https://images.halaal.recipes/29-03-18/2018-03-29-10-59-09-W2QIT.jpg"}
    };


    //TODO: ArrayList test cara 1
    public static ArrayList<Recipe> getListData() {
        ArrayList<Recipe> list = new ArrayList<>();
        for (String[] aRecipeData : recipeData) {
            Recipe recipe = new Recipe();
            recipe.setRecipeTitle(aRecipeData[0]);
            recipe.setRecipeAuthor(aRecipeData[1]);
            recipe.setRecipeContent(aRecipeData[2]);
            recipe.setRecipeImage(aRecipeData[3]);

            list.add(recipe);
        }

        return list;
    }


    //TODO: ArrayList test cara 2
    /*public static ArrayList<Recipe> getListData() {
        Recipe recipeModel = null;
        ArrayList<Recipe> listImage = new ArrayList<>();
        for (int i = 0; i < imageRecipe.length; i++) {
            recipeModel = new Recipe();
            recipeModel.setRecipeTitle(titleRecipe[i][0]);
            recipeModel.setRecipeTime(titleRecipe[i][1]);
            recipeModel.setRecipeImage(imageRecipe[i]);

            listImage.add(recipeModel);
        }
        return listImage;
    }*/


}
