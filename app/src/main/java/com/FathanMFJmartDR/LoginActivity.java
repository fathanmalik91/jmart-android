package com.FathanMFJmartDR;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.FathanMFJmartDR.request.LoginRequest;
import com.FathanMFJmartDR.model.Account;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener{
    //private static final Gson gson = new Gson();
    private static Account loggedAccount = null;
    private EditText etEmail;
    private EditText etPass;
    private Button btnLogin;
    private TextView tvRegister;

    public static Account getLoggedAccount(){
        return loggedAccount;
    }
    private void onRegisterClick(View view){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.emailLogin);
        etPass = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.loginButton);
        tvRegister = findViewById(R.id.emailRegister);

        etEmail.setText("fathan.malik91@ui.ac.id");
        etPass.setText("fathamalik12");
        btnLogin.setOnClickListener(this::onLoginClick);
        tvRegister.setOnClickListener(this::onRegisterClick);

    }

    private void onLoginClick(View view){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(String response) {
        Intent i = new Intent(this, MainActivity.class);
        try{
            JSONObject object = new JSONObject(response);
            i.putExtra("id", object.getInt("id"));
        }
        catch(Exception e){
            Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "Login Successfull", Toast.LENGTH_LONG).show();
        startActivity(i);
    }
}