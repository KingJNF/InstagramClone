package com.example.android.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created.
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models.
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("3AViqsFY9hnNTCouljf1zr1vc0HY1iskIpJhtGlU")
                .clientKey("KYPXZN2cll4A1w4H5RgDJFYrryeToR5YTeEosOL3")
                .server("https://parseapi.back4app.com")
                .build()
        );


    }
}
