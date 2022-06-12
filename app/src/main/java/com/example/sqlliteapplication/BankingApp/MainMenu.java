package com.example.sqlliteapplication.BankingApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sqlliteapplication.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void ViewCustomers(View view) {
        Intent intent = new Intent(this,MainActivityBank2.class);
        startActivity(intent);
    }

    public void ViewTransferables(View view) {
        Intent intent = new Intent(this,MainActivityBank2.class);
        startActivity(intent);
    }

}