package com.boobapp.aristote.boobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EtDeparture, ETDestination, EtTime, EtF_name, EtL_name, EtDate, EtNum;
    private Button BtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtDeparture = (EditText) findViewById(R.id.EtDeparture);
        ETDestination = (EditText) findViewById(R.id.EtDestination);
        EtTime = (EditText) findViewById(R.id.EtTime);
        EtF_name = (EditText) findViewById(R.id.EtFname);
        EtL_name = (EditText) findViewById(R.id.EtLname);
        EtDate = (EditText) findViewById(R.id.EtDate);
        EtNum = (EditText) findViewById(R.id.EtNum);
        BtnNext = (Button) findViewById(R.id.BtnNext);
        BtnNext.setOnClickListener(this);
    }

    private void insertRecord() {
        final String Departure = EtDeparture.getText().toString().trim();
        final String Destination = ETDestination.getText().toString().trim();
        final String Time = EtTime.getText().toString().trim();
        final String F_name = EtF_name.getText().toString().trim();
        final String L_name = EtL_name.getText().toString().trim();
        final String Date = EtDate.getText().toString().trim();
        final String NumOfPass = EtNum.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constant.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Departure", Departure);
                params.put("Destination", Destination);
                params.put("Time", Time);
                params.put("F-name", F_name);
                params.put("L-name", L_name);
                params.put("Date", Date);
                params.put("NumOfPass", NumOfPass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        if (view == BtnNext)
            insertRecord();
        Intent intent = new Intent(this, Transaction.class);
        startActivity(intent);

    }
}


