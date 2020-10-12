package com.example.smssendingapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class UserProfilePage extends AppCompatActivity {

    private Button sendSupRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_page);


        sendSupRequest = findViewById(R.id.sendSupRequest);

        /*returnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmsSentConfirmationPage.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}