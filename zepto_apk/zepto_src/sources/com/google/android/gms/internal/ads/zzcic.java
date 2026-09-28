package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import coil3.network.internal.UtilsKt;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class zzcic extends zzgt implements zzhu {
    public static final Pattern v = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: e, reason: collision with root package name */
    public final int f26316e;

    /* renamed from: f, reason: collision with root package name */
    public final int f26317f;

    /* renamed from: g, reason: collision with root package name */
    public final String f26318g;

    /* renamed from: h, reason: collision with root package name */
    public final zzht f26319h;

    /* renamed from: i, reason: collision with root package name */
    public zzhf f26320i;

    /* renamed from: j, reason: collision with root package name */
    public HttpURLConnection f26321j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayDeque f26322k;

    /* renamed from: l, reason: collision with root package name */
    public InputStream f26323l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26324m;
    public int n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public final long t;
    public final long u;

    public zzcic(String str, zzchz zzchzVar, int i2, int i3, long j2, long j3) {
        super(true);
        zzgqa.a(true ^ TextUtils.isEmpty(str));
        this.f26318g = str;
        this.f26319h = new zzht();
        this.f26316e = i2;
        this.f26317f = i3;
        this.f26322k = new ArrayDeque();
        this.t = j2;
        this.u = j3;
        if (zzchzVar != null) {
            c(zzchzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws IOException, NumberFormatException {
        this.f26320i = zzhfVar;
        this.p = 0L;
        long j2 = zzhfVar.f33693c;
        long j3 = zzhfVar.f33694d;
        long jMin = this.t;
        if (j3 != -1) {
            jMin = Math.min(jMin, j3);
        }
        this.q = j2;
        HttpURLConnection httpURLConnectionH = h(j2, (jMin + j2) - 1, 1);
        this.f26321j = httpURLConnectionH;
        String headerField = httpURLConnectionH.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = v.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j4 = Long.parseLong(matcher.group(2));
                    long j5 = Long.parseLong(matcher.group(3));
                    if (j3 != -1) {
                        this.o = j3;
                        this.r = Math.max(j4, (this.q + j3) - 1);
                    } else {
                        this.o = j5 - this.q;
                        this.r = j5 - 1;
                    }
                    this.s = j4;
                    this.f26324m = true;
                    e(zzhfVar);
                    return this.o;
                } catch (NumberFormatException unused) {
                    String strS = android.support.v4.media.b.s(new StringBuilder(String.valueOf(headerField).length() + 27), "Unexpected Content-Range [", headerField, "]");
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.c(strS);
                }
            }
        }
        throw new zzcia("Invalid content range: ".concat(String.valueOf(headerField)), 2000, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        try {
            long j2 = this.o;
            long j3 = this.p;
            if (j2 - j3 == 0) {
                return -1;
            }
            long j4 = this.q + j3;
            long j5 = i3;
            long j6 = j4 + j5 + this.u;
            long j7 = this.s;
            long j8 = j7 + 1;
            if (j6 > j8) {
                long j9 = this.r;
                if (j7 < j9) {
                    long jMin = Math.min(j9, Math.max(((this.t + j8) - r4) - 1, (j8 + j5) - 1));
                    h(j8, jMin, 2);
                    this.s = jMin;
                    j7 = jMin;
                }
            }
            int i4 = this.f26323l.read(bArr, i2, (int) Math.min(j5, ((j7 + 1) - this.q) - this.p));
            if (i4 == -1) {
                throw new EOFException();
            }
            this.p += i4;
            f(i4);
            return i4;
        } catch (IOException e2) {
            throw new zzhq(2000, 2, e2);
        }
    }

    public final HttpURLConnection h(long j2, long j3, int i2) throws IOException {
        String string = this.f26320i.f33691a.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.f26316e);
            httpURLConnection.setReadTimeout(this.f26317f);
            for (Map.Entry entry : this.f26319h.a().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 7 + String.valueOf(j3).length());
            sb.append("bytes=");
            sb.append(j2);
            sb.append("-");
            sb.append(j3);
            httpURLConnection.setRequestProperty("Range", sb.toString());
            httpURLConnection.setRequestProperty("User-Agent", this.f26318g);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod(UtilsKt.HTTP_METHOD_GET);
            httpURLConnection.connect();
            this.f26322k.add(httpURLConnection);
            String string2 = this.f26320i.f33691a.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.n = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    httpURLConnection.getHeaderFields();
                    i();
                    int i3 = this.n;
                    throw new zzcib(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 15), i3, "Response code: "), 2000, i2);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.f26323l != null) {
                        inputStream = new SequenceInputStream(this.f26323l, inputStream);
                    }
                    this.f26323l = inputStream;
                    return httpURLConnection;
                } catch (IOException e2) {
                    i();
                    throw new zzhq(2000, i2, e2);
                }
            } catch (IOException e3) {
                i();
                throw new zzhq("Unable to connect to ".concat(String.valueOf(string2)), e3, 2000, i2);
            }
        } catch (IOException e4) {
            throw new zzhq("Unable to connect to ".concat(String.valueOf(string)), e4, 2000, i2);
        }
    }

    public final void i() {
        while (true) {
            ArrayDeque arrayDeque = this.f26322k;
            if (arrayDeque.isEmpty()) {
                this.f26321j = null;
                return;
            }
            try {
                ((HttpURLConnection) arrayDeque.remove()).disconnect();
            } catch (Exception e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unexpected error while disconnecting", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.f26321j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        try {
            InputStream inputStream = this.f26323l;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    throw new zzhq(2000, 3, e2);
                }
            }
        } finally {
            this.f26323l = null;
            i();
            if (this.f26324m) {
                this.f26324m = false;
                g();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.f26321j;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }
}
