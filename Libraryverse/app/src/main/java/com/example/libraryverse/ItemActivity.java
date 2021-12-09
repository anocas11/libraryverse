package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libraryverse.APIRequests.DownloadTask;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ItemActivity extends AppCompatActivity {

    TextView itemName;
    TextView itemDescription;
    ImageView itemPoster;
    JSONArray itemArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        itemName = findViewById(R.id.textViewItemName);
        itemDescription = findViewById(R.id.textViewItemDescription);
        itemPoster = findViewById(R.id.imageViewItemImg);

        String itemId = getIntent().getStringExtra("id");
        String itemType = getIntent().getStringExtra("type");

        DownloadTask task = new DownloadTask();



        try
        {
            if(itemType.equals("movie"))
            {
                itemArray = task.execute("https://libraryverse.herokuapp.com/api/movies/movie/" + itemId).get();
            }
            else if(itemType.equals("book"))
            {
                itemArray = task.execute("https://libraryverse.herokuapp.com/api/books/book/" + itemId).get();
            }
            else if(itemType.equals("author"))
            {
                itemArray = task.execute("https://libraryverse.herokuapp.com/api/authors/author/" + itemId).get();
            }

            if(itemArray != null)
            {
                try
                {
                    JSONObject jsonPart = itemArray.getJSONObject(0);
                    itemName.setText(jsonPart.getString("name"));
                    itemDescription.setText(jsonPart.getString("description"));
                    Picasso.get().load(jsonPart.getString("poster")).into(itemPoster);

                    if(itemType.equals("movie"))
                    {

                    }
                    else if(itemType.equals("book"))
                    {

                    }
                    else if(itemType.equals("author"))
                    {
                        
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
            itemArray = null;
        }
    }
}