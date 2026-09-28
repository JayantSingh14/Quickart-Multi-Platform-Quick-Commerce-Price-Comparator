package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class NotificationParams {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f44730a;

    public NotificationParams(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.f44730a = new Bundle(bundle);
    }

    public static boolean k(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String m(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public final boolean a(String str) {
        String strI = i(str);
        return "1".equals(strI) || Boolean.parseBoolean(strI);
    }

    public final Integer b(String str) {
        String strI = i(str);
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(strI));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + m(str) + "(" + strI + ") into an int");
            return null;
        }
    }

    public final JSONArray c(String str) {
        String strI = i(str);
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        try {
            return new JSONArray(strI);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + m(str) + ": " + strI + ", falling back to default");
            return null;
        }
    }

    public final int[] d() throws JSONException {
        JSONArray jSONArrayC = c("gcm.n.light_settings");
        if (jSONArrayC == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (jSONArrayC.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int color = Color.parseColor(jSONArrayC.optString(0));
            if (color == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = color;
            iArr[1] = jSONArrayC.optInt(1);
            iArr[2] = jSONArrayC.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e2) {
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArrayC + ". " + e2.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + jSONArrayC + ". Skipping setting LightSettings");
            return null;
        }
    }

    public final Object[] e(String str) {
        JSONArray jSONArrayC = c(str.concat("_loc_args"));
        if (jSONArrayC == null) {
            return null;
        }
        int length = jSONArrayC.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArrayC.optString(i2);
        }
        return strArr;
    }

    public final String f(String str) {
        return i(str.concat("_loc_key"));
    }

    public final Long g() {
        String strI = i("gcm.n.event_time");
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strI));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + m("gcm.n.event_time") + "(" + strI + ") into a long");
            return null;
        }
    }

    public final String h(Resources resources, String str, String str2) {
        String strI = i(str2);
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        String strF = f(str2);
        if (!TextUtils.isEmpty(strF)) {
            int identifier = resources.getIdentifier(strF, "string", str);
            if (identifier == 0) {
                Log.w("NotificationParams", m(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
                return null;
            }
            Object[] objArrE = e(str2);
            if (objArrE == null) {
                return resources.getString(identifier);
            }
            try {
                return resources.getString(identifier, objArrE);
            } catch (MissingFormatArgumentException e2) {
                Log.w("NotificationParams", "Missing format argument for " + m(str2) + ": " + Arrays.toString(objArrE) + " Default value will be used.", e2);
            }
        }
        return null;
    }

    public final String i(String str) {
        Bundle bundle = this.f44730a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String strReplace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(strReplace)) {
                str = strReplace;
            }
        }
        return bundle.getString(str);
    }

    public final long[] j() throws JSONException {
        JSONArray jSONArrayC = c("gcm.n.vibrate_timings");
        if (jSONArrayC == null) {
            return null;
        }
        try {
            if (jSONArrayC.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = jSONArrayC.length();
            long[] jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArrayC.optLong(i2);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + jSONArrayC + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    public final Bundle l() {
        Bundle bundle = this.f44730a;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }
}
