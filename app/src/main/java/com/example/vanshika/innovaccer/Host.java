package com.example.vanshika.innovaccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Host extends AppCompatActivity {
    DatabaseHelper2 myDb;
    EditText name, email, phone;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_act);
        myDb = new DatabaseHelper2(this);

        name = (EditText) findViewById(R.id.c1);
        email = (EditText) findViewById(R.id.c2);
        phone = (EditText) findViewById(R.id.c3);
        btnAddData = (Button) findViewById(R.id.c4);
        AddData();
    }


    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insert2(name.getText().toString(),
                                email.getText().toString(),
                                phone.getText().toString());
                        Intent intent1 = new Intent(Host.this, Last.class);
                        startActivity(intent1);
                    }
                }
        );
    }

}