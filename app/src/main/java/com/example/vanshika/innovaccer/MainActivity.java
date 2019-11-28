package com.example.vanshika.innovaccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView aa1, aa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "yes");

        aa1 = (TextView) findViewById(R.id.a1);
        aa2 = (TextView) findViewById(R.id.a2);

        Intent intent = new Intent(MainActivity.this, First.class);
        new Timer().schedule(new TimerTask() {
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        startActivity(new Intent(MainActivity.this, First.class));
                        overridePendingTransition(0, 0);
                        finish();
                    }
                });
            }
        }, 3000);

    }
}
