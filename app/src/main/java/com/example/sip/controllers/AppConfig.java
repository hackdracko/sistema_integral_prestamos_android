package com.example.sip.controllers;

import android.os.Build;

public class AppConfig {
    public static String URL_WEB_SERVICE = "http://sip.com";
    public static int VERSION_PHONE = Build.VERSION.SDK_INT;
    public static String VERSION_SO = Build.VERSION.RELEASE;
    public static String API = "api";
    public static String VERSION = "v2";
    public static String VERSION_PROYECTO = "1.0";
    public static String URL_LOGIN = URL_WEB_SERVICE + "/" + API + "/login";
    public static String URL_GRUPOFORMACION_CREATE = URL_WEB_SERVICE + "/" + API + "/grupoFormacion/create";
}
