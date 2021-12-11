package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    LinearLayout ll;
    JSONArray itemArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        itemName = findViewById(R.id.textViewItemName);
        itemDescription = findViewById(R.id.textViewItemDescription);
        itemPoster = findViewById(R.id.imageViewItemImg);
        ll = findViewById(R.id.linearLayoutIteminfo);

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
            else if(itemType.equals("actor"))
            {
                itemArray = task.execute("https://libraryverse.herokuapp.com/api/actors/actor/" + itemId).get();
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
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(20, 20, 0, 0);

                        TextView genresLabel = new TextView(getBaseContext());
                        genresLabel.setText("Genres");
                        genresLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        genresLabel.setTextSize(20);
                        //genresLabel.setTextAppearance(null, Typeface.BOLD);
                        genresLabel.setLayoutParams(params);
                        ll.addView(genresLabel);

                        DownloadTask task2 = new DownloadTask();
                        JSONArray GenresArray = task2.execute("https://libraryverse.herokuapp.com/api/movies/movie/" + itemId).get();

                        for (int i = 0; i < GenresArray.length(); i++)
                        {
                            JSONObject jsonPartCharacters = GenresArray.getJSONObject(i);
                            TextView genreName = new TextView(getBaseContext());
                            genreName.setText(jsonPartCharacters.getString("genre"));
                            genreName.setTextColor(Color.parseColor("#FFFFFF"));
                            genreName.setTextSize(16);
                            genreName.setLayoutParams(params);
                            ll.addView(genreName);
                        }

                        TextView charactersLabel = new TextView(getBaseContext());
                        charactersLabel.setText("Characters");
                        charactersLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        charactersLabel.setTextSize(20);
                        //charactersLabel.setTextAppearance(null, Typeface.BOLD);
                        charactersLabel.setLayoutParams(params);
                        ll.addView(charactersLabel);

                        DownloadTask task3 = new DownloadTask();
                        JSONArray charactersArray = task3.execute("https://libraryverse.herokuapp.com/api/movies/movie/" + itemId + "/characters").get();

                        for (int i = 0; i < charactersArray.length(); i++)
                        {
                            JSONObject jsonPartCharacters = charactersArray.getJSONObject(i);
                            TextView characterName = new TextView(getBaseContext());
                            characterName.setText(jsonPartCharacters.getString("characterName"));
                            characterName.setTextColor(Color.parseColor("#FFFFFF"));
                            characterName.setTextSize(16);
                            characterName.setLayoutParams(params);
                            ll.addView(characterName);
                        }

                        TextView actorsLabel = new TextView(getBaseContext());
                        actorsLabel.setText("Actors");
                        actorsLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        actorsLabel.setTextSize(20);
                        //actorsLabel.setTextAppearance(null, Typeface.BOLD);
                        actorsLabel.setLayoutParams(params);
                        ll.addView(actorsLabel);

                        DownloadTask task4 = new DownloadTask();
                        JSONArray actorsArray = task4.execute("https://libraryverse.herokuapp.com/api/movies/movie/" + itemId + "/actors").get();

                        for (int i = 0; i < actorsArray.length(); i++)
                        {
                            JSONObject jsonPartActors = actorsArray.getJSONObject(i);
                            TextView actorName = new TextView(getBaseContext());
                            actorName.setText(jsonPartActors.getString("actorName"));
                            actorName.setTextColor(Color.parseColor("#FFFFFF"));
                            actorName.setTextSize(16);
                            actorName.setLayoutParams(params);
                            ll.addView(actorName);
                        }
                    }
                    else if(itemType.equals("book"))
                    {
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(20, 20, 0, 0);

                        TextView genresLabel = new TextView(getBaseContext());
                        genresLabel.setText("Genres");
                        genresLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        genresLabel.setTextSize(20);
                        //genresLabel.setTextAppearance(null, Typeface.BOLD);
                        genresLabel.setLayoutParams(params);
                        ll.addView(genresLabel);

                        DownloadTask task2 = new DownloadTask();
                        JSONArray GenresArray = task2.execute("https://libraryverse.herokuapp.com/api/books/book/" + itemId).get();

                        for (int i = 0; i < GenresArray.length(); i++)
                        {
                            JSONObject jsonPartCharacters = GenresArray.getJSONObject(i);
                            TextView genreName = new TextView(getBaseContext());
                            genreName.setText(jsonPartCharacters.getString("genre"));
                            genreName.setTextColor(Color.parseColor("#FFFFFF"));
                            genreName.setTextSize(16);
                            genreName.setLayoutParams(params);
                            ll.addView(genreName);
                        }

                        TextView authorsLabel = new TextView(getBaseContext());
                        authorsLabel.setText("Author(s)");
                        authorsLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        authorsLabel.setTextSize(20);
                        //actorsLabel.setTextAppearance(null, Typeface.BOLD);
                        authorsLabel.setLayoutParams(params);
                        ll.addView(authorsLabel);

                        DownloadTask task3 = new DownloadTask();
                        JSONArray authorsArray = task3.execute("https://libraryverse.herokuapp.com/api/books/book/" + itemId + "/authors").get();

                        for (int i = 0; i < authorsArray.length(); i++)
                        {
                            JSONObject jsonPartActors = authorsArray.getJSONObject(i);
                            TextView authorName = new TextView(getBaseContext());
                            authorName.setText(jsonPartActors.getString("authorName"));
                            authorName.setTextColor(Color.parseColor("#FFFFFF"));
                            authorName.setTextSize(16);
                            authorName.setLayoutParams(params);
                            ll.addView(authorName);
                        }

                        TextView charactersLabel = new TextView(getBaseContext());
                        charactersLabel.setText("Characters");
                        charactersLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        charactersLabel.setTextSize(20);
                        //charactersLabel.setTextAppearance(null, Typeface.BOLD);
                        charactersLabel.setLayoutParams(params);
                        ll.addView(charactersLabel);

                        DownloadTask task4 = new DownloadTask();
                        JSONArray charactersArray = task4.execute("https://libraryverse.herokuapp.com/api/books/book/" + itemId + "/characters").get();

                        for (int i = 0; i < charactersArray.length(); i++)
                        {
                            JSONObject jsonPartCharacters = charactersArray.getJSONObject(i);
                            TextView characterName = new TextView(getBaseContext());
                            characterName.setText(jsonPartCharacters.getString("characterName"));
                            characterName.setTextColor(Color.parseColor("#FFFFFF"));
                            characterName.setTextSize(16);
                            characterName.setLayoutParams(params);
                            ll.addView(characterName);
                        }
                    }
                    else if(itemType.equals("author"))
                    {

                    }
                    else if(itemType.equals("actor"))
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