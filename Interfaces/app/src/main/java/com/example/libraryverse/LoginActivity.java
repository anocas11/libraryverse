package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextLoginUsername);
        password = findViewById(R.id.editTextLoginPassword);

    }

    public void ClickFunction(View view)
    {
        String msg = "USERNAME ->" + username.getText().toString() + "PASSWORD ->" + password.getText().toString();
        Log.i("Welcome", msg);
        Toast.makeText(this, "Username" + username + "Password" + password, Toast.LENGTH_SHORT).show();
    }
}