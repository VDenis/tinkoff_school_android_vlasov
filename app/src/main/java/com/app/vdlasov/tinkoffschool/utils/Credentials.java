package com.app.vdlasov.tinkoffschool.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Denis on 31.03.2017.
 */

public class Credentials {

    private static final String PREF_LOGIN = "LOGIN_PREF";

    private static final String KEY_CREDENTIALS_LOGIN = "KEY_CREDENTIALS_LOGIN";

    private static final String KEY_CREDENTIALS_PASS = "KEY_CREDENTIALS_PASS";

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
    }

    public static boolean isUserLogin(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        if (preferences.contains(KEY_CREDENTIALS_LOGIN)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getUserLogin(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        return preferences.getString(KEY_CREDENTIALS_LOGIN, "Nobody");
    }

    public static void loginUser(Context context, String login, String pass) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_CREDENTIALS_LOGIN, login);
        editor.putString(KEY_CREDENTIALS_PASS, String.valueOf(pass.hashCode()));
        editor.apply();
    }

    public static void logoutUser(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
