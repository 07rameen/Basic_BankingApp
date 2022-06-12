package com.example.sqlliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class Second extends AppCompatActivity {

    TextView name,email;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name=findViewById(R.id.name);
        email=findViewById(R.id.emaill);
        pic=findViewById(R.id.picture);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String name1=intent.getStringExtra("Name");
        String email1 = intent.getStringExtra("Email");
        Uri uri = intent.getParcelableExtra("Picture");
        //Picasso.with(yourContext).load(uri).into(pic);
        pic.setImageURI(uri);
        name.setText(name1);
        email.setText(email1);
    }
}