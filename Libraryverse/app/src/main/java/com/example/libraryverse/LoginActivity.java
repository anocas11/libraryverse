package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libraryverse.APIRequests.UserService;
import com.example.libraryverse.models.LoginModel;
import com.example.libraryverse.models.LoginRequest;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    EditText editTextLoginUsername;
    EditText editTextLoginPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);
        editTextLoginPassword = findViewById(R.id.editTextLoginUsername);
        loginButton = findViewById(R.id.buttonLogin);
    }


    public void clickToHome(View view)
    {
        //#3 - Retirar Texto inserido
        String name = editTextLoginUsername.getText().toString();
        String password = editTextLoginPassword.getText().toString();


        //#4 - Escrever para os logs
        Log.i("Value", "Username " + name + " Password " + password);

        //#4- Escrever para um popup
        Toast.makeText(this,"Olá " + name, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);

    }

    public void ClickToCreate(View view)
    {
        Intent i = new Intent(getApplicationContext(), CreateAccountActivity.class);
        startActivity(i);
    }

    public void login(View view)
    {
        String username = editTextLoginUsername.getText().toString();
        String pass = editTextLoginPassword.getText().toString();

        if(username.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(getBaseContext(), "Preencher todos os campos!", Toast.LENGTH_LONG).show();
            return;
        }

        LoginRequest request = new LoginRequest();

        request.username = username;
        request.password = pass;

        try
        {
            LoginModel res = new LoginTask().execute(request).get();

            if(res != null)
            {
                Intent homeView = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(homeView);
            }
            else
            {
                Toast.makeText(getBaseContext(), "Ocorreu um erro ao fazer login!", Toast.LENGTH_LONG).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class LoginTask extends AsyncTask<LoginRequest, Void, LoginModel>
    {

        @Override
        protected LoginModel doInBackground(LoginRequest... loginRequests)
        {
            UserService userService = new UserService();
            LoginModel response = userService.login(loginRequests[0]);

            if(response == null)
            {
                return null;
            }

            User.id = response.id;
            User.username = response.username;
            User.email = response.email;

            return response;
        }
    }
}