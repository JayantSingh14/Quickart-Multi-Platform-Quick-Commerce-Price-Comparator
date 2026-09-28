package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzfxh extends zzfwv {

    /* renamed from: a, reason: collision with root package name */
    public zzgqs f31985a;

    /* renamed from: b, reason: collision with root package name */
    public zzgqs f31986b;

    /* renamed from: c, reason: collision with root package name */
    public zzfwx f31987c;

    /* renamed from: d, reason: collision with root package name */
    public HttpURLConnection f31988d;

    public final HttpURLConnection a(zzfwx zzfwxVar) throws IOException {
        this.f31985a = new zzfxe();
        this.f31986b = new zzfxf();
        this.f31987c = zzfwxVar;
        ((Integer) this.f31986b.zza()).getClass();
        zzfws zzfwsVar = zzfww.f31980a;
        zzfwx zzfwxVar2 = this.f31987c;
        zzfwxVar2.getClass();
        Set set = zzcha.f26223f;
        zzcdu zzcduVar = com.google.android.gms.ads.internal.zzt.C.q;
        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Y)).intValue();
        URL url = new URL(((zzcgz) zzfwxVar2).f26218a);
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 > 20) {
                throw new IOException("Too many redirects (20)");
            }
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
            uRLConnectionOpenConnection.setReadTimeout(iIntValue);
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                throw new IOException("Invalid protocol.");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(0);
            zzlVar.a(httpURLConnection, null);
            httpURLConnection.setInstanceFollowRedirects(false);
            int responseCode = httpURLConnection.getResponseCode();
            zzlVar.c(httpURLConnection, responseCode);
            if (responseCode / 100 != 3) {
                this.f31988d = httpURLConnection;
                return httpURLConnection;
            }
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                throw new IOException("Missing Location header in redirect");
            }
            URL url2 = new URL(url, headerField);
            String protocol = url2.getProtocol();
            if (protocol == null) {
                throw new IOException("Protocol is null");
            }
            if (!protocol.equals("http") && !protocol.equals("https")) {
                throw new IOException("Unsupported scheme: ".concat(protocol));
            }
            String strConcat = "Redirecting to ".concat(headerField);
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a(strConcat);
            httpURLConnection.disconnect();
            url = url2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        HttpURLConnection httpURLConnection = this.f31988d;
        zzfws zzfwsVar = zzfww.f31980a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
