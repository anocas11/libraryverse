package com.example.libraryverse.APIRequests;

import com.example.libraryverse.models.CreateAccountModel;
import com.example.libraryverse.models.CreateAccountRequest;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {

    private UserServiceInterface userServiceInterface;

    public UserService(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://libraryverse.herokuapp.com/api/users/").addConverterFactory(GsonConverterFactory.create()).build();

        userServiceInterface = retrofit.create(UserServiceInterface.class);
    }

    public CreateAccountModel createAccount(CreateAccountRequest body){
        try {
            return userServiceInterface.createAccount(body).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
