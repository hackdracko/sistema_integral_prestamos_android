package com.example.sip.controllers;

import android.os.Build;

public class AppConfig {
    public static String URL_WEB_SERVICE = "http://sip.com";
    public static int VERSION_PHONE = Build.VERSION.SDK_INT;
    public static String VERSION_SO = Build.VERSION.RELEASE;
    public static String API = "api";
    public static String VERSION = "v2";
    public static String VERSION_PROYECTO = "1.0";
    public static String URL_AUTHORIZE = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/authorize";
    public static String URL_PROFILE = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/user/profile";
    public static String URL_CDCS = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/cdcs";
    public static String URL_CATEGORIES = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/categories";
    public static String URL_ORDERS = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/orders/my";
    public static String URL_IMAGES_CATEGORIES = URL_WEB_SERVICE + "/img/categories";
    public static String URL_PRODUCTS = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/products";
    public static String URL_IMAGES_PRODUCTS = URL_WEB_SERVICE + "/img/product";
    public static String URL_GOALS = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/assignments/list-by-cdc";
    public static String URL_IMAGES_FAMILIES = URL_WEB_SERVICE + "/img/diageo-families";
    public static String URL_EXCHANGES = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/products/redeem";
    public static String URL_RECOVERY_PASSWORD = URL_WEB_SERVICE + "/" + API + "/" + VERSION + "/user/password_recovery_request";
    public static String URL_VIDEO_NORMAL_FIRST = "https://www.primerodiageomexico.com/statics/videos/ontrade-classic.mp4";
    public static String URL_VIDEO_PLATINUM_FIRST = "https://www.primerodiageomexico.com/statics/videos/ontrade-platinum.mp4";
    public static String URL_VIDEO_MYSTERY = "https://www.primerodiageomexico.com/statics/videos/mystery-shopper.mp4";
}
