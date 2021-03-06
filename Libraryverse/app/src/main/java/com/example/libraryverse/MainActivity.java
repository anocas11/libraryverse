package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.libraryverse.APIRequests.DownloadTask;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    ImageView imgBooks1, imgBooks2, imgBooks3, imgMovies1, imgMovies2, imgMovies3;
    TextView textBooks1, textBooks2, textBooks3, textMovies1, textMovies2, textMovies3;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variables
        drawerLayout = findViewById(R.id.drawer_layout);
        imgBooks1 = findViewById(R.id.imageViewHomeBooks1);
        imgBooks2 = findViewById(R.id.imageViewHomeBooks2);
        imgBooks3 = findViewById(R.id.imageViewHomeBooks3);
        imgMovies1 = findViewById(R.id.imageViewHomeMovies1);
        imgMovies2 = findViewById(R.id.imageViewHomeMovies2);
        imgMovies3 = findViewById(R.id.imageViewHomeMovies3);
        textBooks1 = findViewById(R.id.textViewHomeBooks1);
        textBooks2 = findViewById(R.id.textViewHomeBooks2);
        textBooks3 = findViewById(R.id.textViewHomeBooks3);
        textMovies1 = findViewById(R.id.textViewHomeMovies1);
        textMovies2 = findViewById(R.id.textViewHomeMovies2);
        textMovies3 = findViewById(R.id.textViewHomeMovies3);

        JSONArray lastBooksAddedArray;
        JSONArray lastMoviesAddedArray;

        try
        {
            DownloadTask task1 = new DownloadTask();
            String url1 = "https://libraryverse.herokuapp.com/api/users/user/" + user.id +"/lastbooks";
            lastBooksAddedArray = task1.execute(url1).get();

            if(lastBooksAddedArray == null)
            {
                return;
            }

            try
            {
                JSONObject jsonPart1 = lastBooksAddedArray.getJSONObject(0);
                JSONObject jsonPart2 = lastBooksAddedArray.getJSONObject(1);
                JSONObject jsonPart3 = lastBooksAddedArray.getJSONObject(2);

                Picasso.get().load(jsonPart1.getString("bookPoster")).into(imgBooks1);
                textBooks1.setText(jsonPart1.getString("bookName"));
                imgBooks1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itemView = new Intent(MainActivity.this, ItemActivity.class);

                        try
                        {
                            itemView.putExtra("id", jsonPart1.getString("bookid"));
                            itemView.putExtra("type", "book");
                            startActivity(itemView);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                });

                Picasso.get().load(jsonPart2.getString("bookPoster")).into(imgBooks2);
                textBooks2.setText(jsonPart2.getString("bookName"));

                imgBooks2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itemView = new Intent(MainActivity.this, ItemActivity.class);

                        try
                        {
                            itemView.putExtra("id", jsonPart2.getString("bookid"));
                            itemView.putExtra("type", "book");
                            startActivity(itemView);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                });

                Picasso.get().load(jsonPart3.getString("bookPoster")).into(imgBooks3);
                textBooks3.setText(jsonPart3.getString("bookName"));

                imgBooks3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itemView = new Intent(MainActivity.this, ItemActivity.class);

                        try
                        {
                            itemView.putExtra("id", jsonPart3.getString("bookid"));
                            itemView.putExtra("type", "book");
                            startActivity(itemView);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            DownloadTask task1 = new DownloadTask();
            String url1 = "https://libraryverse.herokuapp.com/api/users/user/" + user.id +"/lastmovies";
            lastMoviesAddedArray = task1.execute(url1).get();

            if(lastMoviesAddedArray == null)
            {
                return;
            }

            try
            {
                JSONObject jsonPart1 = lastMoviesAddedArray.getJSONObject(0);
                JSONObject jsonPart2 = lastMoviesAddedArray.getJSONObject(1);
                JSONObject jsonPart3 = lastMoviesAddedArray.getJSONObject(2);

                Picasso.get().load(jsonPart1.getString("moviePoster")).into(imgMovies1);
                textMovies1.setText(jsonPart1.getString("movieName"));

                imgMovies1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itemView = new Intent(MainActivity.this, ItemActivity.class);

                        try
                        {
                            itemView.putExtra("id", jsonPart1.getString("movieid"));
                            itemView.putExtra("type", "movie");
                            startActivity(itemView);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                });

                Picasso.get().load(jsonPart2.getString("moviePoster")).into(imgMovies2);
                textMovies2.setText(jsonPart2.getString("movieName"));

                imgMovies2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itemView = new Intent(MainActivity.this, ItemActivity.class);

                        try
                        {
                            itemView.putExtra("id", jsonPart2.getString("movieid"));
                            itemView.putExtra("type", "movie");
                            startActivity(itemView);
                        }
                        catch (Exception e)
                        {

                        }
                    }

                });

                Picasso.get().load(jsonPart3.getString("moviePoster")).into(imgMovies3);
                textMovies3.setText(jsonPart3.getString("movieName"));

                imgMovies3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent itemView = new Intent(MainActivity.this, ItemActivity.class);

                        try
                        {
                            itemView.putExtra("id", jsonPart3.getString("movieid"));
                            itemView.putExtra("type", "movie");
                            startActivity(itemView);
                        }
                        catch (Exception e)
                        {

                        }
                    }
                });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void ClickSearch(View view){
        Intent i = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(i);
    }


    public void ClickMenu(View view){
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer layout
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activty
        recreate();
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

    public void ClickProfile(View view){
        //Redirect activity to profile
        redirectActivity(this, ProfileActivity.class);
    }

    public void ClickMaps(View view){
        //Recreate activity to favourite books
        redirectActivity(this, EventsActivity.class);
    }

    public void ClickLogout(View view){
        //Close app
        Logout(this);
    }

    public static void Logout(Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout?");
        //Positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);

            }
        });

        //Negative no button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();
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
        closeDrawer(drawerLayout);
    }


}