package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.TextView;

import com.example.libraryverse.APIRequests.DownloadTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
            String url = "https://libraryverse.herokuapp.com/api/" + linkVariable + "/search?name=" + editable.toString();
            array = task2.execute(url).get();

            if(array == null){
                return;
            }

            for (int i = 0; i < array.length(); i++) {
                try {
                    JSONObject jsonPart = array.getJSONObject(i);
                    TextView text = new TextView(getBaseContext());
                    text.setText(type + ": " + jsonPart.getString("name"));
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
                getSearchArray("books", "book", editable);
                getSearchArray("authors", "author", editable);
                getSearchArray("actors", "actor", editable);

            }
        });
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

    public void ClickMovies(View view){
        //Recreate activity
        redirectActivity(this, MoviesActivity.class);
    }

    public void ClickBooks(View view){
        //Recreate activity to favourite books
        redirectActivity(this, BooksActivity.class);
    }

    public void ClickFavMovies(View view){
        //Recreate activity
        redirectActivity(this, FavoriteMoviesActivity.class);
    }

    public void ClickFavBooks(View view){
        //Recreate activity to favourite books
        redirectActivity(this, FavoriteBooksActivity.class);
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
