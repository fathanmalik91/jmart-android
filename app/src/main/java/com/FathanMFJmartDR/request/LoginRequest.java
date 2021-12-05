package com.FathanMFJmartDR.request;

/**
 * Class LoginRequest - write a description of the class here
 *
 * @author fathan
 * @version (version number or date here)
 */

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

//Class for Login Requests
public class LoginRequest extends StringRequest{
    private static final String URL = "http://10.0.2.2:1989/account/login";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }
    public Map<String, String> getParams(){
        return params;
    }
}
