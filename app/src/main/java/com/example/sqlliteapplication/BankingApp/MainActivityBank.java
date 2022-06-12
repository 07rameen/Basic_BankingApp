package com.example.sqlliteapplication.BankingApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sqlliteapplication.R;

import java.util.ArrayList;

public class MainActivityBank extends AppCompatActivity {

    RecyclerView recyclerView;
    myDbAdapter1 myDb;
    ArrayList<String> UID, Name , Email, Balance;
    AdapterRecyclerView adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bank);
        recyclerView=findViewById(R.id.recyclerview);

        myDb = new myDbAdapter1(MainActivityBank.this);
        UID = new ArrayList<>();
        Name = new ArrayList<>();
        Email = new ArrayList<>();
        Balance = new ArrayList<>();

        display();

        adapter = new AdapterRecyclerView(MainActivityBank.this,UID,Name,Email,Balance, adapter.listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityBank.this));

    }
    void display()
    {
        Cursor cursor = myDb.readallData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                UID.add(cursor.getString(0));
                Name.add(cursor.getString(1));
                Email.add(cursor.getString(2));
                Balance.add(cursor.getString(3));
            }
        }
    }

}