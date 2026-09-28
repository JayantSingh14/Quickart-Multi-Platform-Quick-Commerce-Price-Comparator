package com.google.firebase.crashlytics.internal.network;

import android.support.v4.media.b;
import coil3.network.internal.UtilsKt;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class HttpGetRequest {

    /* renamed from: a, reason: collision with root package name */
    public final String f44370a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f44371b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f44372c = new HashMap();

    public HttpGetRequest(String str, HashMap map) {
        this.f44370a = str;
        this.f44371b = map;
    }

    public static String a(String str, HashMap map) {
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), "UTF-8") : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), "UTF-8") : "");
        }
        String string = sb.toString();
        if (string.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return b.l(str, "?", string);
        }
        if (!str.endsWith("&")) {
            string = "&".concat(string);
        }
        return b.k(str, string);
    }

    public final HttpResponse b() throws Throwable {
        HttpsURLConnection httpsURLConnection;
        CrashlyticsWorkers.b();
        InputStream inputStream = null;
        String string = null;
        inputStream = null;
        try {
            String strA = a(this.f44370a, this.f44371b);
            Logger.f43705a.e("GET Request URL: " + strA);
            httpsURLConnection = (HttpsURLConnection) new URL(strA).openConnection();
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod(UtilsKt.HTTP_METHOD_GET);
                for (Map.Entry entry : this.f44372c.entrySet()) {
                    httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                        char[] cArr = new char[KEYRecord.Flags.FLAG2];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int i2 = bufferedReader.read(cArr);
                            if (i2 == -1) {
                                break;
                            }
                            sb.append(cArr, 0, i2);
                        }
                        string = sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new HttpResponse(responseCode, string);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
    }

    public final void c(String str, String str2) {
        this.f44372c.put(str, str2);
    }
}
