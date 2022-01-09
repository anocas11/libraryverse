package com.example.libraryverse.APIRequests;


import com.example.libraryverse.models.BookModel;
import com.example.libraryverse.models.CreateAccountModel;
import com.example.libraryverse.models.CreateAccountRequest;
import com.example.libraryverse.models.EditProfileModel;
import com.example.libraryverse.models.EditProfileRequest;
import com.example.libraryverse.models.LoginModel;
import com.example.libraryverse.models.LoginRequest;
import com.example.libraryverse.models.ProfileModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface UserServiceInterface
{
    @POST("api/users/signup/")
    Call<CreateAccountModel> createAccount(@Body CreateAccountRequest json);

    @POST("api/users/signin/")
    Call<LoginModel> login(@Body LoginRequest json);

    @POST("api/users/{userid}/userdata/")
    Call<EditProfileModel> editProfile(@Path("userid") String userid, @Body EditProfileRequest json);

    @GET("api/users/{userid}/user/")
    Call<ProfileModel> getProfile(@Path("userid") String userid);

}

