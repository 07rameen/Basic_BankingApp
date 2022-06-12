package com.example.sqlliteapplication.BankingApp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlliteapplication.R;

public class PageTwoShow extends AppCompatActivity {
    private static final String TAG = "PageTwoShow";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagetwo);
        Log.d(TAG, "onCreate: pagetwostarted");

        getIncomingIntent();

    }

    private void getIncomingIntent()
    {
        Log.d(TAG, "getIncomingIntent: Get incoming Intent");
        if(getIntent().hasExtra("ID") && getIntent().hasExtra("Name") && getIntent().hasExtra("Email") && getIntent().hasExtra("Balance"))
        {
            String idcustomer = getIntent().getStringExtra("ID");
            String Namecustomer = getIntent().getStringExtra("Name");
            String Emailcustomer = getIntent().getStringExtra("Email");
            String Balancecustomer = getIntent().getStringExtra("Balance");

            setImage(idcustomer,Namecustomer,Emailcustomer,Balancecustomer);
        }
    }

    private void setImage(String idcustomer, String Namecustomer, String Emailcustomer, String BalanceCustomer)
    {
        TextView cid,cname,cmail,cbalance;
        //cid = findViewById(R.id.custid);
        cname = findViewById(R.id.custname);
        cmail=findViewById(R.id.custemail);
        cbalance=findViewById(R.id.custbal);

        //cid.setText(idcustomer);
        cname.setText(Namecustomer);
        cmail.setText(Emailcustomer);
        cbalance.setText(BalanceCustomer);

    }

}
