package com.example.mainscreen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Variable Declarations
    Intent intent;
    Bundle bundle;
    Cursor cursor;
    Button btnShelterIn, btnShelterUp, btnHuIn, btnHuUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable Initializations
        btnShelterIn = findViewById(R.id.ShelterSignInButton);
        btnShelterUp = findViewById(R.id.ShelterSignUpButton);
        btnHuIn = findViewById(R.id.HumanSignInButton);
        btnHuUp = findViewById(R.id.HumanSignUpButton);

        //Create a database to hold the tables
        SQLiteDatabase ggdDatabase = openOrCreateDatabase("ggd_Database", MODE_PRIVATE, null);
        ggdDatabase.execSQL("CREATE TABLE IF NOT EXISTS HumanUsers(FirstName VARCHAR, LastName VARCHAR, Email VARCHAR, Password VARCHAR, ID VARCHAR);");
        ggdDatabase.execSQL("CREATE TABLE IF NOT EXISTS dogShelter(ShelterName VARCHAR, LocationPoint VARCHAR,  Email VARCHAR, Phone VARCHAR, Password VARCHAR, ID VARCHAR);");
        ggdDatabase.execSQL("CREATE TABLE IF NOT EXISTS dogprofile(DogName VARCHAR, Gender VARCHAR,  breed VARCHAR, Age VARCHAR, ID VARCHAR, ShelterID VARCHAR);");
        cursor = ggdDatabase.rawQuery("SELECT * FROM HumanUsers;", null);
        if (cursor.getCount() == 0) {
            ggdDatabase.execSQL("INSERT INTO HumanUsers VALUES('admin', 'admin', 'amulkey21@yahoo.com', 'admin', '0');");
        }//End of if statement to initially populate the table HumanUsers

        btnShelterIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   intent = new Intent(MainActivity.this, ShelterUserSignInActivity.class);
            }//End of method onClick
        });//End of btnViewList.setOnClickListener

        btnShelterUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // intent = new Intent(MainActivity.this, ShelterUserSignUpActivity.class);
                startActivity(intent);
            }//End of method onClick
        });//End of btnShelterUp.setOnClickListener

        btnHuIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // intent = new Intent(MainActivity.this, HumanUserSignInActivity.class);
                startActivity(intent);
            }//End of method onClick
        });//End of btnHuIn.setOnClickListener

        btnHuUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, HumanUserSignUpActivity.class);
                startActivity(intent);
            }//End of method onClick
        });//End of btnHuUp.setOnClickListener

    }//End of method onCreate
}//End of MainActivity
