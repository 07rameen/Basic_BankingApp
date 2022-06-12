package com.example.sqlliteapplication.BankingApp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlliteapplication.R;


public class BankingMainActivity extends AppCompatActivity {

    EditText Name, Email , Balance;
    myDbAdapter1 helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking_main);
        Name= findViewById(R.id.editName);
        Email = findViewById(R.id.editPass);
        Balance = findViewById(R.id.editPass3);
        helper = new myDbAdapter1(this);
    }

    public void addUser(View view)
    {
        String t1 = Name.getText().toString();
        String t2 = Email.getText().toString();
        String t3 = Balance.getText().toString();
        if(t1.isEmpty() || t2.isEmpty() || t3.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Name and Password and Balance");
        }
        else
        {
            long id = helper.insertData(t1,t2,t3);
            if(id<=0)
            {
                Message.message(getApplicationContext(),"Insertion Unsuccessful");
                Name.setText("");
                Email.setText("");
                Balance.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                Name.setText("");
                Email.setText("");
                Balance.setText("");
            }
        }
    }

    public void viewdata(View view)
    {
        String data = helper.getData();
        Message.message(this,data);
    }

}