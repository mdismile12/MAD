package com.example.prac_7;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            textView.setText("Selected: Settings");
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_about) {
            textView.setText("Selected: About Us");
            Toast.makeText(this, "About Us Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_contact) {
            textView.setText("Selected: Contact Us");
            Toast.makeText(this, "Contact Us Clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_exit) {
            Toast.makeText(this, "Exiting application...", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
