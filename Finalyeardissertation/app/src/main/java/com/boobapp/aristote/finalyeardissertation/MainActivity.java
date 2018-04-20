package com.boobapp.aristote.finalyeardissertation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText usernameET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Etusername = (EditText) findViewById(R.id.usernameet);
        final EditText Etpassword = (EditText) findViewById(R.id.passwordet);
        final Button LoginBtn = (Button) findViewById(R.id.loginbtn);
        final TextView Registertv = (TextView) findViewById(R.id.etregister);

        Registertv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });


    }
    public void login(View view) {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String type = "login";
        Backgroundworker backgroundworker = new Backgroundworker(this);
        backgroundworker.execute(type, username, password);
    }
}