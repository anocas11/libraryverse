package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.EventsModel;
import com.example.libraryverse.models.EventsResultsModel;

import java.io.IOException;

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
}
