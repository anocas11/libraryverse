package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
    JSONArray arrayBook = null;
    JSONArray arrayActor = null;
    JSONArray arrayAuthor = null;
    //Initialize variable
    DrawerLayout drawerLayout;

    public void getSearchArray(String linkVariable, String type, Editable editable)
    {
        JSONArray array;

        try {
            DownloadTask task2 = new DownloadTask();
            array = task2.execute("https://libraryverse.herokuapp.com/api/" + linkVariable + "/search?name=" + editable.toString()).get();

            for (int i = 0; i < array.length(); i++) {
                try {
                    JSONObject jsonPart = array.getJSONObject(i);
                    TextView text = new TextView(getBaseContext());
                    text.setText(jsonPart.getString("name"));
                    text.setPadding(5, 20, 5, 20);
                    text.setTextColor(Color.parseColor("#FFFFFF"));
                    text.setTextSize(16);
                    text.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent itemView = new Intent(SearchActivity.this, ItemActivity.class);

                            try
                            {
                                itemView.putExtra("id", jsonPart.getString("id"));
                                itemView.putExtra("type", type);
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
            array = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            array = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        searchView = findViewById(R.id.searchViewSearchSearch);
        searchViewLL = findViewById(R.id.searchLL);

        DownloadTask taskMovie = new DownloadTask();
        DownloadTask taskBook = new DownloadTask();

        try {
            arrayMovie = taskMovie.execute("https://libraryverse.herokuapp.com/api/movies/").get();
            arrayBook = taskBook.execute("https://libraryverse.herokuapp.com/api/books/").get();
            //arrayActor = task.execute("https://libraryverse.herokuapp.com/api/authors/").get();
            //arrayAuthor = task.execute("https://libraryverse.herokuapp.com/api/actors/").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            arrayMovie = null;
            arrayBook = null;
            //arrayActor = null;
            //arrayAuthor = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            arrayMovie = null;
            arrayBook = null;
            //arrayActor = null;
            //arrayAuthor = null;
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
                searchViewLL.removeAllViews();
                getSearchArray("movies", "movie", editable);

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


        public void ClickMenu(View view){
            //Open drawer
            MainActivity.openDrawer(drawerLayout);
        }

        public void ClickLogo(View view){
            //Closed drawer
            MainActivity.closeDrawer(drawerLayout);
        }

        public void ClickHome(View view){
            //Redirect activity to home
            redirectActivity(this, MainActivity.class);
        }

        public void ClickFavouriteMovies(View view){
            //Redirect activity to Favourite Movies
            redirectActivity(this, FavmoviesActivity.class);
        }


        public void ClickFavouriteBooks(View view){
            //Recreate activity
            redirectActivity(this, FavbooksActivity.class);

        }

        public void ClickProfile(View view) {
        //Redirect activity to Profile
            redirectActivity(this, ProfileActivity.class);
        }

        public void ClickLogout(View view){
            //Close app
            MainActivity.Logout(this);

        }

        public static void redirectActivity(Activity activity, Class aclass) {
        //initialize intent
        Intent intent = new Intent(activity, aclass);
        //Set Flg
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }


        @Override
        protected void onPause(){
            super.onPause();
            //Close drawer
            MainActivity.closeDrawer(drawerLayout);
        }
}
