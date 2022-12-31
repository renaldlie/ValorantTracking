package com.example.valoranttracking.view.activities;

import static androidx.constraintlayout.motion.widget.TransitionBuilder.validate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.valoranttracking.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText username, password;
    public Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.lbl_username);
        password = (EditText) findViewById(R.id.lbl_password);
        Login = findViewById(R.id.btn_login);

        Login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_login ){
            if(isEmpty(username) || isEmpty(password)){
                Toast.makeText(this, "Please fill the username and password !",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Login Succesful !",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(loginActivity.this, mainMenuActivity.class);
                startActivity(intent);
            }


        }


    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }


}