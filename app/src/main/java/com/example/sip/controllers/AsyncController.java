package com.example.sip.controllers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.sip.controllers.volley.MySingleton;

import java.util.HashMap;
import java.util.Map;

import static com.example.sip.controllers.AppConfig.VERSION_PROYECTO;

public class AsyncController {
    String url;
    public static String SessionPreference = "SessionPreference";
    SharedPreferences sharedPreferences;

    public interface VolleyCallback {
        void onSuccessResponse(String result);
    }

    public static void volleyCallbackString(final Activity activity, int method, String url, final ProgressDialog loading, final String token, final CharSequence msjError, final Map<String, String> mapParams, final VolleyCallback volleyCallback){
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("<---------->");
                System.out.println("respuesta");
                System.out.println(response);
                volleyCallback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Boolean checkHost = true;
                CharSequence msj = "";

                if(error instanceof NoConnectionError){
                    checkHost = false;
                    msj = "Error con el Host";
                }
                if(error instanceof TimeoutError){
                    checkHost = false;
                    msj = "Error de conexion";
                }
                if(checkHost == true) {
                    int errorCode = error.networkResponse.statusCode;
                    if (errorCode == 401) {
                        Context context = activity.getApplicationContext();
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, msjError, duration);
                        toast.show();
                        loading.hide();
                    }
                    if (errorCode == 403) {
                        Context context = activity.getApplicationContext();
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, msjError, duration);
                        toast.show();
                        loading.hide();
                    }
                    if (errorCode == 404) {
                        Context context = activity.getApplicationContext();
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, msjError, duration);
                        toast.show();
                        loading.hide();
                    }
                    if (errorCode == 500) {
                        Context context = activity.getApplicationContext();
                        CharSequence text = "Ocurrio un error " + errorCode;
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        loading.hide();
                    }
                }else{
                    Context context = activity.getApplicationContext();;
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, msj, duration);
                    toast.show();
                    loading.hide();
                }
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                System.out.println("<---------->");
                System.out.println("params");
                System.out.println(mapParams);
                Map<String, String> params = new HashMap<String, String>();
                if(mapParams != null) {
                    for (Map.Entry<String, String> entry : mapParams.entrySet())
                    {
                        params.put(entry.getKey(), entry.getValue());
                    }
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                System.out.println("<---------->");
                System.out.println("headers");
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                headers.put("User-Agent", "AlusApp-android/"+VERSION_PROYECTO);
                headers.put("Cache-Control", "no-cache");
                if (token != null){
                    headers.put("Authorization", "Bearer " + token);
                }
                System.out.println(headers);
                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(10000, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance(activity).addToRequestQueue(stringRequest);

    }
}
