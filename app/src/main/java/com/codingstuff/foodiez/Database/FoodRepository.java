package com.codingstuff.foodiez.Database;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.codingstuff.foodiez.Utils.Food;

import java.util.List;

public class FoodRepository {

    private FoodDao foodDao;
    private LiveData<List<Food>> foodList;
    public FoodRepository(Application application){
        FoodDatabase noteDatabase = FoodDatabase.getmInstance(application);
        foodDao = noteDatabase.foodDao();
        foodList = foodDao.getAllFood();
    }
    public LiveData<List<Food>> getAllNotes(){
        return foodList;
    }

}
