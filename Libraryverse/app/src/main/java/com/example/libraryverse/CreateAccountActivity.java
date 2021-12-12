package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libraryverse.APIRequests.DownloadTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.libraryverse.User;

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
        passBox = findViewById(R.id.editTextPassword);
        pass2Box = findViewById(R.id.editTextRepeatPassword);

        createAccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });
    }

    public void clickToHome(View view)
    {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void createAccount()
    {
        String username = usernameBox.getText().toString();
        String email = emailBox.getText().toString();
        String name = nameBox.getText().toString();
        String pass = passBox.getText().toString();
        String pass2 = pass2Box.getText().toString();
        JSONArray array;

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

        try
        {
            DownloadTask task = new DownloadTask();
            String url = "https://libraryverse.herokuapp.com/api/users";
            array = task.execute(url).get();

            if(array == null)
            {
                return;
            }

            JSONObject jsonPart = array.getJSONObject(0);

            User.id = jsonPart.getString("id");
            User.username = jsonPart.getString("username");

            Intent itemView = new Intent(CreateAccountActivity.this, MainActivity.class);
        }
        catch (InterruptedException | JSONException e) {
            e.printStackTrace();
            array = null;
        }
    }

}