package com.vikaskumar.examschedulercbitss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;

import com.vikaskumar.examschedulercbitss.Adapters.CategoryAdapter;
import com.vikaskumar.examschedulercbitss.Models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        recyclerView = findViewById(R.id.recycler_view);

        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("IT Cources", R.drawable.cbitss));
        list.add(new CategoryModel("Accounting", R.drawable.cbitss));
        list.add(new CategoryModel("English", R.drawable.cbitss));
        list.add(new CategoryModel("Project", R.drawable.cbitss));
        list.add(new CategoryModel("Certification", R.drawable.cbitss));
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(list, getApplicationContext());
        recyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}