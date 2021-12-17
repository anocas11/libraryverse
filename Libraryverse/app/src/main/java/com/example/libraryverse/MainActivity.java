package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PictureInPictureParams;
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
    ImageView img1;
    ImageView img2;
    ImageView img3;
    TextView text1;
    TextView text2;
    TextView text3;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variables
        drawerLayout = findViewById(R.id.drawer_layout);
        img1 = findViewById(R.id.imageViewHome1);
        img2 = findViewById(R.id.imageViewHome2);
        img3 = findViewById(R.id.imageViewHome3);

        JSONArray lastBooksAddedArray;

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
                Picasso.get().load(jsonPart1.getString("bookPoster")).into(img1);
                text1.setText(jsonPart1.getString("bookName"));

                JSONObject jsonPart2 = lastBooksAddedArray.getJSONObject(1);
                Picasso.get().load(jsonPart2.getString("bookPoster")).into(img2);
                text2.setText(jsonPart2.getString("bookName"));

                JSONObject jsonPart3 = lastBooksAddedArray.getJSONObject(2);
                Picasso.get().load(jsonPart3.getString("bookPoster")).into(img3);
                text2.setText(jsonPart3.getString("bookName"));
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

    public void ClickFavouriteMovies(View view){
        //Redirect activity to favourite movies
        redirectActivity(this, FavmoviesActivity.class);
    }

    public void ClickFavouriteBooks(View view){
        //Redirect activity favourite book
        redirectActivity(this, FavbooksActivity.class);
    }

    public void ClickProfile(View view){
        //Redirect activity to profile
        redirectActivity(this, ProfileActivity.class);
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