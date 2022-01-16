package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridLayout;
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
    GridLayout gridLayout;
    JSONArray myMoviesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        gridLayout = findViewById(R.id.gridView);

        try{
            DownloadTask task = new DownloadTask();
            String url = "https://libraryverse.herokuapp.com/api/users/user/" + User.id + "/movies";
            myMoviesArray = task.execute(url).get();

            if(myMoviesArray == null)
            {
                return;
            }

            for(int i = 0; i < myMoviesArray.length(); i++)
            {
                try {
                    LinearLayout linearLayout = new LinearLayout(getBaseContext());
                    linearLayout.setOrientation(LinearLayout.VERTICAL);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.setMargins(20, 15, 20, 15);

                    JSONObject jsonPart = myMoviesArray.getJSONObject(i);


                    LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(convertDpToPixel(105, getBaseContext()), LinearLayout.LayoutParams.WRAP_CONTENT);
                    imageParams.setMargins(20, 15, 20, 15);
                    ImageView poster = new ImageView(getBaseContext());
                    Picasso.get().load(jsonPart.getString("moviePoster")).into(poster);
                    poster.setLayoutParams(imageParams);
                    poster.setAdjustViewBounds(true);
                    linearLayout.addView(poster);
                    poster.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent itemView = new Intent(MoviesActivity.this, ItemActivity.class);
                            try {
                                itemView.putExtra("id", jsonPart.getString("movieid"));
                                itemView.putExtra("type", "movie");
                                startActivity(itemView);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(convertDpToPixel(100, getBaseContext()), LinearLayout.LayoutParams.WRAP_CONTENT);
                    textParams.setMargins(20, 15, 20, 15);
                    TextView title = new TextView(getBaseContext());
                    title.setText(jsonPart.getString("movieName"));
                    title.setTextColor(Color.parseColor("#FFFFFF"));
                    title.setLayoutParams(textParams);
                    linearLayout.addView(title);

                    gridLayout.addView(linearLayout);

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

    public void ClickMaps(View view){
        //Recreate activity to favourite books
        redirectActivity(this, EventsActivity.class);
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

    public static int convertDpToPixel(int dp, Context context){
        return dp * ((int) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    @Override
    protected void onPause(){
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }


}