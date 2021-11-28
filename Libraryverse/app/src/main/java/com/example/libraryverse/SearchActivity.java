package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.libraryverse.APIRequests.DownloadTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SearchActivity extends AppCompatActivity {

    EditText searchView;
    ListView listView;
    ArrayList searchList;
    ArrayAdapter adapter;
    JSONArray arrayMovie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.searchViewSearchSearch);
        listView = findViewById(R.id.listViewSearchSearch);

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

                    //listView.removeAllViews();

                    /*for (int i = 0; i < arrayMovie.length(); i++) {
                        try {
                            JSONObject jsonPart = arrayMovie.getJSONObject(i);
                            TextView text = new TextView(getBaseContext());
                            text.setText(jsonPart.getString("movie_name"));
                            listView.addView(text);
                        } catch (Exception e) {
                        }
                    }*/
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