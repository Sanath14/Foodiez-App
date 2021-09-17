package com.codingstuff.foodiez.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.codingstuff.foodiez.Database.FoodRepository;
import com.codingstuff.foodiez.Utils.Food;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private FoodRepository repository;
    private LiveData<List<Food>> foodList;

    public FoodViewModel(@NonNull Application application) {
        super(application);
        repository = new FoodRepository(application);
        foodList = repository.getAllNotes();
    }

    public LiveData<List<Food>> getAllFood(){
        return foodList;
    }

}
