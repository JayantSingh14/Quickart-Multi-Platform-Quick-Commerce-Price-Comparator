package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbxv;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: classes4.dex */
public final class zzu implements zze {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21448a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21449b;

    /* renamed from: c, reason: collision with root package name */
    public String f21450c;

    public zzu(Context context, String str) {
        this.f21448a = context;
        this.f21449b = str;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zze
    public final zzt a(String str) {
        return b(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x016f A[PHI: r0
      0x016f: PHI (r0v3 com.google.android.gms.ads.internal.util.client.zzt) = 
      (r0v1 com.google.android.gms.ads.internal.util.client.zzt)
      (r0v0 com.google.android.gms.ads.internal.util.client.zzt)
      (r0v4 com.google.android.gms.ads.internal.util.client.zzt)
     binds: [B:63:0x016d, B:59:0x0163, B:49:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.ads.internal.util.client.zzt b(java.lang.String r11, java.util.HashMap r12) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.zzu.b(java.lang.String, java.util.HashMap):com.google.android.gms.ads.internal.util.client.zzt");
    }

    public final URL c(String str) throws MalformedURLException {
        URL url = null;
        try {
            url = new URI(str).toURL();
        } catch (IllegalArgumentException e2) {
            e = e2;
            d(str, e);
        } catch (MalformedURLException e3) {
            e = e3;
            d(str, e);
        } catch (URISyntaxException e4) {
            d(str, e4);
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.f25016f)).booleanValue()) {
                try {
                    zzo.a("Attempting to parse components, encode, and reconstruct URI.");
                    URL url2 = new URL(str);
                    URI uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
                    url = uri.toURL();
                    String string = uri.toString();
                    StringBuilder sb = new StringBuilder(str.length() + 114 + string.length());
                    sb.append("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"");
                    sb.append(str);
                    sb.append("\" -> encoded URI: ");
                    sb.append(string);
                    zzo.a(sb.toString());
                } catch (IllegalArgumentException | MalformedURLException | URISyntaxException e5) {
                    d(str, e5);
                }
            }
        }
        if (url != null) {
            return url;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 47);
        sb2.append("Falling back to direct new URL(\"");
        sb2.append(str);
        sb2.append("\") constructor.");
        zzo.a(sb2.toString());
        return new URL(str);
    }

    public final void d(String str, Exception exc) {
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(str.length() + 32 + String.valueOf(message).length());
        sb.append("Error while parsing ping URL: ");
        sb.append(str);
        sb.append(". ");
        sb.append(message);
        zzo.f(sb.toString());
        zzbxv.c(this.f21448a).b(exc, "HttpUrlPinger.pingUrl", ((Integer) zzbd.f21150e.f21153c.a(zzbgk.Rd)).intValue() / 100.0f);
    }
}
