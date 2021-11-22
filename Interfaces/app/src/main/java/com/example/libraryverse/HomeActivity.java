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


public class HomeActivity extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Assign variables
        drawerLayout = findViewById(R.id.drawer_layout);
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

