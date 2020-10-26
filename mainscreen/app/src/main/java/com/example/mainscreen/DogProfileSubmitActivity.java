package com.example.mainscreen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DogProfileSubmitActivity extends AppCompatActivity {

    Button btn_submit_dog_profile;
    Cursor cursor;
    SQLiteDatabase ggdDatabase;
    EditText etdogname, etbreed, etcolor, etgender, etage, etsize, etbio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_profile_sign_up);

        //dog profile variable init

        btn_submit_dog_profile = findViewById(R.id.btn_submit_dog_profile);
        etdogname = findViewById(R.id.et_dogname);
        etbreed = findViewById(R.id.et_dogbreed);
        etcolor = findViewById(R.id.et_dog_color);
        etgender = findViewById(R.id.et_dog_gender);
        etage = findViewById(R.id.et_dog_age);
        etsize = findViewById(R.id.et_dog_size);
        etbio = findViewById(R.id.et_dog_bio);

      btn_submit_dog_profile.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if (etdogname==null) {
                  Toast.makeText(getApplicationContext(), "Please enter a name.", Toast.LENGTH_SHORT).show();
              }
            }
      });

    }
}


