package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.BookModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UtilityServiceInterface {
    @POST("api/book/books/{bookid}/{userid}/favorite")
    Call<BookModel> setBookFavorite(@Path("bookid") String bookId, @Path("userid") String userid);
}
