package com.example.libraryverse;

import androidx.fragment.app.FragmentActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.libraryverse.APIRequests.EventsService;
import com.example.libraryverse.models.EventsModel;
import com.example.libraryverse.models.LocationModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.libraryverse.databinding.ActivityMapsBinding;

import java.util.concurrent.ExecutionException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    public String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        local = getIntent().getStringExtra("local");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        try {
            LocationModel[] locationResults = new PlaceTask().execute(local).get();
            LatLng place = new LatLng(locationResults[0].gps_coordinates.latitude, locationResults[0].gps_coordinates.longitude);
            mMap.addMarker(new MarkerOptions().position(place).title("Evento"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class PlaceTask extends AsyncTask<String, Void, LocationModel[]>
    {

        @Override
        protected LocationModel[] doInBackground(String... strings)
        {
            EventsService eventsService = new EventsService();
            LocationModel[] response = eventsService.getPlace(strings[0]);

            if(response == null)
            {
                return null;
            }

            return response;
        }
    }
}