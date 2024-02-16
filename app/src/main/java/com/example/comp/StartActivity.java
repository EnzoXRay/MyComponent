package com.example.comp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        TextView mTitle = findViewById(com.example.base.R.id.tv_title);
        mTitle.setText("Start Page");

        ImageView mBtnBack = findViewById(com.example.base.R.id.btn_back);
        mBtnBack.setVisibility(View.GONE);
    }

    public void enter(View view){
        startActivity(new Intent(StartActivity.this, HomeActivity.class));
    }
}
