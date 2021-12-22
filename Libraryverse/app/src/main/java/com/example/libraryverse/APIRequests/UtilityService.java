package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.BookModel;
import com.example.libraryverse.models.MovieModel;

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

    public BookModel getBookStatus(String userId, String bookId)
    {
        try{
            return utilityServiceInterface.getBookStatus(bookId, userId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MovieModel setMovieFavorite(String userId, String movieId)
    {
        try{
            return utilityServiceInterface.setMovieFavorite(movieId, userId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MovieModel getMovieStatus(String userId, String movieId)
    {
        try{
            return utilityServiceInterface.getMovieStatus(movieId, userId).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
