package com.example.libraryverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.libraryverse.APIRequests.DownloadTask;
import com.example.libraryverse.APIRequests.UtilityService;
import com.example.libraryverse.models.BookModel;
import com.example.libraryverse.models.MovieModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ItemActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView itemName;
    TextView itemDescription;
    ImageView itemPoster, itemFavorite, itemOwned, itemWatched, itemRead, itemReading;
    LinearLayout ll, llbar;
    JSONArray itemArray = null;
    String itemId, itemType;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        drawerLayout = findViewById(R.id.drawer_layout);
        itemName = findViewById(R.id.textViewItemName);
        itemDescription = findViewById(R.id.textViewItemDescription);
        itemPoster = findViewById(R.id.imageViewItemImg);
        ll = findViewById(R.id.linearLayoutIteminfo);
        llbar = findViewById(R.id.llbar);
        itemFavorite = findViewById(R.id.imageViewFavoriteItem);
        itemOwned = findViewById(R.id.imageViewAddItem);
        itemWatched = findViewById(R.id.imageViewWatched);
        itemRead = findViewById(R.id.imageViewRead);
        itemReading = findViewById(R.id.imageViewReading);

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

                try {
                    BookModel bst = new BookStatusTask().execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if(itemType.equals("author"))
            {
                itemArray = task.execute("https://libraryverse.herokuapp.com/api/authors/" + itemId).get();
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

            itemOwned.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddOwnedClick();
                }
            });

            itemRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddReadClick();;
                }
            });

            itemReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddReadingClick();
                }
            });

            itemWatched.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AddWatchedClick();
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
                        itemOwned.setVisibility(View.VISIBLE);
                        itemWatched.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(20, 20, 0, 0);

                        TextView cuText = new TextView((getBaseContext()));
                        cuText.setText("Cinematic Universe: " + jsonPart.getString("cinematicUniverse"));
                        cuText.setTextColor(Color.parseColor("#FFFFFF"));
                        cuText.setTextSize(16);
                        cuText.setLayoutParams(params);
                        ll.addView(cuText);

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
                        itemOwned.setVisibility(View.VISIBLE);
                        itemRead.setVisibility(View.VISIBLE);
                        itemReading.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(20, 20, 0, 0);

                        TextView cuText = new TextView((getBaseContext()));
                        cuText.setText("Cinematic Universe: " + jsonPart.getString("cinematicUniverse"));
                        cuText.setTextColor(Color.parseColor("#FFFFFF"));
                        cuText.setTextSize(16);
                        cuText.setLayoutParams(params);
                        ll.addView(cuText);

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
                BookModel fbt = new favoriteBookTask().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(itemType.equals("movie"))
        {
            try {
                MovieModel fmt = new favoriteMovieTask().execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddOwnedClick()
    {
        if(itemType.equals("book"))
        {
            try {
                BookModel fbt = new OwnedBookTask().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(itemType.equals("movie"))
        {
            try {
                MovieModel fmt = new ownedMovieTask().execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddReadClick()
    {
        if(itemType.equals("book"))
        {
            try {
                BookModel fbt = new ReadBookTask().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddReadingClick()
    {
        if(itemType.equals("book"))
        {
            try {
                BookModel fbt = new ReadingBookTask().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddWatchedClick()
    {
        if(itemType.equals("movie"))
        {
            try {
                MovieModel fbt = new watchedMovieTask().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class BookStatusTask extends AsyncTask<Void, Void, BookModel>
    {
        @Override
        protected BookModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            BookModel response = utilityService.getBookStatus(User.id, itemId);

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


            if(response.read){
                itemRead.setImageDrawable(getBaseContext().getDrawable(R.drawable.bookmark_solid));
            }
            else
            {
                itemRead.setImageDrawable(getBaseContext().getDrawable(R.drawable.bookmark_regular));
            }

            if(response.reading){
                itemReading.setImageDrawable(getBaseContext().getDrawable(R.drawable.book_open_solid));
            }
            else
            {
                itemReading.setImageDrawable(getBaseContext().getDrawable(R.drawable.book_solid));
            }

            if(response.has){
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_solid));
            }
            else
            {
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_regular));
            }

            return response;

        }
    }

    private class favoriteBookTask extends AsyncTask<Void, Void, BookModel>
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

    private class ReadBookTask extends AsyncTask<Void, Void, BookModel>
    {
        @Override
        protected BookModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            BookModel response = utilityService.setBookRead(User.id, itemId);

            if(response == null)
            {
                return null;
            }

            if(response.read){
                itemRead.setImageDrawable(getBaseContext().getDrawable(R.drawable.bookmark_solid));
            }
            else
            {
                itemRead.setImageDrawable(getBaseContext().getDrawable(R.drawable.bookmark_regular));
            }

            return response;

        }
    }

    private class ReadingBookTask extends AsyncTask<Void, Void, BookModel>
    {
        @Override
        protected BookModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            BookModel response = utilityService.setBookReading(User.id, itemId);

            if(response == null)
            {
                return null;
            }

            if(response.reading){
                runOnUiThread(() -> {
                    itemReading.setImageDrawable(getBaseContext().getDrawable(R.drawable.book_open_solid));
                });
            }
            else
            {
                runOnUiThread(() -> {
                    itemReading.setImageDrawable(getBaseContext().getDrawable(R.drawable.book_solid));
                });
            }

            return response;

        }
    }

    private class OwnedBookTask extends AsyncTask<Void, Void, BookModel>
    {
        @Override
        protected BookModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            BookModel response = utilityService.setBookOwned(User.id, itemId);

            if(response == null)
            {
                return null;
            }

            if(response.has){
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_regular));
            }
            else
            {
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_solid));
            }

            return response;
        }
    }

    private class MovieStatusTask extends AsyncTask<Void, Void, MovieModel>
    {
        @Override
        protected MovieModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            MovieModel response = utilityService.getMovieStatus(User.id, itemId);

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

            if(response.watched){
                itemWatched.setImageDrawable(getBaseContext().getDrawable(R.drawable.eye_solid));
            }
            else
            {
                itemWatched.setImageDrawable(getBaseContext().getDrawable(R.drawable.eye_regular));
            }

            if(response.has){
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_regular));
            }
            else
            {
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_solid));
            }
            return response;

        }
    }

    private class favoriteMovieTask extends AsyncTask<Void, Void, MovieModel>
    {
        @Override
        protected MovieModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            MovieModel response = utilityService.setMovieFavorite(User.id, itemId);

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

    private class watchedMovieTask extends AsyncTask<Void, Void, MovieModel>
    {
        @Override
        protected MovieModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            MovieModel response = utilityService.setMovieWatched(User.id, itemId);

            if(response == null)
            {
                return null;
            }

            if(response.watched){
                itemWatched.setImageDrawable(getBaseContext().getDrawable(R.drawable.eye_regular));
            }
            else
            {
                itemWatched.setImageDrawable(getBaseContext().getDrawable(R.drawable.eye_solid));
            }

            return response;

        }
    }

    private class ownedMovieTask extends AsyncTask<Void, Void, MovieModel>
    {
        @Override
        protected MovieModel doInBackground(Void... voids)
        {
            UtilityService utilityService = new UtilityService();
            MovieModel response = utilityService.setMovieOwned(User.id, itemId);

            if(response == null)
            {
                return null;
            }

            if(response.has){
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_solid));
            }
            else
            {
                itemOwned.setImageDrawable(getBaseContext().getDrawable(R.drawable.check_circle_regular));
            }

            return response;

        }
    }

    public void ClickSearch(View view){
        Intent i = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(i);
    }


    public void ClickMenu(View view){
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close drawer layout
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close drawer layout
        //Check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Recreate activty
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

    public void ClickFavMovies(View view){
        //Recreate activity
        redirectActivity(this, FavoriteMoviesActivity.class);
    }

    public void ClickFavBooks(View view){
        //Recreate activity to favourite books
        redirectActivity(this, FavoriteBooksActivity.class);
    }

    public void ClickProfile(View view){
        //Redirect activity to profile
        redirectActivity(this, ProfileActivity.class);
    }

    public void ClickMaps(View view){
        //Recreate activity to favourite books
        redirectActivity(this, EventsActivity.class);
    }

    public void ClickLogout(View view){
        //Close app
        Logout(this);
    }

    public static void Logout(Activity activity) {
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout?");
        //Positive yes button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);

            }
        });

        //Negative no button
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();
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
        closeDrawer(drawerLayout);
    }
}