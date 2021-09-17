package com.codingstuff.foodiez.Utils;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class Food {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String desc;
    private int price;
    private int image;

    public Food(int image,String title, String desc, int price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }
}
