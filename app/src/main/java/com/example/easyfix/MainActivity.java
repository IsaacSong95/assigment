package com.example.easyfix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_Login:
                Intent login = new Intent(this, Login.class);
                startActivity(login);
                Toast.makeText(this,"Login",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_Settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_signup:
                Intent signup = new Intent(this, SignUp.class);
                startActivity(signup);
                Toast.makeText(this, "Signup", Toast.LENGTH_LONG).show();
                break;
            default:

        }
        return super.onOptionsItemSelected(item);


    }

}