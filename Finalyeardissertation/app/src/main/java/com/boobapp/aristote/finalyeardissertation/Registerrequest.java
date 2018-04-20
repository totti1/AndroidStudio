package com.boobapp.aristote.finalyeardissertation;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 10/13/2017.
 */

public class Registerrequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.43.61/android/register.php";
    private Map<String, String> params;

    public Registerrequest(String names, String username, String email, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("names", names);
        params.put("username", username);
        params.put("Email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}