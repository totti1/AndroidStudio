package com.boobapp.aristote.finalyeardissertation;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText Etnames, Etusername, Etemail, Etpassword;
    private Button Btnregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText Etnames = (EditText) findViewById(R.id.etname);
        EditText Etusername = (EditText) findViewById(R.id.etusername);
        EditText Etemail = (EditText) findViewById(R.id.etEmail);
        EditText Etpassword = (EditText) findViewById(R.id.etpassword);
        Button Btnregister = (Button) findViewById(R.id.sendbtn);

    }

            private void registeruser() {
                final String names = Etnames.getText().toString();
                final String username = Etusername.getText().toString();
                final String email = Etemail.getText().toString();
                final String password = Etpassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonresponse = new JSONObject(response);
                            boolean success = jsonresponse.getBoolean("message");
                            if (success){
                                Intent intent = new Intent(RegisterActivity.this, PageAdapter.class);
                                startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registering Failed!!!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Registerrequest registerrequest = new Registerrequest(names, username, email, password, responseListener );
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerrequest);
            }



    @Override
    public void onClick(View view) {
 if (view == Btnregister)
     registeruser();
        Intent intent = new Intent(this, PagerAdapter.class);
        startActivity(intent);
    }
}
