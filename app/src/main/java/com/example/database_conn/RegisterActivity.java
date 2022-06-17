package com.example.database_conn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DbHelper db=new DbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        String username=((EditText) findViewById(R.id.reguser)).getText().toString();
        String password=((EditText) findViewById(R.id.confpass)).getText().toString();
        String conf_pass=((EditText)findViewById(R.id.regpass)).getText().toString();
        if(username.trim().equals("")||password.trim().equals("")||conf_pass.trim().equals(""))
            Toast.makeText(this, "Please fill all the required fields", Toast.LENGTH_SHORT).show();
        else if(!password.equals(conf_pass)){
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
        }
        else if(db.checkUsername(username)){
            Toast.makeText(this, "Username already exists !! ", Toast.LENGTH_SHORT).show();
        }
        else{
            if(db.insertData(username,password)){
                Toast.makeText(this, "Registration successful !! Please Login", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Something went wrong please try again!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}