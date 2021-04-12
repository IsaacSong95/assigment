package com.example.easyfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    AppCompatEditText textInputEditTextUsername, textInputEditTextPasswrod;
    Button buttonLogin;
    TextView textViewSignup;
    ProgressBar progressBar;
    Button xxx;
    TextView textVieweeSignup;



    String sdfsdf;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername = findViewById (R.id.UsernameLogin);
        textInputEditTextPasswrod = findViewById(R.id.PasswordLogin);
        buttonLogin = findViewById(R.id.ButtonLogin);
        textViewSignup = findViewById(R.id.signUpText);
        progressBar = findViewById(R.id.progresslogin);

        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password;

                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPasswrod.getText());
                Intent MainActivity = new Intent(Login.this, MainActivity.class);
                startActivity(MainActivity);


                if (!username.equals("") && !password.equals("") ) {
                    progressBar.setVisibility(View.VISIBLE);

//                    Handler handler = new Handler();
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            String[] field = new String[2];
//                            field[0] = "username";
//                            field[1] = "password";
//
//
//                            String[] data = new String[2];
//                            data[0] = "username";
//                            data[1] = "password";
//                            PutData putData = new PutData("https://192.168.178.39/LoginRegister/login.php", "POST", field, data);
//                            if (putData.startPut()) {
//                                if (putData.onComplete()) {
//                                    progressBar.setVisibility(View.GONE);
//                                    String result = putData.getResult();
//                                    if(result.equals("login Success")){
//                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                        startActivity(intent);
//                                        finish();
//
//                                    }
//
//                                    else {
//                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    );
                }

                else {
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}