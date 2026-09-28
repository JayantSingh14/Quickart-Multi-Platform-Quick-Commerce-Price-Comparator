package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import coil3.network.internal.UtilsKt;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzl {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f21430c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f21431d = false;

    /* renamed from: a, reason: collision with root package name */
    public final List f21434a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f21429b = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final Clock f21432e = DefaultClock.getInstance();

    /* renamed from: f, reason: collision with root package name */
    public static final HashSet f21433f = new HashSet(Arrays.asList(new String[0]));

    public zzl() {
        throw null;
    }

    public static boolean e() {
        boolean z;
        synchronized (f21429b) {
            try {
                z = false;
                if (f21430c && f21431d) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public static void h(JsonWriter jsonWriter, Map map) {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (!f21433f.contains(str)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        zzo.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name(CLConstants.FIELD_PAY_INFO_NAME).value(str);
                    jsonWriter.name(CLConstants.FIELD_PAY_INFO_VALUE).value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name(CLConstants.FIELD_PAY_INFO_NAME).value(str);
                        jsonWriter.name(CLConstants.FIELD_PAY_INFO_VALUE).value(str2);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    public final void a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        if (e()) {
            i("onNetworkRequest", new zzj(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr));
        }
    }

    public final void b(String str, Map map, byte[] bArr) throws IOException {
        if (e()) {
            i("onNetworkRequest", new zzj(str, UtilsKt.HTTP_METHOD_GET, map, bArr));
        }
    }

    public final void c(HttpURLConnection httpURLConnection, int i2) throws IOException {
        if (e()) {
            String responseMessage = null;
            f(i2, httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()));
            if (i2 < 200 || i2 >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    zzo.f("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e2.getMessage())));
                }
                g(responseMessage);
            }
        }
    }

    public final void d(final byte[] bArr) throws IOException {
        i("onNetworkResponseBody", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzh
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final void a(JsonWriter jsonWriter) throws NoSuchAlgorithmException, IOException {
                Object obj = zzl.f21429b;
                jsonWriter.name("params").beginObject();
                byte[] bArr2 = bArr;
                int length = bArr2.length;
                String strEncode = Base64Utils.encode(bArr2);
                if (length < 10000) {
                    jsonWriter.name("body").value(strEncode);
                } else {
                    String strD = zzf.d(strEncode, MessageDigestAlgorithms.MD5);
                    if (strD != null) {
                        jsonWriter.name("bodydigest").value(strD);
                    }
                }
                jsonWriter.name("bodylength").value(length);
                jsonWriter.endObject();
            }
        });
    }

    public final void f(final int i2, final Map map) throws IOException {
        i("onNetworkResponse", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzg
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
                Object obj = zzl.f21429b;
                jsonWriter.name("params").beginObject();
                jsonWriter.name("firstline").beginObject();
                jsonWriter.name("code").value(i2);
                jsonWriter.endObject();
                zzl.h(jsonWriter, map);
                jsonWriter.endObject();
            }
        });
    }

    public final void g(final String str) throws IOException {
        i("onNetworkRequestError", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzi
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
                Object obj = zzl.f21429b;
                jsonWriter.name("params").beginObject();
                String str2 = str;
                if (str2 != null) {
                    jsonWriter.name(AuthorizationResponseParser.ERROR_DESCRIPTION).value(str2);
                }
                jsonWriter.endObject();
            }
        });
    }

    public final void i(String str, zzk zzkVar) throws IOException {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(f21432e.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator it = this.f21434a.iterator();
            while (it.hasNext()) {
                jsonWriter.value((String) it.next());
            }
            jsonWriter.endArray();
            zzkVar.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzo.d("unable to log", e2);
        }
        String string = stringWriter.toString();
        synchronized (zzl.class) {
            try {
                zzo.e("GMA Debug BEGIN");
                int i2 = 0;
                while (i2 < string.length()) {
                    int i3 = i2 + 4000;
                    zzo.e("GMA Debug CONTENT ".concat(String.valueOf(string.substring(i2, Math.min(i3, string.length())))));
                    i2 = i3;
                }
                zzo.e("GMA Debug FINISH");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzl(int i2) {
        this.f21434a = !e() ? new ArrayList() : Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
    }
}
