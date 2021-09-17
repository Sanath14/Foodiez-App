package com.codingstuff.foodiez.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codingstuff.foodiez.R;
import com.codingstuff.foodiez.Utils.Food;
import com.codingstuff.foodiez.Utils.FoodAdapter;
import com.codingstuff.foodiez.ViewModel.FoodViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FoodViewModel viewModel;
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.main_container);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this , 2));

        viewModel = new ViewModelProvider(this ,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(FoodViewModel.class);

        viewModel.getAllFood().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                adapter = new FoodAdapter(foods);
                mRecyclerView.setAdapter(adapter);
            }
        });

    }
}