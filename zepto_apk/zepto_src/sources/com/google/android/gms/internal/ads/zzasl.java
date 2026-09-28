package com.google.android.gms.internal.ads;

import coil3.network.internal.UtilsKt;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzasl extends zzary {
    public zzasl() {
        throw null;
    }

    public static ArrayList b(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzarc((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    public final zzasi a(zzark zzarkVar, Map map) throws Throwable {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(zzarkVar.e());
        URL url = new URL(zzarkVar.f24215c);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i2 = zzarkVar.f24224l.f24190a;
        httpURLConnection.setConnectTimeout(i2);
        httpURLConnection.setReadTimeout(i2);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        url.getProtocol();
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            if (zzarkVar.f24214b != 0) {
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrG = zzarkVar.g();
                if (bArrG != null) {
                    httpURLConnection.setDoOutput(true);
                    if (!httpURLConnection.getRequestProperties().containsKey(UtilsKt.CONTENT_TYPE)) {
                        httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
                    }
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArrG);
                    dataOutputStream.close();
                }
            } else {
                httpURLConnection.setRequestMethod(UtilsKt.HTTP_METHOD_GET);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if ((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                zzasi zzasiVar = new zzasi(responseCode, b(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return zzasiVar;
            }
            try {
                return new zzasi(responseCode, b(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new zzasj(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
