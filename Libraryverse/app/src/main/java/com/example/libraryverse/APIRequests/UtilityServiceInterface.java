package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.BookModel;
import com.example.libraryverse.models.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UtilityServiceInterface {
    @POST("api/books/book/{bookid}/{userid}/favorite")
    Call<BookModel> setBookFavorite(@Path("bookid") String bookId, @Path("userid") String userid);

    @GET("api/books/book/{bookid}/{userid}/status")
    Call<BookModel> getBookStatus(@Path("bookid") String bookId, @Path("userid") String userid);

    @POST("api/movies/movie/{movieid}/{userid}/favorite")
    Call<MovieModel> setMovieFavorite(@Path("movieid") String movieId, @Path("userid") String userid);

    @GET("api/movies/movie/{movieid}/{userid}/status")
    Call<MovieModel> getMovieStatus(@Path("movieid") String movieId, @Path("userid") String userid);
}
