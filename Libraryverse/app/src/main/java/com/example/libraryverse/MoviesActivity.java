package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.libraryverse.APIRequests.DownloadTask;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MoviesActivity extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    LinearLayout llVertical, llHorizontal;
    User user;
    JSONArray myMoviesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        try{
            DownloadTask task = new DownloadTask();
            String url = "https://libraryverse.herokuapp.com/api/users/user/" + user.id + "/movies";
            myMoviesArray = task.execute(url).get();

            if(myMoviesArray == null)
            {
                return;
            }

            for(int i = 0; i < myMoviesArray.length(); i++)
            {
                try {
                    JSONObject jsonPart = myMoviesArray.getJSONObject(i);

                    ImageView poster = new ImageView(getBaseContext());
                    Picasso.get().load(jsonPart.getString("moviePoster")).into(poster);
                    //poster.setLayoutParams(params);
                    llHorizontal.addView(poster);

                    TextView title = new TextView(getBaseContext());
                    title.setText(jsonPart.getString("movieName"));
                    title.setTextColor(Color.parseColor("#FFFFFF"));
                    //title.setLayoutParams(params);
                    llHorizontal.addView(title);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void ClickSearch(View view){
        Intent i = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(i);
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
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickProfile(View view){
        //Redirect Activity to profile
        redirectActivity(this, ProfileActivity.class);
    }

    public void ClickFavouriteMovies(View view){
        //Recreate activity
        recreate();

    }

    public void ClickFavouriteBooks(View view){
        //Recreate activity to favourite books
        redirectActivity(this, BooksActivity.class);
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