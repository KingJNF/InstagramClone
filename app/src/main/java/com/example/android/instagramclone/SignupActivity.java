package com.example.android.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";


    private EditText    signupUsername;
    private EditText    composedPassword;
    private EditText    signupEmail;
    private Button      btnSignUp;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        bind();
        createUser();
    }

    private void bind(){
        signupUsername  = findViewById(R.id.signupUsername   );
        composedPassword = findViewById(R.id.composedPassword );
        signupEmail = findViewById(R.id.signupEmail      );
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }

    private void goMainActivity(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    void createUser(){

        String  signupUsernameTxt = signupUsername.getText().toString();
        String  composedPasswordTxt = composedPassword.getText().toString();
        String  signupEmailTxt = signupEmail.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(signupUsernameTxt);
        user.setPassword(composedPasswordTxt);
        user.setEmail(signupEmailTxt);


        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    goMainActivity();
                }
                else {
                    Log.e(TAG, "Issue with SignUp");
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        if(item.getItemId() == R.id.btnLogout){
            ParseUser.logOut();
            ParseUser.getCurrentUser();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}