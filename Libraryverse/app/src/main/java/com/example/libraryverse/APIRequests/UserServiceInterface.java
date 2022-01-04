package com.example.libraryverse.APIRequests;


import com.example.libraryverse.models.CreateAccountModel;
import com.example.libraryverse.models.CreateAccountRequest;
import com.example.libraryverse.models.EditProfileModel;
import com.example.libraryverse.models.EditProfileRequest;
import com.example.libraryverse.models.LoginModel;
import com.example.libraryverse.models.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;



public interface UserServiceInterface
{
    @POST("api/users/signup/")
    Call<CreateAccountModel> createAccount(@Body CreateAccountRequest json);

    @POST("api/users/signin/")
    Call<LoginModel> login(@Body LoginRequest json);

    @POST("api/users/{userid}/signin/")
    Call<EditProfileModel> editProfile(@Body EditProfileRequest json);
}

