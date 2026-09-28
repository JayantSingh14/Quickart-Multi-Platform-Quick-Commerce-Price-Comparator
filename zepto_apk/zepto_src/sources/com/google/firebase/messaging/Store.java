package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Store {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f44762a;

    public static class Token {

        /* renamed from: d, reason: collision with root package name */
        public static final long f44763d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a, reason: collision with root package name */
        public final String f44764a;

        /* renamed from: b, reason: collision with root package name */
        public final String f44765b;

        /* renamed from: c, reason: collision with root package name */
        public final long f44766c;

        public Token(long j2, String str, String str2) {
            this.f44764a = str;
            this.f44765b = str2;
            this.f44766c = j2;
        }

        public static String a(long j2, String str, String str2) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e2);
                return null;
            }
        }

        public static Token b(String str) throws JSONException {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(0L, str, null);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getLong("timestamp"), jSONObject.getString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN), jSONObject.getString("appVersion"));
            } catch (JSONException e2) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e2);
                return null;
            }
        }
    }

    public Store(Context context) {
        boolean zIsEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f44762a = sharedPreferences;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                synchronized (this) {
                    sharedPreferences.edit().clear().commit();
                }
            }
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e2.getMessage());
            }
        }
    }

    public static String a(String str, String str2) {
        return androidx.fragment.app.e.D(str, "|T|", str2, "|*");
    }
}
