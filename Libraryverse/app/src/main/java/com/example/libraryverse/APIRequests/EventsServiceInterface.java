package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.EventsResultsModel;
import com.example.libraryverse.models.LocationResultsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsServiceInterface {

    @GET("search.json?engine=google_events&api_key=e746d678e6e66511a31ab37b4073810abea29cba042e1d0237b9e62d368be6de")
    Call<EventsResultsModel> getEvents(@Query("q") String place);

    @GET("search.json?tbm=lcl&api_key=e746d678e6e66511a31ab37b4073810abea29cba042e1d0237b9e62d368be6de")
    Call<LocationResultsModel> getPlaceCoordinates(@Query("q") String place);
}
