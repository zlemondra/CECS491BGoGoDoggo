package com.example.mainscreen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Variable Declarations
    Intent intent;
    Bundle bundle;
    Cursor cursor;
    Button btnSignIn, btnSignUp;
    Spinner spinnerUserType;
    List<String> userTypeSelection = new ArrayList<String>();
    int userChoic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable Initializations
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        spinnerUserType = (Spinner) findViewById(R.id.spinner_user_type);
        userTypeSelection.add("Select a User Type");
        userTypeSelection.add("Human User");
        userTypeSelection.add("Shelter");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userTypeSelection); //For the spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //For the spinner
        spinnerUserType.setAdapter(dataAdapter);    //For the spinner

        //Create a database to hold the tables
        SQLiteDatabase ggdDatabase = openOrCreateDatabase("ggd_Database", MODE_PRIVATE, null);
        ggdDatabase.execSQL("CREATE TABLE IF NOT EXISTS HumanUsers(FirstName VARCHAR, LastName VARCHAR, Email VARCHAR, Password VARCHAR, ID VARCHAR);");
        ggdDatabase.execSQL("CREATE TABLE IF NOT EXISTS dogShelter(ShelterName VARCHAR, LocationPoint VARCHAR,  Email VARCHAR, Phone VARCHAR, Password VARCHAR, ID VARCHAR);");
        ggdDatabase.execSQL("CREATE TABLE IF NOT EXISTS dogprofile(DogName VARCHAR, Gender VARCHAR,  breed VARCHAR, Age VARCHAR, ID VARCHAR, ShelterID VARCHAR);");
        cursor = ggdDatabase.rawQuery("SELECT * FROM HumanUsers;", null);
        if (cursor.getCount() == 0) {
            ggdDatabase.execSQL("INSERT INTO HumanUsers VALUES('admin', 'admin', 'amulkey21@yahoo.com', 'admin', '0');");
        }//End of if statement to initially populate the table HumanUsers

        // Spinner click listener
        spinnerUserType.setOnItemSelectedListener(MainActivity.this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent = new Intent(MainActivity.this, HumanUserSignUpActivity.class);
                //startActivity(intent);
            }//End of method onClick
        });//End of btnHuIn.setOnClickListener

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (userChoic)  {
                    case 1: //Navigate to HumanUserSignUpActivity to register a human user
                        intent = new Intent(MainActivity.this, HumanUserSignUpActivity.class);
                        startActivity(intent);
                        break;
                    case 2: //Navigate to register a shelter
                        Toast.makeText(getApplicationContext(), "Please select a user type to continue", Toast.LENGTH_LONG).show();
                        break;
                    default:    //Anything else
                }//End of switch statement to decide what page to go to
            }//End of method onClick
        });//End of btnSignUp.setOnClickListener


    }//End of method onCreate

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        switch (position)   {
            case 1:
                userChoic = 1;
                break;
            case 2:
                userChoic = 2;
                break;
            default:
                Toast.makeText(parent.getContext(), "Please select a user type to continue", Toast.LENGTH_LONG).show();
                userChoic = 0;
        }//End of switch statement
    }//End of onItemSelected
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }//End of onNothingSelected
}//End of MainActivity



