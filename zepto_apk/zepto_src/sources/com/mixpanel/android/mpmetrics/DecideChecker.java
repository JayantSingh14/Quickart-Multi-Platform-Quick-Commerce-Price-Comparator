package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Build;
import android.support.v4.media.b;
import android.util.Log;
import com.mixpanel.android.util.HttpService;
import com.mixpanel.android.util.MPLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.HashMap;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class DecideChecker {

    /* renamed from: a, reason: collision with root package name */
    public final MPConfig f45986a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f45987b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f45988c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final SystemInformation f45989d;

    public static class Result {

        /* renamed from: a, reason: collision with root package name */
        public boolean f45990a = false;
    }

    public static class UnintelligibleMessageException extends Exception {
    }

    static {
        new JSONArray();
    }

    public DecideChecker(Context context, MPConfig mPConfig) {
        this.f45987b = context;
        this.f45986a = mPConfig;
        this.f45989d = SystemInformation.a(context);
    }

    public final Result a(String str, String str2, HttpService httpService) throws Throwable {
        SSLSocketFactory sSLSocketFactory;
        byte[] bArrC;
        String str3;
        try {
            String strEncode = URLEncoder.encode(str, "utf-8");
            Result result = null;
            String strEncode2 = str2 != null ? URLEncoder.encode(str2, "utf-8") : null;
            StringBuilder sb = new StringBuilder("?version=1&lib=android&token=");
            sb.append(strEncode);
            if (strEncode2 != null) {
                sb.append("&distinct_id=");
                sb.append(strEncode2);
            }
            sb.append("&properties=");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("$android_lib_version", "6.0.0");
                jSONObject.putOpt("$android_app_version", this.f45989d.f46091e);
                jSONObject.putOpt("$android_version", Build.VERSION.RELEASE);
                jSONObject.putOpt("$android_app_release", this.f45989d.f46092f);
                jSONObject.putOpt("$android_device_model", Build.MODEL);
                sb.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
            } catch (Exception e2) {
                MPLog.c("MixpanelAPI.DChecker", "Exception constructing properties JSON", e2.getCause());
            }
            String strR = b.r(new StringBuilder(), this.f45986a.f46009l, sb.toString());
            MPLog.e("MixpanelAPI.DChecker", "Querying decide server, url: " + strR);
            Context context = this.f45987b;
            MPConfig mPConfigB = MPConfig.b(context);
            synchronized (mPConfigB) {
            }
            if (httpService.b(context)) {
                try {
                    synchronized (mPConfigB) {
                        sSLSocketFactory = mPConfigB.p;
                    }
                    bArrC = httpService.c(strR, null, sSLSocketFactory);
                } catch (FileNotFoundException e3) {
                    String strD = b.D("Cannot get ", strR, ", file not found.");
                    if (MPLog.d(2)) {
                        Log.v("MixpanelAPI.DChecker", strD, e3);
                    }
                } catch (OutOfMemoryError e4) {
                    MPLog.c("MixpanelAPI.DChecker", "Out of memory when getting to " + strR + CLConstants.DOT_SALT_DELIMETER, e4);
                } catch (MalformedURLException e5) {
                    MPLog.c("MixpanelAPI.DChecker", "Cannot interpret " + strR + " as a URL.", e5);
                } catch (IOException e6) {
                    String strD2 = b.D("Cannot get ", strR, CLConstants.DOT_SALT_DELIMETER);
                    if (MPLog.d(2)) {
                        Log.v("MixpanelAPI.DChecker", strD2, e6);
                    }
                }
            } else {
                bArrC = null;
            }
            if (bArrC == null) {
                str3 = null;
            } else {
                try {
                    str3 = new String(bArrC, "UTF-8");
                } catch (UnsupportedEncodingException e7) {
                    throw new RuntimeException("UTF not supported on this platform?", e7);
                }
            }
            MPLog.e("MixpanelAPI.DChecker", "Mixpanel decide server response was:\n" + str3);
            if (str3 != null) {
                result = new Result();
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    if (jSONObject2.has("automatic_events")) {
                        try {
                            result.f45990a = jSONObject2.getBoolean("automatic_events");
                        } catch (JSONException unused) {
                            MPLog.b("MixpanelAPI.DChecker", "Mixpanel endpoint returned a non boolean value for automatic events: " + jSONObject2);
                        }
                    }
                } catch (JSONException e8) {
                    throw new UnintelligibleMessageException("Mixpanel endpoint returned unparsable result:\n".concat(str3), e8);
                }
            }
            return result;
        } catch (UnsupportedEncodingException e9) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", e9);
        }
    }

    public final void b(String str, HttpService httpService) throws Throwable {
        String str2;
        DecideMessages decideMessages = (DecideMessages) this.f45988c.get(str);
        if (decideMessages != null) {
            synchronized (decideMessages) {
                str2 = decideMessages.f45991a;
            }
            try {
                Result resultA = a(decideMessages.f45992b, str2, httpService);
                if (resultA != null) {
                    decideMessages.a(resultA.f45990a);
                }
            } catch (UnintelligibleMessageException e2) {
                MPLog.c("MixpanelAPI.DChecker", e2.getMessage(), e2);
            }
        }
    }
}
