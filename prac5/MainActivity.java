package com.example.parc_5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView resultText;
    private Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextNumber);
        num2 = findViewById(R.id.editTextNumber2);
        resultText = findViewById(R.id.textView2);

        btnAdd = findViewById(R.id.button);
        btnSub = findViewById(R.id.button2);
        btnMul = findViewById(R.id.button3);
        btnDiv = findViewById(R.id.button4);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        String n1Str = num1.getText().toString().trim();
        String n2Str = num2.getText().toString().trim();

        if (n1Str.isEmpty() || n2Str.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double n1 = Double.parseDouble(n1Str);
            double n2 = Double.parseDouble(n2Str);
            double result = 0;

            switch (operator) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
                case '/':
                    if (n2 == 0) {
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        resultText.setText("Result: Error (Div by 0)");
                        return;
                    }
                    result = n1 / n2;
                    break;
            }

            // Display formatted result (integer if whole number, otherwise decimal)
            if (result == (long) result) {
                resultText.setText("Result: " + (long) result);
            } else {
                resultText.setText("Result: " + result);
            }

        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid number format", Toast.LENGTH_SHORT).show();
        }
    }
}
