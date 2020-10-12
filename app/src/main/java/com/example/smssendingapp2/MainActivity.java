package com.example.smssendingapp2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number, message;
    private Button send, testSendRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number =findViewById(R.id.number);
        message = findViewById(R.id.message);
        send =findViewById(R.id.send);
        testSendRequest=findViewById(R.id.testSendRequest);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        sendInvitation();
                        Intent intent = new Intent(MainActivity.this, SmsSentConfirmationPage.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
                }

            }
        });

        testSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewOtherUser.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void sendInvitation(){
        String number2=number.getText().toString().trim();
        String message2=message.getText().toString().trim();


        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number2, null, message2, null, null);
            Toast.makeText(this, "Invitation sent", Toast.LENGTH_SHORT).show();
        } catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error, Message not sent", Toast.LENGTH_SHORT).show();
        }
    }
}