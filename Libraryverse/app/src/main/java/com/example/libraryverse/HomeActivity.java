package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        initializeMyListView();

    }

    private void initializeMyListView()
    {
        ListView myList = (ListView) findViewById(R.id.ListView);

        ArrayList<String> myItems = new ArrayList<String>();
        myItems.add("Filmes");
        myItems.add("Livros");
        myItems.add("Log Out");
        myItems.add("Profile");

        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myItems);

        myList.setAdapter(myListAdapter);

    }



}