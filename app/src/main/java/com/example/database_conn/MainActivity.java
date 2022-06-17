 package com.example.database_conn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

     DbHelper db=new DbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void login(View view) {
         String username=((EditText) findViewById(R.id.username)).getText().toString();
         String pass=((EditText) findViewById(R.id.pass)).getText().toString();
         if(username.trim().equals("")||pass.trim().equals(""))
             Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
         else{
             if(db.checkCred(username,pass)){
                 Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                 Intent intent=new Intent(getApplicationContext(),SuccessActivity.class);
                 startActivity(intent);
             }
             else{
                 Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
             }
         }
     }

     public void regNav(View view) {
         Intent intent =new Intent(getApplicationContext(),RegisterActivity.class);
         startActivity(intent);
     }
 }