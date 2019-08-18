package com.rawzadigital.iamhalalkitchen.pojo;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.bumptech.glide.Glide;

public class Tools {

    public static void displayImageOriginal(Context context, ImageView imageView, @DrawableRes int drawable){
        try {
            Glide.with(context).load(drawable).into(imageView);
        } catch (Exception e){

        }
    }
}
