package com.example.sip.controllers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.example.sip.R;

public class LoginActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final ProgressDialog loading = Utils.loading(LoginActivity.this, "Información", "Accediendo a la aplicación espere.");
        loading.show();
        AsyncController.volleyCallbackString(LoginActivity.this, Request.Method.GET, AppConfig.URL_WEB_SERVICE + "/api/login/4", loading, null, null, null, new AsyncController.VolleyCallback() {
                @Override
                public void onSuccessResponse(String result) {
                    System.out.println(result);
                    loading.hide();
                }
        });

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Entrando al Login ...");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
