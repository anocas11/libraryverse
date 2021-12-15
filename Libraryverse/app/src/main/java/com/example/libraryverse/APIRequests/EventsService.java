package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.CreateAccountModel;
import com.example.libraryverse.models.CreateAccountRequest;
import com.example.libraryverse.models.EventDataModel;
import com.example.libraryverse.models.LoginModel;
import com.example.libraryverse.models.LoginRequest;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsService {
    private EventsServiceInterface eventsServiceInterface;

    public EventsService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://bilheteira.fnac.pt/").addConverterFactory(GsonConverterFactory.create()).build();

        eventsServiceInterface = retrofit.create(EventsServiceInterface.class);
    }

    public EventDataModel[] getEvents(String locationId){
        try {
            return eventsServiceInterface.getEvents("venue", locationId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
