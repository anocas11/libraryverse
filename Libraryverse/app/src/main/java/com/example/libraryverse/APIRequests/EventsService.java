package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.EventsModel;
import com.example.libraryverse.models.EventsResultsModel;
import com.example.libraryverse.models.LocationModel;
import com.example.libraryverse.models.LocationResultsModel;

import java.io.IOException;
import java.net.URLEncoder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsService {
    private EventsServiceInterface eventsServiceInterface;

    public EventsService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://serpapi.com/").addConverterFactory(GsonConverterFactory.create()).build();

        eventsServiceInterface = retrofit.create(EventsServiceInterface.class);
    }

    public EventsModel[] getEvents(String location){
        try {
            return eventsServiceInterface.getEvents(location).execute().body().events_results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LocationModel[] getPlace(String location){
        try {
            LocationResultsModel loca = eventsServiceInterface.getPlaceCoordinates(location).execute().body();
            return loca.local_results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
