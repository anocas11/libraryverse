package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libraryverse.APIRequests.DownloadTask;
import com.example.libraryverse.APIRequests.UtilityService;
import com.example.libraryverse.models.BookModel;
import com.example.libraryverse.models.LoginModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ItemActivity extends AppCompatActivity {

    TextView itemName;
    TextView itemDescription;
    ImageView itemPoster, itemFavorite;
    LinearLayout ll;
    JSONArray itemArray = null;
    String itemId, itemType;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        itemName = findViewById(R.id.textViewItemName);
        itemDescription = findViewById(R.id.textViewItemDescription);
        itemPoster = findViewById(R.id.imageViewItemImg);
        ll = findViewById(R.id.linearLayoutIteminfo);
        itemFavorite = findViewById(R.id.imageViewFavoriteItem);

        itemId = getIntent().getStringExtra("id");
        itemType = getIntent().getStringExtra("type");

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
                itemArray = task.execute("https://libraryverse.herokuapp.com/api/actors/" + itemId).get();
            }

            itemFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddFavoriteClick();
                }
            });

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

                        TextView durationText = new TextView((getBaseContext()));
                        durationText.setText("Duration: " + jsonPart.getString("duration"));
                        durationText.setTextColor(Color.parseColor("#FFFFFF"));
                        durationText.setTextSize(16);
                        durationText.setLayoutParams(params);
                        ll.addView(durationText);

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
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(20, 20, 0, 0);

                        TextView booksLabel = new TextView(getBaseContext());
                        booksLabel.setText("Books");
                        booksLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        booksLabel.setTextSize(20);
                        //moviesLabel.setTextAppearance(null, Typeface.BOLD);
                        booksLabel.setLayoutParams(params);
                        ll.addView(booksLabel);

                        DownloadTask task1 = new DownloadTask();
                        JSONArray booksArray = task1.execute("https://libraryverse.herokuapp.com/api/authors/author/" + itemId + "/books").get();

                        for (int i = 0; i < booksArray.length(); i++)
                        {
                            JSONObject jsonPartBooks = booksArray.getJSONObject(i);
                            TextView bookName = new TextView(getBaseContext());
                            bookName.setText(jsonPartBooks.getString("bookName"));
                            bookName.setTextColor(Color.parseColor("#FFFFFF"));
                            bookName.setTextSize(16);
                            bookName.setLayoutParams(params);
                            ll.addView(bookName);
                        }
                    }
                    else if(itemType.equals("actor"))
                    {
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(20, 20, 0, 0);

                        TextView moviesLabel = new TextView(getBaseContext());
                        moviesLabel.setText("Movies");
                        moviesLabel.setTextColor(Color.parseColor("#FFFFFF"));
                        moviesLabel.setTextSize(20);
                        //moviesLabel.setTextAppearance(null, Typeface.BOLD);
                        moviesLabel.setLayoutParams(params);
                        ll.addView(moviesLabel);

                        DownloadTask task1 = new DownloadTask();
                        JSONArray moviesArray = task1.execute("https://libraryverse.herokuapp.com/api/actors/actor/" + itemId + "/movies").get();

                        for (int i = 0; i < moviesArray.length(); i++)
                        {
                            JSONObject jsonPartMovies = moviesArray.getJSONObject(i);
                            TextView movieName = new TextView(getBaseContext());
                            movieName.setText(jsonPartMovies.getString("movieName"));
                            movieName.setTextColor(Color.parseColor("#FFFFFF"));
                            movieName.setTextSize(16);
                            movieName.setLayoutParams(params);
                            ll.addView(movieName);
                        }
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

    public void AddFavoriteClick()
    {
        if(itemType.equals("book"))
        {
            try {
                BookModel bt = new BookTask().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class BookTask extends AsyncTask<Void, Void, BookModel>
    {
        @Override
        protected BookModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            BookModel response = utilityService.setBookFavorite(User.id, itemId);

            if(response == null)
            {
                return null;
            }

            if(response.favorite){
                itemFavorite.setImageDrawable(getBaseContext().getDrawable(R.drawable.ic_baseline_star));
            }
            else
            {
                itemFavorite.setImageDrawable(getBaseContext().getDrawable(R.drawable.ic_baseline_star_outline));
            }

            return response;

        }
    }
}