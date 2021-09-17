package com.codingstuff.foodiez.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codingstuff.foodiez.R;
import com.google.android.material.snackbar.Snackbar;

public class FoodDetailActivity extends AppCompatActivity {

    private ImageView detailFoodImageView;
    private Button mBtn;
    private TextView detailFoodTitle,detailFoodDesc,detailFoodPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        mBtn = findViewById(R.id.orderBtn);

        detailFoodDesc = findViewById(R.id.detailFoodDesc);
        detailFoodImageView = findViewById(R.id.detialFoodImage);
        detailFoodPrice = findViewById(R.id.detailFoodPrice);
        detailFoodTitle = findViewById(R.id.detailFoodTitle);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("title");
        String mDesc = bundle.getString("desc");
        int mPrice = bundle.getInt("price");
        int mImage = bundle.getInt("image");

        detailFoodImageView.setImageResource(mImage);
        detailFoodTitle.setText(mTitle);
        detailFoodDesc.setText(mDesc);
        detailFoodPrice.setText(mPrice + "RS");

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(FoodDetailActivity.this,
                         "Order Placed " +  ("\ud83d\ude01") ,
                        Toast.LENGTH_SHORT);
                View toastView = toast.getView();
                toastView.setBackgroundResource(R.color.light_red);
                toast.setGravity(Gravity.CENTER_VERTICAL , 0 , 0);
                toast.show();
            }
        });
    }
}