package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btn;
    private EditText user;
    private EditText pass;

    private String username = "username";
    private String password = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = (Button) findViewById(R.id.login_btn_name);
        user = (EditText) findViewById(R.id.user_edit_name);
        pass = (EditText) findViewById(R.id.pass_edit_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.getText().toString().equals(username) && pass.getText().toString().equals(password)){
                    Toast.makeText(Login.this, "Welcome " + username, Toast.LENGTH_SHORT).show();
                    switchActivities();
                }
            }
        });
    }

    private void switchActivities() {
        Intent switchAcitivityIntent = new Intent(this, MainActivity.class);
        startActivity(switchAcitivityIntent);
    }
}