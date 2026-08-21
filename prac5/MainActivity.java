package com.example.parc_5;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Num1 = findViewById(R.id.editTextNumber);
        Num2 = findViewById(R.id.editTextNumber2);
        Button plus = findViewById(R.id.button2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = .getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (email.equals("md@gmail.com") && password.equals("123456")) {
                    Toast.makeText(MainActivity.this, "Success! Logging you in.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
