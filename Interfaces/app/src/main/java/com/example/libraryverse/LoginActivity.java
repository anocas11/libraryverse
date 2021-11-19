package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextLoginUsername);
        password = findViewById(R.id.editTextLoginPassword);
        loginButton = findViewById(R.id.buttonLogin);
    }

    public void ClickFunction(View view)
    {
        String msg = "USERNAME ->" + username.getText().toString() + "PASSWORD ->" + password.getText().toString();
        Log.i("Welcome", msg);
        Toast.makeText(this, "Username" + username + "Password" + password, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}