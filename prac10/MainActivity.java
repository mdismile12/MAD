package com.example.prac_10;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtEmail;
    private TextView txtDisplay;
    private Button btnSave, btnLoad, btnClear;

    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_NAME = "name_key";
    private static final String KEY_EMAIL = "email_key";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        txtDisplay = findViewById(R.id.txtDisplay);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnClear = findViewById(R.id.btnClear);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });
    }

    private void saveData() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.apply();

        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
        edtName.setText("");
        edtEmail.setText("");
    }

    private void loadData() {
        if (sharedPreferences.contains(KEY_NAME) && sharedPreferences.contains(KEY_EMAIL)) {
            String name = sharedPreferences.getString(KEY_NAME, "");
            String email = sharedPreferences.getString(KEY_EMAIL, "");
            txtDisplay.setText("Retrieved Data:\nName: " + name + "\nEmail: " + email);
        } else {
            txtDisplay.setText("No saved data found!");
        }
    }

    private void clearData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        txtDisplay.setText("Data Cleared!");
        Toast.makeText(this, "Cleared SharedPreferences", Toast.LENGTH_SHORT).show();
    }
}
