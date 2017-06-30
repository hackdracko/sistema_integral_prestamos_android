package com.example.sip.controllers;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.example.sip.R;
import com.example.sip.models.json.Usuario;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    public static String SessionPreference = "SessionPreference";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Entrando al Usuario ...");
                final ProgressDialog loading = Utils.loading(LoginActivity.this, "Información", "Accediendo a la aplicación espere.");
                loading.show();
                AsyncController.volleyCallbackString(LoginActivity.this, Request.Method.GET, AppConfig.URL_WEB_SERVICE + "/api/login/1", loading, null, null, null, new AsyncController.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                        try {
                            Usuario usuario = objectMapper.readValue(result, Usuario.class);
                            System.out.println(usuario.getId());
                            System.out.println(usuario.getPromotor().getNombrePromotor());
                            System.out.println(usuario.getPromotor().getSucursal().getNombreSucursal());
                            sharedPreferences = getBaseContext().getSharedPreferences(SessionPreference, Context.MODE_PRIVATE);

                            /*
                            *   SET SESSION USER
                            */
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt("usuario_id", usuario.getId());
                            editor.putString("usuario_usuario", usuario.getUsuario());
                            editor.putInt("usuario_administrador", usuario.getAdministrador());
                            editor.putString("usuario_fecha_vencimiento", usuario.getFechaVencimiento());
                            editor.putInt("promotor_id", usuario.getPromotor().getId());
                            editor.putString("promotor_nombre", usuario.getPromotor().getNombre());
                            editor.putString("promotor_paterno", usuario.getPromotor().getPaterno());
                            editor.putString("promotor_materno", usuario.getPromotor().getMaterno());
                            editor.putString("promotor_nombre_promotor", usuario.getPromotor().getNombrePromotor());
                            editor.putString("promotor_telefono", usuario.getPromotor().getTelefono());
                            editor.putString("promotor_num_empleado", usuario.getPromotor().getNumEmpleado());
                            editor.putInt("sucursal_id", usuario.getPromotor().getSucursal().getId());
                            editor.putString("sucursal_direccion", usuario.getPromotor().getSucursal().getDireccion());
                            editor.putString("sucursal_colonia", usuario.getPromotor().getSucursal().getColonia());
                            editor.putString("sucursal_poblacion", usuario.getPromotor().getSucursal().getPoblacion());
                            editor.putInt("sucursal_estado_id", usuario.getPromotor().getSucursal().getEstadoId());
                            editor.putString("sucursal_localidad", usuario.getPromotor().getSucursal().getLocalidad());
                            editor.putString("sucursal_codigo_postal", usuario.getPromotor().getSucursal().getPoblacion());
                            editor.putString("sucursal_telefono", usuario.getPromotor().getSucursal().getCodigoPostal());
                            editor.putString("sucursal_correo", usuario.getPromotor().getSucursal().getCorreo());
                            editor.putInt("sucursal_iva", usuario.getPromotor().getSucursal().getIva());
                            editor.commit();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(result);
                        loading.hide();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}
