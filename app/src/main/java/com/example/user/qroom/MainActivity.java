package com.example.user.qroom;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.user.qroom.adapter.CategoryAdapter;
import com.example.user.qroom.data.Category;
import com.example.user.qroom.listener.CategoryListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CategoryListener {

    @BindView(R.id.rv_home)
    RecyclerView rvCategory;

    CategoryAdapter categoryAdapter;
    ArrayList<Category> listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Antriku");

        //tentang rv Category
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        listCategory = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(listCategory,this);
        rvCategory.setAdapter(categoryAdapter);
        callCategoryData();



    }

    private void callCategoryData() {
        listCategory = new ArrayList<>();

        Category category = new Category(0,"Administrasi",R.drawable.test1);
        listCategory.add(category);
        category = new Category(1,"Kesehatan",R.drawable.test1);
        listCategory.add(category);
        category = new Category(2,"Paspor",R.drawable.test1);
        listCategory.add(category);
        category = new Category(3,"Kepolisian",R.drawable.test1);
        listCategory.add(category);
        category = new Category(4,"Perbankan",R.drawable.test1);
        listCategory.add(category);

        categoryAdapter.refreshData(listCategory);

    }

    @Override
    public void onCardClicked(Category category) {
        final Intent intent = new Intent(getApplicationContext(),ListCategoryActivity.class);
        intent.putExtra("status",category.getStatus());
        intent.putExtra("judul",category.getNamaKategori());
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(intent);
                finish();
            }
        }, 200);
    }
}
