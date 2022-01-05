package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libraryverse.APIRequests.UserService;
import com.example.libraryverse.models.EditProfileModel;
import com.example.libraryverse.models.EditProfileRequest;
import com.example.libraryverse.models.ProfileModel;
import com.example.libraryverse.models.ProfileRequest;

import java.util.concurrent.ExecutionException;

public class ProfileActivity extends AppCompatActivity {

    //Initialize variable
    DrawerLayout drawerLayout;
    Button updateButton;
    EditText nameBox, emailBox, passBox, pass2Box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
        updateButton = findViewById(R.id.buttonUpdateProfile);
        nameBox = findViewById(R.id.editTextUserName);
        emailBox = findViewById(R.id.editTextTextEmailAddress);
        passBox = findViewById(R.id.editTextTextPassword);
        pass2Box = findViewById(R.id.editTextTextPassword2);

        try {
            ProfileModel profile = new GetProfileTask().execute(User.id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateProfile(View view)
    {
        String name = nameBox.getText().toString();
        String email = emailBox.getText().toString();
        String pass = passBox.getText().toString();
        String pass2 = pass2Box.getText().toString();

        if(email.isEmpty() || name.isEmpty() || pass.isEmpty() || pass2.isEmpty())
        {
            Toast.makeText(getBaseContext(), "Preencher todos os campos!", Toast.LENGTH_LONG).show();
            return;
        }

        if(!pass.equals(pass2))
        {
            Toast.makeText(getBaseContext(), "As palavras passes não coincidem!", Toast.LENGTH_LONG).show();
            return;
        }

        EditProfileRequest request = new EditProfileRequest();
        request.name = name;
        request.email = email;
        request.password = pass;

        try{
            EditProfileModel res = new EditProfileTask().execute(request).get();

            if(res != null)
            {
                Toast.makeText(this,"Data changed! ", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getBaseContext(), "Ocorreu um erro ao editar o perfil!", Toast.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class GetProfileTask extends AsyncTask<String, Void, ProfileModel>
    {
        @Override
        protected ProfileModel doInBackground(String... id) {
            UserService userService = new UserService();
            ProfileModel response = userService.getProfile(id[0]);

            if(response == null)
            {
                return null;
            }

            nameBox.setText(response.name);
            emailBox.setText(response.email);

            return response;
        }
    }

    private class EditProfileTask extends AsyncTask<EditProfileRequest, Void, EditProfileModel>
    {
        @Override
        protected EditProfileModel doInBackground(EditProfileRequest... editProfileRequests) {
            UserService userService = new UserService();
            EditProfileModel response = userService.editProfile(editProfileRequests[0]);

            if(response == null)
            {
                return null;
            }

            User.name = response.name;
            User.email = response.email;

            return response;
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

    public void ClickProfile(View view){
        //Recreate activity
        recreate();

    }

    public void ClickLogout(View view){
        //Close app
        MainActivity.Logout(this);

    }

    public void ClickMaps(View view){
        //Recreate activity to favourite books
        redirectActivity(this, EventsActivity.class);
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