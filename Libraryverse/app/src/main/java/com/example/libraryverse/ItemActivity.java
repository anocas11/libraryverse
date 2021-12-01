package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        String itemId = getIntent().getStringExtra("id");
        String itemType = getIntent().getStringExtra("type");

        if(itemType == "movie")
        {
            Toast.makeText(getBaseContext(), itemId, Toast.LENGTH_LONG).show();
        }
    }
}