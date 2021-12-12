package com.example.libraryverse.APIRequests;


import com.example.libraryverse.models.CreateAccountModel;
import com.example.libraryverse.models.CreateAccountRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;



public interface UserServiceInterface
{
    @POST("/")
    Call<CreateAccountModel> createAccount(@Body CreateAccountRequest json);
}
