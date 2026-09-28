package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhm extends zzgt implements zzhu {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f34011e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34012f;

    /* renamed from: g, reason: collision with root package name */
    public final int f34013g;

    /* renamed from: h, reason: collision with root package name */
    public final String f34014h;

    /* renamed from: i, reason: collision with root package name */
    public final zzht f34015i;

    /* renamed from: j, reason: collision with root package name */
    public final zzht f34016j;

    /* renamed from: k, reason: collision with root package name */
    public zzhf f34017k;

    /* renamed from: l, reason: collision with root package name */
    public HttpURLConnection f34018l;

    /* renamed from: m, reason: collision with root package name */
    public InputStream f34019m;
    public boolean n;
    public int o;
    public long p;
    public long q;

    public /* synthetic */ zzhm(String str, int i2, int i3, boolean z, zzht zzhtVar) {
        super(true);
        this.f34014h = str;
        this.f34012f = i2;
        this.f34013g = i3;
        this.f34011e = z;
        this.f34015i = zzhtVar;
        this.f34016j = new zzht();
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c5 A[Catch: IOException -> 0x01d0, TRY_LEAVE, TryCatch #5 {IOException -> 0x01d0, blocks: (B:82:0x01bd, B:84:0x01c5), top: B:161:0x01bd }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01dd  */
    @Override // com.google.android.gms.internal.ads.zzhb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(com.google.android.gms.internal.ads.zzhf r30) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.a(com.google.android.gms.internal.ads.zzhf):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b A[Catch: IOException -> 0x001e, TRY_LEAVE, TryCatch #0 {IOException -> 0x001e, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:13:0x0020, B:16:0x002b), top: B:20:0x0004 }] */
    @Override // com.google.android.gms.internal.ads.zzj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(int r7, byte[] r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            return r7
        L4:
            long r0 = r6.p     // Catch: java.io.IOException -> L1e
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L20
            long r4 = r6.q     // Catch: java.io.IOException -> L1e
            long r0 = r0 - r4
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L17
            goto L2a
        L17:
            long r4 = (long) r9     // Catch: java.io.IOException -> L1e
            long r0 = java.lang.Math.min(r4, r0)     // Catch: java.io.IOException -> L1e
            int r9 = (int) r0     // Catch: java.io.IOException -> L1e
            goto L20
        L1e:
            r7 = move-exception
            goto L35
        L20:
            java.io.InputStream r0 = r6.f34019m     // Catch: java.io.IOException -> L1e
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfj.f31254a     // Catch: java.io.IOException -> L1e
            int r7 = r0.read(r8, r7, r9)     // Catch: java.io.IOException -> L1e
            if (r7 != r3) goto L2b
        L2a:
            return r3
        L2b:
            long r8 = r6.q     // Catch: java.io.IOException -> L1e
            long r0 = (long) r7     // Catch: java.io.IOException -> L1e
            long r8 = r8 + r0
            r6.q = r8     // Catch: java.io.IOException -> L1e
            r6.f(r7)     // Catch: java.io.IOException -> L1e
            return r7
        L35:
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfj.f31254a
            r8 = 2
            com.google.android.gms.internal.ads.zzhq r7 = com.google.android.gms.internal.ads.zzhq.a(r7, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.b(int, byte[], int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.net.HttpURLConnection h(java.net.URL r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r4 = this;
            java.net.URLConnection r5 = r5.openConnection()
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5
            int r0 = r4.f34012f
            r5.setConnectTimeout(r0)
            int r0 = r4.f34013g
            r5.setReadTimeout(r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.google.android.gms.internal.ads.zzht r1 = r4.f34015i
            java.util.Map r1 = r1.a()
            r0.putAll(r1)
            com.google.android.gms.internal.ads.zzht r1 = r4.f34016j
            java.util.Map r1 = r1.a()
            r0.putAll(r1)
            r0.putAll(r12)
            java.util.Set r12 = r0.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L32:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L4e
            java.lang.Object r0 = r12.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r5.setRequestProperty(r1, r0)
            goto L32
        L4e:
            r0 = 0
            int r12 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            r2 = -1
            if (r12 != 0) goto L5d
            int r6 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r6 != 0) goto L5c
            r6 = 0
            goto L72
        L5c:
            r6 = r0
        L5d:
            java.lang.String r12 = "bytes="
            java.lang.String r0 = "-"
            java.lang.StringBuilder r12 = android.support.v4.media.b.v(r6, r12, r0)
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 == 0) goto L6e
            long r6 = r6 + r8
            long r6 = r6 + r2
            r12.append(r6)
        L6e:
            java.lang.String r6 = r12.toString()
        L72:
            if (r6 == 0) goto L79
            java.lang.String r7 = "Range"
            r5.setRequestProperty(r7, r6)
        L79:
            java.lang.String r6 = r4.f34014h
            if (r6 == 0) goto L82
            java.lang.String r7 = "User-Agent"
            r5.setRequestProperty(r7, r6)
        L82:
            r6 = 1
            if (r6 == r10) goto L88
            java.lang.String r6 = "identity"
            goto L8a
        L88:
            java.lang.String r6 = "gzip"
        L8a:
            java.lang.String r7 = "Accept-Encoding"
            r5.setRequestProperty(r7, r6)
            r5.setInstanceFollowRedirects(r11)
            r6 = 0
            r5.setDoOutput(r6)
            int r6 = com.google.android.gms.internal.ads.zzhf.f33690f
            java.lang.String r6 = "GET"
            r5.setRequestMethod(r6)
            r5.connect()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.h(java.net.URL, long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    public final URL i(URL url, String str) throws zzhq {
        if (str == null) {
            throw new zzhq("Null location redirect", 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new zzhq("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), 2001, 1);
            }
            if (this.f34011e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            String protocol2 = url.getProtocol();
            StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(androidx.fragment.app.e.g(40, protocol2), 1, protocol));
            sb.append("Disallowed cross-protocol redirect (");
            sb.append(protocol2);
            sb.append(" to ");
            sb.append(protocol);
            sb.append(")");
            throw new zzhq(sb.toString(), 2001, 1);
        } catch (MalformedURLException e2) {
            throw new zzhq(2001, 1, e2);
        }
    }

    public final void j() {
        HttpURLConnection httpURLConnection = this.f34018l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                zzee.f("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.f34018l;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        zzhf zzhfVar = this.f34017k;
        if (zzhfVar != null) {
            return zzhfVar.f33691a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        try {
            InputStream inputStream = this.f34019m;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    String str = zzfj.f31254a;
                    throw new zzhq(2000, 3, e2);
                }
            }
        } finally {
            this.f34019m = null;
            j();
            if (this.n) {
                this.n = false;
                g();
            }
            this.f34018l = null;
            this.f34017k = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.f34018l;
        return httpURLConnection == null ? zzgvd.f33244g : new zzhl(httpURLConnection.getHeaderFields());
    }
}
