package com.example.mainscreen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DogProfileCreationActivity extends AppCompatActivity {
    //Variable Declarations
    Button btnSubmit;
    Cursor cursor;
    SQLiteDatabase ggdDatabase;
    EditText etDogName, etDogBreed, etDogColor, etDogGender, etDogAge,  etDogBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_profile_creation);

        //Variable Initializations
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        etDogName = (EditText) findViewById(R.id.et_dog_name);
        etDogBreed = (EditText) findViewById(R.id.et_dog_breed);
        etDogColor = (EditText) findViewById(R.id.et_dog_color);
        etDogGender = (EditText) findViewById(R.id.et_dog_gender);
        etDogAge = (EditText) findViewById(R.id.et_dog_age);
        etDogBio = (EditText) findViewById(R.id.et_dog_bio);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)    {
                //Add the dog to the table
            }//End of method onClick
        });//End of method btnSubmit.setOnClickListener
    }//End of method onCreate
}//End of class DogProfileCreationActivity