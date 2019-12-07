package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private Button btnlogin;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPreference();
        if(checkLoginStatus()){
            Intent intent=new Intent(this,Main2Activity.class);
            startActivity(intent);
        }
        findViews();
        setListeners();

    }

    private void findViews(){
        username = findViewById(R.id.username);
        btnlogin = findViewById(R.id.btnlogin);

    }
    private void setListeners(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();

                if(uname.isEmpty()){
                    username.setError("Username cannot be empty.");
                }
                else{
                    UserData userData=new UserData();
                    userData.setLogin(true);
                    userData.setUsername(uname);

                    Log.d("MainActivity Username",userData.getUsername());

                    UserDataManager.saveUserData(MainActivity.this,userData);

                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("USERNAME",uname);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private void initPreference(){
        preferences = getSharedPreferences("USER_DATA",MODE_PRIVATE);
    }

    private boolean checkLoginStatus(){
        UserData userData=UserDataManager.getUserData(this);
        return userData.isLogin();
    }
}
