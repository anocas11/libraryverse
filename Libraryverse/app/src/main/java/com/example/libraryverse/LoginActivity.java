package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextLoginUsername;
    EditText editTextLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);
        editTextLoginPassword = findViewById(R.id.editTextLoginUsername);
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
}