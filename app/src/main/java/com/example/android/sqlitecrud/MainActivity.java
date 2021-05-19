package com.example.android.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name, contact, email;
    FloatingActionButton fb;
    Button mBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextInputEditText) findViewById(R.id.name_text);
        contact = (TextInputEditText) findViewById(R.id.contact_text);
        email = (TextInputEditText) findViewById(R.id.email_text);
        fb = (FloatingActionButton) findViewById(R.id.fabtn);
        mBTN = (Button) findViewById(R.id.submit_add);

       mBTN.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ProcessInsert(name.getText().toString(),contact.getText().toString(),email.getText().toString());
           }
       });
       fb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, FetchDataActivity.class);
               startActivity(intent);
           }
       });
    }

    private void ProcessInsert(String n, String c, String e){

        String res = new DbManager(this).addRecord(n,c,e);
        name.setText("");
        contact.setText("");
        email.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();

    }
}