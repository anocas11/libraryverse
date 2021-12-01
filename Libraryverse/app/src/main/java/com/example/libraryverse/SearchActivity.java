package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.libraryverse.APIRequests.DownloadTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class SearchActivity extends AppCompatActivity {

    EditText searchView;
    LinearLayout searchViewLL;
    ArrayList searchList;
    ArrayAdapter adapter;
    JSONArray arrayMovie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.searchViewSearchSearch);
        searchViewLL = findViewById(R.id.searchLL);

        DownloadTask task = new DownloadTask();

        try {
            arrayMovie = task.execute("https://libraryverse.herokuapp.com/api/movies/").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            arrayMovie = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            arrayMovie = null;
        }

        //https://www.tabnine.com/code/java/methods/android.widget.EditText/addTextChangedListener
        searchView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    DownloadTask task2 = new DownloadTask();
                    arrayMovie = task2.execute("https://libraryverse.herokuapp.com/api/movies/search?name=" + editable.toString()).get();

                    searchViewLL.removeAllViews();

                    for (int i = 0; i < arrayMovie.length(); i++) {
                        try {
                            JSONObject jsonPart = arrayMovie.getJSONObject(i);
                            TextView text = new TextView(getBaseContext());
                            text.setText(jsonPart.getString("name"));
                            text.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent itemView = new Intent(SearchActivity.this, ItemActivity.class);

                                    try
                                    {
                                        itemView.putExtra("id", jsonPart.getString("id"));
                                        itemView.putExtra("type", "movie");
                                        startActivity(itemView);
                                    }
                                    catch (Exception e)
                                    {

                                    }
                                }
                            });
                            searchViewLL.addView(text);
                        } catch (Exception e) {
                            Log.w("DEBUG", e.toString());
                        }
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    arrayMovie = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    arrayMovie = null;
                }
            }
        });
    }

    public void getMovies(View view)
    {
        if(arrayMovie != null)
        {
            for(int i=0; i<arrayMovie.length(); i++)
            {
                try
                {
                    searchList = new ArrayList<>();

                    JSONObject jsonPart = arrayMovie.getJSONObject(i);
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