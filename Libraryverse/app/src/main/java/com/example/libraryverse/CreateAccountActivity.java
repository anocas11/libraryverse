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
import com.example.libraryverse.models.CreateAccountModel;
import com.example.libraryverse.models.CreateAccountRequest;

import java.util.concurrent.ExecutionException;

public class CreateAccountActivity extends AppCompatActivity {

    Button createAccountButton;
    EditText usernameBox;
    EditText emailBox;
    EditText nameBox;
    EditText passBox;
    EditText pass2Box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        createAccountButton = findViewById(R.id.buttonCreateAccount);
        usernameBox = findViewById(R.id.editTextUsername);
        emailBox = findViewById(R.id.editTextEmail);
        nameBox = findViewById(R.id.editTextName);
        passBox = findViewById(R.id.editTextLoginPassword);
        pass2Box = findViewById(R.id.editTextRepeatPassword);
    }

    public void createAccount(View view)
    {
        String username = usernameBox.getText().toString();
        String email = emailBox.getText().toString();
        String name = nameBox.getText().toString();
        String pass = passBox.getText().toString();
        String pass2 = pass2Box.getText().toString();

        if(username.isEmpty() || email.isEmpty() || name.isEmpty() || pass.isEmpty() || pass2.isEmpty())
        {
            Toast.makeText(getBaseContext(), "Preencher todos os campos!", Toast.LENGTH_LONG).show();
            return;
        }

        if(!pass.equals(pass2))
        {
            Toast.makeText(getBaseContext(), "As palavras passes não coincidem!", Toast.LENGTH_LONG).show();
            return;
        }

        CreateAccountRequest request = new CreateAccountRequest();
        request.username = username;
        request.email = email;
        request.name = name;
        request.password = pass;

        try {
            CreateAccountModel res = new CreateAccountTask().execute(request).get();

            if(res != null)
            {
                Toast.makeText(this,"Welcome " + username, Toast.LENGTH_LONG).show();

                Intent homeView = new Intent(CreateAccountActivity.this, MainActivity.class);
                startActivity(homeView);
            }
            else
            {
                Toast.makeText(getBaseContext(), "Ocorreu um erro a registar o utilizador!", Toast.LENGTH_LONG).show();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private class CreateAccountTask extends AsyncTask<CreateAccountRequest, Void, CreateAccountModel>{

        @Override
        protected CreateAccountModel doInBackground(CreateAccountRequest... createAccountRequests) {
            UserService userService = new UserService();
            CreateAccountModel response = userService.createAccount(createAccountRequests[0]);

            if(response == null)
            {
                return null;
            }

            User.id =response.id;
            User.username =response.username;
            User.email =response.email;

            return response;
        }
    }

}