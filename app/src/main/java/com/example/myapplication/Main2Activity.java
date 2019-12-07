package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tvUsername;
    private Button logout;
    private String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViews();
        setListeners();
        uname = UserDataManager.getUserData(this).getUsername();
        tvUsername.setText(uname);
    }

    private void findViews(){
        tvUsername=findViewById(R.id.tv_username);
        logout=findViewById(R.id.logout);
    }

    private void setListeners(){
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDataManager.clearUserData(Main2Activity.this);

                finish();
            }
        });
    }
}
