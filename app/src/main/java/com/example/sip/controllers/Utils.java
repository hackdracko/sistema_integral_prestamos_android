package com.example.sip.controllers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sip.R;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static ProgressDialog loading (Activity activity, String titulo, String mensaje){

        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(titulo);
        progressDialog.setMessage(mensaje);
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static Shader textGradientMetallic(){
        int[] color = {Color.WHITE, Color.GRAY};
        float[] position = {0, 1};
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        Shader textShader = new LinearGradient(0, 37, 0, 0,
                color,
                position,
                tileMode);
        return textShader;
    }
    public static Typeface fontAntenaRegular(Context c){
        Typeface font;
        font = Typeface.createFromAsset(c.getAssets(), "fonts/FordAntennaWGL-Regular_0.otf");
        return font;
    }
    public static Typeface fontAntenaThin(Context c){
        Typeface font;
        font = Typeface.createFromAsset(c.getAssets(), "fonts/FordAntennaWGL-Thin_0.otf");
        return font;
    }
    public static Typeface fontAntenaLight(Context c){
        Typeface font;
        font = Typeface.createFromAsset(c.getAssets(), "fonts/FordAntennaWGL-Light_0.otf");
        return font;
    }
    public static Typeface fontAntenaExtraLight(Context c){
        Typeface font;
        font = Typeface.createFromAsset(c.getAssets(), "fonts/FordAntennaWGL-ExtraLight_0.otf");
        return font;
    }
    public static void setTitleToolbar(Activity activity, String title){
        Toolbar toolbar = (Toolbar)activity.findViewById(R.id.toolbar);
        toolbar.setTitle(title);

    }
    public static String getStringTextView(TextView textView){
        return textView.getText().toString();
    }

    public static void getImageFromURL(ImageView img, String url){
        new loadImageTask(img).execute(url);
    }

    private static class loadImageTask extends AsyncTask<String, Void, Bitmap>
    {
        ImageView bmimg;
        public loadImageTask(ImageView bmimg){
            this.bmimg = bmimg;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            bmimg.setImageBitmap(result);
        }
    }

    public static Drawable getImageProfileNormal (Activity activity, String position){
        String image = "";
        switch (position) {
            case "waiter":
                image = "profile_waiter";
                break;
            case "bartender":
                image = "profile_bartender";
                break;
            case "capitan":
                image = "profile_capitan";
                break;
            case "hostess":
                image = "profile_hostess";
                break;
            case "manager":
                image = "profile_manager";
                break;

            default:
                image = "profile_waiter";
                break;
        }
        String string = "@drawable/"+image;
        int imageId = activity.getResources().getIdentifier(string, null, activity.getPackageName());
        Drawable drawable = ContextCompat.getDrawable(activity, imageId);
        return drawable;
    }

    public static Drawable getImageProfilePlatinum (Activity activity, String position){
        String image = "";
        switch (position) {
            case "waiter":
                image = "profile_platinum_waiter";
                break;
            case "bartender":
                image = "profile_platinum_bartender";
                break;
            case "capitan":
                image = "profile_platinum_capitan";
                break;
            case "hostess":
                image = "profile_platinum_hostess";
                break;
            case "manager":
                image = "profile_platinum_manager";
                break;

            default:
                image = "profile_platinum_waiter";
                break;
        }
        String string = "@drawable/"+image;
        int imageId = activity.getResources().getIdentifier(string, null, activity.getPackageName());
        Drawable drawable = ContextCompat.getDrawable(activity, imageId);
        return drawable;
    }

    public static String getStringMonth (int month) {
        String strMonth = "";
        if (month == 0){
            strMonth = "Enero";
        } else if(month == 1){
            strMonth = "Febrero";
        } else if(month == 2){
            strMonth = "Marzo";
        } else if(month == 3){
            strMonth = "Abril";
        } else if(month == 4){
            strMonth = "Mayo";
        } else if(month == 5){
            strMonth = "Junio";
        } else if(month == 6){
            strMonth = "Julio";
        } else if(month == 7){
            strMonth = "Agosto";
        } else if(month == 8){
            strMonth = "Septiembre";
        } else if(month == 9){
            strMonth = "Octubre";
        } else if(month == 10){
            strMonth = "Noviembre";
        } else if(month == 11){
            strMonth = "Diciembre";
        }
        return strMonth;
    }
}
