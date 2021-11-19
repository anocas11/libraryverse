package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.libraryverse.APIRequests.DownloadTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList searchList;
    ArrayAdapter adapter;
    JSONArray arrayBook = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.searchViewSearchSearch);
        listView = findViewById(R.id.listViewSearchSearch);

        DownloadTask task = new DownloadTask();

        try
        {
            arrayBook = task.execute("https://libraryverse.herokuapp.com/api/books/").get();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
            arrayBook = null;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            arrayBook = null;
        }
    }

    public void getBooks(View view)
    {
        if(arrayBook != null)
        {
            for(int i=0; i<arrayBook.length(); i++)
            {
                try {
                    searchList = new ArrayList<>();

                    JSONObject jsonPart = arrayBook.getJSONObject(i);
                    searchList.add(jsonPart);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }

        }
    }
}