package com.zeptoconsumerapp.PhoenixBackgroundWorker;

import android.content.Context;
import android.provider.Settings;
import bridges.CommsModule;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import j$.util.DesugarTimeZone;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Random;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WorkerUtils {
    public static String a(Context context) {
        return context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).getString("PhoenixBackgroundWorkerConfig", null);
    }

    public static boolean b(Context context) {
        String strA = a(context);
        if (strA == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA);
            if (jSONObject.has("isTimeRangeEnabled")) {
                return jSONObject.optBoolean("isTimeRangeEnabled", false);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null && !string.isEmpty()) {
            HashFunction hashFunctionA = Hashing.a();
            Charset charset = StandardCharsets.UTF_8;
            int iB = (hashFunctionA.a(string).b() % 100) + 1;
            try {
                String strA = a(context);
                if (strA != null) {
                    int iOptInt = new JSONObject(strA).optInt("rolloutPercentage", 0);
                    if (iOptInt < 0 || iOptInt > 100 || iB > iOptInt) {
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static long d(Context context, long j2) throws JSONException {
        String strA = a(context);
        if (strA != null) {
            try {
                JSONObject jSONObject = new JSONObject(strA);
                if (jSONObject.has("workerTimeRange")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("workerTimeRange");
                    int iOptInt = jSONObject2.optInt("from", 0);
                    int iOptInt2 = jSONObject2.optInt("to", 6);
                    if (iOptInt >= 0 && iOptInt <= 23 && iOptInt2 >= 0 && iOptInt2 <= 23 && iOptInt != iOptInt2) {
                        int iNextInt = (iOptInt < iOptInt2 ? new Random().nextInt((iOptInt2 - iOptInt) + 1) : new Random().nextInt((24 - iOptInt) + iOptInt2)) + iOptInt;
                        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Kolkata"));
                        long timeInMillis = (j2 * DateUtils.MILLIS_PER_HOUR) + calendar.getTimeInMillis();
                        Calendar calendar2 = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Kolkata"));
                        calendar2.setTimeInMillis(timeInMillis);
                        Calendar calendar3 = (Calendar) calendar2.clone();
                        calendar3.add(6, 1);
                        calendar3.set(11, 0);
                        calendar3.set(12, 0);
                        calendar3.set(13, 0);
                        calendar3.set(14, 0);
                        calendar3.add(11, iNextInt);
                        long timeInMillis2 = (calendar3.getTimeInMillis() - calendar.getTimeInMillis()) / DateUtils.MILLIS_PER_HOUR;
                        return timeInMillis2 - j2 > 24 ? timeInMillis2 - 24 : timeInMillis2;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return j2;
            }
        }
        return j2;
    }

    public static boolean e(Context context) {
        String strA = a(context);
        if (strA != null) {
            try {
                JSONObject jSONObject = new JSONObject(strA);
                if (jSONObject.has("isEnabled") && jSONObject.optBoolean("isEnabled", false)) {
                    if (c(context)) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
