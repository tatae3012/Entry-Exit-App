package com.example.vanshika.innovaccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;

public class First extends AppCompatActivity {

    private Button visitor, host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_act);

        Log.d("FistActivity", "yes");

        visitor = (Button) findViewById(R.id.v);
        host = (Button) findViewById(R.id.h);

        visitor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent(First.this, Visitor.class);
                        startActivity(intent1);
                }
            } );

        host.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(First.this, Host.class);
                        startActivity(intent2);
                    }
                } );
    }
}