package com.example.smssendingapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SmsSentConfirmationPage extends AppCompatActivity {

    private Button returnToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_sent_confirmation_page);

        returnToHome = findViewById(R.id.returnHome);

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