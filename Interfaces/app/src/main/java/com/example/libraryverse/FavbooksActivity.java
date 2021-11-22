package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class FavbooksActivity extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favbooks);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //Open drawer
        HomeActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        //Closed drawer
        HomeActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        HomeActivity.redirectActivity(this, HomeActivity.class);
    }

    public void ClickFavouriteMovies(View view){
        //Recreate activity to favourite movies
        HomeActivity.redirectActivity(this, FavmoviesActivity.class);


    }

    public void ClickFavouriteBooks(View view){
        //Recreate activity
        recreate();


    }

    public void ClickLogout(View view){
        //Close app
        HomeActivity.Logout(this);

    }

    @Override
    protected void onPause(){
        super.onPause();
        //Close drawer
        HomeActivity.closeDrawer(drawerLayout);
    }
}