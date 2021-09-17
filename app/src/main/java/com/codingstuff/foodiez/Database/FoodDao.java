package com.codingstuff.foodiez.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.codingstuff.foodiez.Utils.Food;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    public void insert(Food food);

    @Query("SELECT * FROM food_table ")
    LiveData<List<Food>> getAllFood();
}
