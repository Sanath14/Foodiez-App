package com.codingstuff.foodiez.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.codingstuff.foodiez.R;
import com.codingstuff.foodiez.Utils.Food;

@Database(entities = {Food.class} , version = 1)
public abstract  class FoodDatabase extends RoomDatabase {

    private static FoodDatabase mInstance;

    public abstract FoodDao foodDao();

    public static synchronized FoodDatabase getmInstance(Context context){
        if (mInstance == null){
            mInstance = Room.databaseBuilder(context.getApplicationContext() ,
                    FoodDatabase.class
                    ,"food_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return mInstance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(mInstance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void , Void>{
        private FoodDao foodDao;

        PopulateDbAsyncTask(FoodDatabase database){
            foodDao = database.foodDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            foodDao.insert(new Food(R.drawable.pizza , "Pizza" , "One-of-a-kind semi-circle pizza for your personal pizza cravings! Choicest of veggies, baked to perfection - Crunchy Capsicum, American Corn, Onion and Mozzarella Cheese." , 299));
            foodDao.insert(new Food(R.drawable.dosa , "Dosa" , " scrumptious combo of dosa with potato, schezwan chutney and masala folded into it, cut into pieces; served with chutneys and sambhar and loaded cheese." , 59));
            foodDao.insert(new Food(R.drawable.veg_biryani , "Veg Biryani" , "Rice and veggies cooked in a fragrant and flavorful masala seasoned with Indian whole spices.; Served with salan and raita.", 199));
            foodDao.insert(new Food(R.drawable.noodles , "Noodles" , "Noodles sauteed with capsicum, spring onions, green chillies, mixed with shake shack secret sauce and seasoned with spices." , 299));
            foodDao.insert(new Food(R.drawable.paneer_butter , "Butter Paneer" , "Soft paneer cubes and flavored rice slow cooked in a delicious mix of Indian masala flavored with aromatic spices." , 250));
            foodDao.insert(new Food(R.drawable.pasta , "Pasta" , "White sauce, green zucchini, yellow zucchini, broccoli, red capsicum, yellow capsicum, green capsicum, garlic butter, orange." , 149));
            return null;
        }
    }
}
