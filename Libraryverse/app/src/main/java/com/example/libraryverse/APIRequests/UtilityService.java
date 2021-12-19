package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.BookModel;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UtilityService {

    private UtilityServiceInterface utilityServiceInterface;

    public UtilityService()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://libraryverse.herokuapp.com/").addConverterFactory(GsonConverterFactory.create()).build();

        utilityServiceInterface = retrofit.create(UtilityServiceInterface.class);
    }

    public BookModel setBookFavorite(String userId, String bookId)
    {
        try{
            return utilityServiceInterface.setBookFavorite(bookId, userId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
