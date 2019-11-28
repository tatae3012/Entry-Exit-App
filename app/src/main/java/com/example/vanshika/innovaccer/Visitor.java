package com.example.vanshika.innovaccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;

public class Visitor extends AppCompatActivity {
    DatabaseHelper myDb;
    DatabaseHelper2 myDb2;
    EditText name,email,phone,in,out,reason;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor_act);
        myDb = new DatabaseHelper(this);
        myDb2 = new DatabaseHelper2(this);

        name = (EditText)findViewById(R.id.c1);
        email = (EditText)findViewById(R.id.c2);
        phone = (EditText)findViewById(R.id.b3);
        in = (EditText)findViewById(R.id.b4);
        out = (EditText) findViewById(R.id.b5);
        reason = (EditText) findViewById(R.id.b6);
        btnAddData = (Button) findViewById(R.id.b7);
        AddData();

    }


    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insert1(name.getText().toString(),
                                email.getText().toString(),
                                phone.getText().toString(),
                                in.getText().toString(),
                                out.getText().toString());
                        List<String> hst = new ArrayList<String>();
                        hst = myDb2.getHost();
                        String[] TO = {hst.get(1)};
                        String[] H =  {hst.get(0)};
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);

                        //emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.setType("message/rfc822");
                        //emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Visitor Details ");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hey "+H+"!\n\nThis is to update you with the visitor who would like to visit our office for: "+reason.getText().toString()+"\n\nVISITOR DETAILS"+"\nNAME: "+name.getText().toString()+"\nEmail: "+email.getText().toString()+"\nPhone: "+phone.getText().toString()+"\nCheckin Time: "+in.getText().toString()+"\nCheckout Time: "+out.getText().toString());
                        emailIntent.setData(Uri.parse("mailto:"+hst.get(1))); // or just "mailto:" for blank
                        //emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        Toast toast=Toast.makeText(getApplicationContext(),"Hey "+H+"!\n\nThis is to update you with the visitor who would like to visit our office for: "+reason.getText().toString()+"\n\nVISITOR DETAILS"+"\nNAME: "+name.getText().toString()+"\nEmail: "+email.getText().toString()+"\nPhone: "+phone.getText().toString()+"\nCheckin Time: "+in.getText().toString()+"\nCheckout Time: "+out.getText().toString(),Toast.LENGTH_LONG);
                        toast.setMargin(50,50);
                        //toast.show();
                        try {
                            //startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                            //finish();
                        } catch (android.content.ActivityNotFoundException ex) {

                        }

                        //String[] TO1 = {email.getText().toString()};

                        Intent emailIntent1 = new Intent(Intent.ACTION_SENDTO);

                        //emailIntent1.setData(Uri.parse("mailto:"));
                        emailIntent1.setType("message/rfc822");
                        //emailIntent1.putExtra(Intent.EXTRA_EMAIL, TO1);
                        emailIntent1.putExtra(Intent.EXTRA_SUBJECT, "Your Innovaccer Visit Details ");
                        emailIntent1.putExtra(Intent.EXTRA_TEXT, "Hey !"+"\n\nThis is regarding your visit details to our office: "+"\n\nDETAILS"+"\nNAME: "+name.getText().toString()+"\nPhone: "+phone.getText().toString()+"\nCheckin Time: "+in.getText().toString()+"\nCheckout Time: "+out.getText().toString()+"\nHost Name: "+hst.get(0)+"\nAddress Visited: 2nd and 9th Floor, Tower 3, Candor Techspace, Rajat Vihar,\nBlock B, Industrial Area, Sector 62, Noida,\nUttar Pradesh 201309"+"\n\nHope you had a great experience and we look forward to your next vist."+"\n\n\nRegards\nTeam Innovaccer");
                        emailIntent1.setData(Uri.parse("mailto:"+email.getText().toString())); // or just "mailto:" for blank
                        //emailIntent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                        Toast toast1=Toast.makeText(getApplicationContext(),"Hey "+hst.get(0)+"!\n\nThis is to update you with the visitor who would like to visit our office for: "+reason.getText().toString()+"\n\nVISITOR DETAILS"+"\nNAME: "+name.getText().toString()+"\nEmail: "+email.getText().toString()+"\nPhone: "+phone.getText().toString()+"\nCheckin Time: "+in.getText().toString()+"\nCheckout Time: "+out.getText().toString(),Toast.LENGTH_LONG);
                        toast1.setMargin(50,50);
                        toast1.show();
                        try {
                            startActivity(Intent.createChooser(emailIntent1, "Send mail..."));
                            finish();
                        } catch (android.content.ActivityNotFoundException ex) {

                        }

                        Intent intent1 = new Intent(Visitor.this, Last.class);
                        startActivity(intent1);
                    }
                }
        );
    }

}