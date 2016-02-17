package com.example.eslam.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class appStart extends AppCompatActivity {
    Button start ;

    public void startApp(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);
        start = (Button)findViewById(R.id.startBTM);
    }
}
