package com.example.libraryverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libraryverse.APIRequests.EventsService;
import com.example.libraryverse.models.EventsModel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class EventsActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    LocationManager locationManager;
    LocationListener locationListener;
    LinearLayout llPrincipal;

    TextView textView;
    boolean isLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        textView = findViewById(R.id.textViewLocation);
        drawerLayout = findViewById(R.id.drawer_layout);
        llPrincipal = findViewById(R.id.linearLayoutPrincipal);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                textView.setText(location.toString());
                Log.i("Location", location.toString());

                Geocoder geo = new Geocoder(getBaseContext(), Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = geo.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addresses.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Waiting for Location", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //yourtextboxname.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                    //Toast.makeText(getBaseContext(), addresses.get(0).getLocality(), Toast.LENGTH_LONG).show();
                    if(!isLoaded){
                        isLoaded = true;
                        try {
                            EventsModel[] events = new EventsTask().execute(addresses.get(0).getLocality()).get();

                            if(events != null){
                                for(int i = 0; i < events.length; i++)
                                {
                                    LinearLayout linearLayout = new LinearLayout(getBaseContext());
                                    linearLayout.setOrientation(LinearLayout.VERTICAL);

                                    LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                    titleParams.setMargins(30, 10, 20, 15);
                                    TextView title = new TextView(getBaseContext());
                                    title.setText(events[i].title);
                                    title.setTextColor(Color.parseColor("#FFFFFF"));
                                    title.setTextSize(16);
                                    title.setLayoutParams(titleParams);
                                    linearLayout.addView(title);

                                    LinearLayout.LayoutParams addressParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                    addressParams.setMargins(30, 10, 20, 15);
                                    TextView address = new TextView(getBaseContext());
                                    address.setText(events[i].address[0]);
                                    address.setTextColor(Color.parseColor("#FFFFFF"));
                                    address.setLayoutParams(addressParams);
                                    linearLayout.addView(address);

                                    LinearLayout.LayoutParams whenParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                    whenParams.setMargins(30, 10, 20, 15);
                                    TextView when = new TextView(getBaseContext());
                                    when.setText(events[i].date.when);
                                    when.setTextColor(Color.parseColor("#FFFFFF"));
                                    when.setLayoutParams(whenParams);
                                    linearLayout.addView(when);

                                    int finalI = i;
                                    linearLayout.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(EventsActivity.this, MapsActivity.class);

                                            try {
                                                intent.putExtra("local", events[finalI].address[0]);
                                                startActivity(intent);
                                            }
                                            catch (Exception e)
                                            {

                                            }
                                        }
                                    });

                                    llPrincipal.addView(linearLayout);
                                }
                            }
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        else
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        0,
                        0,
                        locationListener
                );
            }
        }
    }

    private class EventsTask extends AsyncTask<String, Void, EventsModel[]>
    {

        @Override
        protected EventsModel[] doInBackground(String... strings)
        {
            EventsService eventsService = new EventsService();
            EventsModel[] response = eventsService.getEvents("Eventos+em+"+strings[0]);

            if(response == null)
            {
                return null;
            }

            return response;
        }
    }

    public void ClickSearch(View view){
        Intent i = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(i);
    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //Closed drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickProfile(View view){
        //Redirect Activity to profile
        redirectActivity(this, ProfileActivity.class);
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

    public void ClickLogout(View view){
        //Close app
        MainActivity.Logout(this);

    }

    public void ClickMaps(View view){
        //Recreate activity to favourite books
        redirectActivity(this, EventsActivity.class);
    }

    public static void redirectActivity(Activity activity, Class aclass) {
        //initialize intent
        Intent intent = new Intent(activity, aclass);
        //Set Flg
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    public static int convertDpToPixel(int dp, Context context){
        return dp * ((int) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    @Override
    protected void onPause(){
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}

