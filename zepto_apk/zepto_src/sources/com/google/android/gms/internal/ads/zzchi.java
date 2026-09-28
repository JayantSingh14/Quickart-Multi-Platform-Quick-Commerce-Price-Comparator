package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
final class zzchi extends zzgt implements zzhu {
    public static final Pattern t = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference u = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final SSLSocketFactory f26252e;

    /* renamed from: f, reason: collision with root package name */
    public final int f26253f;

    /* renamed from: g, reason: collision with root package name */
    public final int f26254g;

    /* renamed from: h, reason: collision with root package name */
    public final String f26255h;

    /* renamed from: i, reason: collision with root package name */
    public final zzht f26256i;

    /* renamed from: j, reason: collision with root package name */
    public HttpURLConnection f26257j;

    /* renamed from: k, reason: collision with root package name */
    public InputStream f26258k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26259l;

    /* renamed from: m, reason: collision with root package name */
    public int f26260m;
    public long n;
    public long o;
    public long p;
    public long q;
    public int r;
    public final HashSet s;

    public zzchi(String str, zzchz zzchzVar, int i2, int i3, int i4) {
        super(true);
        this.f26252e = new zzchh(this);
        this.s = new HashSet();
        zzgqa.a(true ^ TextUtils.isEmpty(str));
        this.f26255h = str;
        this.f26256i = new zzht();
        this.f26253f = i2;
        this.f26254g = i3;
        this.r = i4;
        if (zzchzVar != null) {
            c(zzchzVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0265 A[Catch: IOException -> 0x0038, TryCatch #1 {IOException -> 0x0038, blocks: (B:3:0x000d, B:4:0x001b, B:6:0x0021, B:8:0x002f, B:11:0x003b, B:12:0x0053, B:14:0x0059, B:23:0x008f, B:25:0x00b3, B:26:0x00d4, B:27:0x00d9, B:40:0x010f, B:90:0x0258, B:92:0x0265, B:94:0x0278, B:97:0x0281, B:98:0x028e, B:100:0x0295, B:101:0x029c, B:102:0x029d, B:103:0x02ba), top: B:108:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzhb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(com.google.android.gms.internal.ads.zzhf r26) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchi.a(com.google.android.gms.internal.ads.zzhf):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[Catch: IOException -> 0x001b, TryCatch #0 {IOException -> 0x001b, blocks: (B:2:0x0000, B:23:0x0058, B:25:0x0060, B:28:0x006a, B:29:0x0070, B:31:0x0078, B:34:0x007f, B:35:0x0084, B:36:0x0085, B:5:0x000b, B:7:0x0016, B:10:0x001e, B:12:0x0026, B:15:0x003c, B:16:0x0046, B:17:0x004b, B:18:0x004c, B:19:0x0051, B:20:0x0052), top: B:40:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: IOException -> 0x001b, TRY_LEAVE, TryCatch #0 {IOException -> 0x001b, blocks: (B:2:0x0000, B:23:0x0058, B:25:0x0060, B:28:0x006a, B:29:0x0070, B:31:0x0078, B:34:0x007f, B:35:0x0084, B:36:0x0085, B:5:0x000b, B:7:0x0016, B:10:0x001e, B:12:0x0026, B:15:0x003c, B:16:0x0046, B:17:0x004b, B:18:0x004c, B:19:0x0051, B:20:0x0052), top: B:40:0x0000 }] */
    @Override // com.google.android.gms.internal.ads.zzj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(int r10, byte[] r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.p     // Catch: java.io.IOException -> L1b
            long r2 = r9.n     // Catch: java.io.IOException -> L1b
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = -1
            if (r0 != 0) goto Lb
            goto L55
        Lb:
            java.util.concurrent.atomic.AtomicReference r0 = com.google.android.gms.internal.ads.zzchi.u     // Catch: java.io.IOException -> L1b
            r3 = 0
            java.lang.Object r3 = r0.getAndSet(r3)     // Catch: java.io.IOException -> L1b
            byte[] r3 = (byte[]) r3     // Catch: java.io.IOException -> L1b
            if (r3 != 0) goto L1e
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L1b
            goto L1e
        L1b:
            r10 = move-exception
            goto L8f
        L1e:
            long r4 = r9.p     // Catch: java.io.IOException -> L1b
            long r6 = r9.n     // Catch: java.io.IOException -> L1b
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L52
            int r8 = r3.length     // Catch: java.io.IOException -> L1b
            long r6 = r6 - r4
            long r4 = (long) r8     // Catch: java.io.IOException -> L1b
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.io.IOException -> L1b
            int r4 = (int) r4     // Catch: java.io.IOException -> L1b
            java.io.InputStream r5 = r9.f26258k     // Catch: java.io.IOException -> L1b
            int r4 = r5.read(r3, r1, r4)     // Catch: java.io.IOException -> L1b
            boolean r5 = java.lang.Thread.interrupted()     // Catch: java.io.IOException -> L1b
            if (r5 != 0) goto L4c
            if (r4 == r2) goto L46
            long r5 = r9.p     // Catch: java.io.IOException -> L1b
            long r7 = (long) r4     // Catch: java.io.IOException -> L1b
            long r5 = r5 + r7
            r9.p = r5     // Catch: java.io.IOException -> L1b
            r9.f(r4)     // Catch: java.io.IOException -> L1b
            goto L1e
        L46:
            java.io.EOFException r10 = new java.io.EOFException     // Catch: java.io.IOException -> L1b
            r10.<init>()     // Catch: java.io.IOException -> L1b
            throw r10     // Catch: java.io.IOException -> L1b
        L4c:
            java.io.InterruptedIOException r10 = new java.io.InterruptedIOException     // Catch: java.io.IOException -> L1b
            r10.<init>()     // Catch: java.io.IOException -> L1b
            throw r10     // Catch: java.io.IOException -> L1b
        L52:
            r0.set(r3)     // Catch: java.io.IOException -> L1b
        L55:
            if (r12 != 0) goto L58
            return r1
        L58:
            long r0 = r9.o     // Catch: java.io.IOException -> L1b
            r3 = -1
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 == 0) goto L70
            long r5 = r9.q     // Catch: java.io.IOException -> L1b
            long r0 = r0 - r5
            r5 = 0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 != 0) goto L6a
            goto L7e
        L6a:
            long r5 = (long) r12     // Catch: java.io.IOException -> L1b
            long r0 = java.lang.Math.min(r5, r0)     // Catch: java.io.IOException -> L1b
            int r12 = (int) r0     // Catch: java.io.IOException -> L1b
        L70:
            java.io.InputStream r0 = r9.f26258k     // Catch: java.io.IOException -> L1b
            int r10 = r0.read(r11, r10, r12)     // Catch: java.io.IOException -> L1b
            if (r10 != r2) goto L85
            long r10 = r9.o     // Catch: java.io.IOException -> L1b
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 != 0) goto L7f
        L7e:
            return r2
        L7f:
            java.io.EOFException r10 = new java.io.EOFException     // Catch: java.io.IOException -> L1b
            r10.<init>()     // Catch: java.io.IOException -> L1b
            throw r10     // Catch: java.io.IOException -> L1b
        L85:
            long r11 = r9.q     // Catch: java.io.IOException -> L1b
            long r0 = (long) r10     // Catch: java.io.IOException -> L1b
            long r11 = r11 + r0
            r9.q = r11     // Catch: java.io.IOException -> L1b
            r9.f(r10)     // Catch: java.io.IOException -> L1b
            return r10
        L8f:
            com.google.android.gms.internal.ads.zzhq r11 = new com.google.android.gms.internal.ads.zzhq
            r12 = 2000(0x7d0, float:2.803E-42)
            r0 = 2
            r11.<init>(r12, r0, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchi.b(int, byte[], int):int");
    }

    public final void h() {
        HttpURLConnection httpURLConnection = this.f26257j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Unexpected error while disconnecting", e2);
            }
            this.f26257j = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.f26257j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        HashSet hashSet = this.s;
        try {
            InputStream inputStream = this.f26258k;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    throw new zzhq(2000, 3, e2);
                }
            }
        } finally {
            this.f26258k = null;
            h();
            if (this.f26259l) {
                this.f26259l = false;
                g();
            }
            hashSet.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.f26257j;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }
}
