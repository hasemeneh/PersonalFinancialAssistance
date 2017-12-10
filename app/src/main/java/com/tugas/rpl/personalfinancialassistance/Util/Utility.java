package com.tugas.rpl.personalfinancialassistance.Util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.location.Location;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.tugas.rpl.personalfinancialassistance.Model.UserDao;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Undetected on 11/24/2017.
 */

public class Utility {
    private static String USER_CREDENTIALS = "USER_CREDENTIALS";
    private static String USER_CERTIFICATIONS = "USER_CERTIFICATIONS";
    private static String CACHED_LANDING_INFO = "CACHED_LANDING_INFO";
    private static String SHARED_PREFERENCES_KEY = "POSSI_INDONESIA";
    private static String DEFAULT_STRING_VALUE = "DEFAULT_STRING_VALUE";


    public static void hideKeyboard(Context context) {
        InputMethodManager inputManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) context).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static String getCachedText(Activity activity, String keys) {
        final SharedPreferences myPrefs = activity.getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE);
        return myPrefs.getString(keys, DEFAULT_STRING_VALUE);
    }

    public static void setCachedText(Activity activity, String keys, String data) {
        final SharedPreferences myPrefs = activity.getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE);
        final SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString(keys, data);
        editor.commit();
    }



    public static UserDao getCurrentUser(Activity activity) {
        final String json = getCachedText(activity, USER_CREDENTIALS);
        if (json == null || json.equals("") || json.equals(DEFAULT_STRING_VALUE)) {
            return null;
        }

        //Toast.makeText(activity, ""+json, Toast.LENGTH_SHORT).show();
        final Gson gson = new Gson();
        final UserDao userCredentials = gson.fromJson(json, UserDao.class);
        return userCredentials;
    }

    public static void setCurrentUser(Activity activity, UserDao data) {
        final Gson gson = new Gson();
        setCachedText(activity, USER_CREDENTIALS, gson.toJson(data));
    }


    public static void revokeCurrentUser(Activity activity) {
        final Gson gson = new Gson();
        setCachedText(activity, USER_CREDENTIALS, "");
        setCachedText(activity, USER_CERTIFICATIONS, "");
    }

    public static void showYesNoDialog(Activity activity, String message, String title, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        AlertDialog dialog;
        builder.setMessage(message).setTitle(title);
        builder.setPositiveButton("Ya", okListener);

        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }


}
