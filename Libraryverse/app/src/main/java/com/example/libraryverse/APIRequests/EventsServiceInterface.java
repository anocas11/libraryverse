package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.EventDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsServiceInterface {
    @GET("search.json")
    Call<EventDataModel[]> getEvents(@Query("type") String type, @Query("filter") String filter);
    //type -> venue
    //filter -> id do local
}
