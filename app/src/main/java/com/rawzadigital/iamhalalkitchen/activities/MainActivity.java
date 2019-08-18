package com.rawzadigital.iamhalalkitchen.activities;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.balysv.materialripple.MaterialRippleLayout;
import com.google.android.material.navigation.NavigationView;
import com.rawzadigital.iamhalalkitchen.R;
import com.rawzadigital.iamhalalkitchen.adapter.RecipeCardAdapter;
import com.rawzadigital.iamhalalkitchen.data.RecipeData;
import com.rawzadigital.iamhalalkitchen.pojo.Image;
import com.rawzadigital.iamhalalkitchen.pojo.RecipeModel;
import com.rawzadigital.iamhalalkitchen.pojo.Tools;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMainActivity;
    private ArrayList<RecipeModel> listRecipe;
    private Toolbar toolbar;

    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private AdapterImageSlider adapterImageSlider;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    // Slider Image
    public static int[] imageSlider = new int[]{
            R.drawable.dummy_img_random7,
            R.drawable.dummy_img_random5,
            R.drawable.dummy_img_food7,
            R.drawable.dummy_img_food2,
            R.drawable.dummy_img_food5,
    };

    public static String[] titleSlider = new String[]{
            "Dui fringilla ornare finibus, orci odio",
            "Mauris sagittis non elit quis fermentum",
            "Mauris ultricies augue sit amet est sollicitudin",
            "Suspendisse ornare est ac auctor pulvinar",
            "Vivamus laoreet aliquam ipsum eget pretium",
    };

    public static String[] subTitleSlider = new String[]{
            "Foggy Hill",
            "The Backpacker",
            "River Forest",
            "Mist Mountain",
            "Side Park",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMainActivity = findViewById(R.id.rv_main_activity);
        rvMainActivity.setHasFixedSize(true);

        listRecipe = new ArrayList<>();
        listRecipe.addAll(RecipeData.getListData());
        // listRecipe.addAll(RecipeData.getListDataImage());

        setupToolbar();
        setupDrawerMenu();
        showCardList();
        setupSlider();

    }

    private void showCardList() {
        rvMainActivity.setLayoutManager(new LinearLayoutManager(this));
        RecipeCardAdapter recipeCardAdapter = new RecipeCardAdapter(this);
        recipeCardAdapter.setListRecipe(listRecipe);
        rvMainActivity.setAdapter(recipeCardAdapter);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
    }

    private void setupDrawerMenu() {
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.menu_main_drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Toast.makeText(getApplicationContext(), menuItem.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
                //TODO: To Activity/Fragment Menu

                drawerLayout.closeDrawers();
                return true;
            }
        });

        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void setupSlider() {
        linearLayout = findViewById(R.id.layout_dots);
        viewPager = findViewById(R.id.slider_pager);

        AdapterImageSlider adapterImageSlider = new AdapterImageSlider(this, new ArrayList<Image>());

        final List<Image> items = new ArrayList<>();
        for (int i = 0; i < imageSlider.length; i++){
            Image obj = new Image();
            obj.image = imageSlider[i];
            obj.title = titleSlider[i];
            obj.subTitle = subTitleSlider[i];
            items.add(obj);
        }

        adapterImageSlider.setItems(items);
        viewPager.setAdapter(adapterImageSlider);

        // displaying selected image first
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((TextView) findViewById(R.id.title_slider)).setText(items.get(position).title);
                ((TextView) findViewById(R.id.subtitle_slider)).setText(items.get(position).subTitle);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // Image Adapter

    // Bottom Dots

    // Image Slider
    private static class AdapterImageSlider extends PagerAdapter {
        private Activity activity;
        private List<Image> items;

        private AdapterImageSlider.OnItemClickListener onItemClickListener;


        private interface OnItemClickListener {
            void onItemClick(View view, Image object);
        }

        private void setOnItemClickListener(AdapterImageSlider.OnItemClickListener onItemClickListener){
            this.onItemClickListener = onItemClickListener;
        }

        //Constructor
        private AdapterImageSlider(Activity activity, List<Image> items){
            this.activity = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public Image getItem(int pos){
            return items.get(pos);
        }

        public void setItems(List<Image> items){
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            final Image o =items.get(position);
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.item_slider, container, false);

            ImageView image = v.findViewById(R.id.image_item_slider);
            MaterialRippleLayout layoutParent = v.findViewById(R.id.layout_parent);

            Tools.displayImageOriginal(activity, image, o.image);

            layoutParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (onItemClickListener != null ){}
                    onItemClickListener.onItemClick(v, o);
                }
            });

            container.addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            (container).removeView((RelativeLayout) object);
        }

    }


    // Search
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.item_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    //searchView.setIconified(true);
                }

                searchView.onActionViewCollapsed();
                Toast.makeText(MainActivity.this, "Result Query: " + query, Toast.LENGTH_LONG).show();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }


}
