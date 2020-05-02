package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etNumber, etWeb, etLocation;
    ImageView ivHappy, ivOk, ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWeb = findViewById(R.id.etWeb);
        etLocation = findViewById(R.id.etLocation);
        ivHappy = findViewById(R.id.ivHappy);
        ivOk = findViewById(R.id.ivOk);
        ivSad = findViewById(R.id.ivSad);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty()
        || etLocation.getText().toString().isEmpty()) {
            Toast.makeText(this, "please enter all fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("location", etLocation.getText().toString().trim());

            if(v.getId() == R.id.ivHappy) {
                intent.putExtra("mood", "happy");
            }
            else if(v.getId() == R.id.ivOk) {
                intent.putExtra("mood", "ok");
            }
            else {
                intent.putExtra("mood", "sad");
            }
            setResult(RESULT_OK, intent);
            CreateContact.this.finish();
        }
    }
}
