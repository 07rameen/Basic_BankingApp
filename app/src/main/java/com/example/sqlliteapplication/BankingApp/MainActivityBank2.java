package com.example.sqlliteapplication.BankingApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqlliteapplication.R;

import java.util.ArrayList;

public class MainActivityBank2 extends AppCompatActivity {

    RecyclerView recyclerView;
    myDbAdapter1 myDb;
    ArrayList<String> UID, Name , Email, Balance;
    AdapterRecyclerView adapter;
    private AdapterRecyclerView.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bank);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        recyclerView=findViewById(R.id.recyclerview);

        myDb = new myDbAdapter1(MainActivityBank2.this);
        UID = new ArrayList<>();
        Name = new ArrayList<>();
        Email = new ArrayList<>();
        Balance = new ArrayList<>();

        display();
        setOnClickListener();
        adapter = new AdapterRecyclerView(MainActivityBank2.this,UID,Name,Email,Balance,listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityBank2.this));

    }

    private void setOnClickListener() {
        listener = new AdapterRecyclerView.RecyclerViewClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(),PageTwoShow.class);
                intent.putExtra("ID",UID.get(position));
                intent.putExtra("Name",Name.get(position));
                intent.putExtra("Email",Email.get(position));
                intent.putExtra("Balance",Balance.get(position));
                startActivity(intent);

            }
        };
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