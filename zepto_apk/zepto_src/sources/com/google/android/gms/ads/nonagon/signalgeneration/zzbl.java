package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzdjd;

/* loaded from: classes4.dex */
public final class zzbl implements zzdjd {

    /* renamed from: a, reason: collision with root package name */
    public final zzb f21862a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21863b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21864c;

    public zzbl(zzb zzbVar, int i2, String str) {
        this.f21862a = zzbVar;
        this.f21863b = i2;
        this.f21864c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void a(final zzbj zzbjVar) {
        if (zzbjVar == null || this.f21863b != 2 || TextUtils.isEmpty(this.f21864c)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbk
            /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    r8 = this;
                    com.google.android.gms.ads.nonagon.signalgeneration.zzbl r0 = r8.f21860a
                    com.google.android.gms.ads.nonagon.signalgeneration.zzbj r1 = r2
                    com.google.android.gms.ads.nonagon.signalgeneration.zzb r2 = r0.f21862a
                    java.lang.String r0 = r0.f21864c
                    r2.getClass()
                    boolean r3 = android.text.TextUtils.isEmpty(r0)
                    if (r3 != 0) goto L9e
                    boolean r3 = r2.a()
                    if (r3 == 0) goto L19
                    goto L9e
                L19:
                    org.json.JSONObject r3 = new org.json.JSONObject
                    r3.<init>()
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L49
                    r4.<init>()     // Catch: org.json.JSONException -> L49
                    java.lang.String r5 = "params"
                    java.lang.String r6 = r1.f21852a     // Catch: org.json.JSONException -> L49
                    r4.put(r5, r6)     // Catch: org.json.JSONException -> L49
                    java.lang.String r5 = "signal_dictionary"
                    com.google.android.gms.ads.internal.client.zzbb r6 = com.google.android.gms.ads.internal.client.zzbb.f21141g     // Catch: org.json.JSONException -> L49
                    com.google.android.gms.ads.internal.util.client.zzf r6 = r6.f21142a     // Catch: org.json.JSONException -> L49
                    android.os.Bundle r7 = r1.f21857f     // Catch: org.json.JSONException -> L49
                    org.json.JSONObject r6 = r6.m(r7)     // Catch: org.json.JSONException -> L49
                    r4.put(r5, r6)     // Catch: org.json.JSONException -> L49
                    java.lang.String r5 = "sr"
                    r3.put(r5, r4)     // Catch: org.json.JSONException -> L49
                    java.lang.String r1 = r1.f21854c     // Catch: org.json.JSONException -> L49
                    boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> L49
                    if (r4 == 0) goto L4b
                    java.lang.String r1 = ""
                    goto L82
                L49:
                    r1 = move-exception
                    goto L75
                L4b:
                    if (r1 != 0) goto L50
                    java.lang.String r1 = ""
                    goto L56
                L50:
                    java.lang.String r4 = "f8L7o2HxjA4p9Z1nQw3E5r6T8yU2iCv0B9kM4sD1f7G3hJ5lK2z0X9cW8vQ6b5N3m1Rg8F2o0Lp7A1e9I4u3Y2t0H8x6W5v4Z1n9Q2w7E3r5T8y6U1i0C9vB8k7M4s3D1f2G0h9J5l8K4z7X3cW2v1Q0b9N8m6A5r4F3o2Lp1E0u9I8y7Y6t5H4x3W2v1Z0n9Q8w7E6r5T4y3U2i1C0v9B8k7M6s5D4f3G2h1J0l9K8z7X6cW5v4Q3b2N1m0Rg9F8o7Lp6A5e4I3u2Y1t0H8x7W6v5Z4n3Q2w1E0r9T8y7U6i5C4v3B2k1M0s9D8f7G6h5J4l3K2z1X0cW9v8Q7b6N5m4A3r2F1o0Lp9E8u7I6y5T4h3W2v1Z0n0Q9w8E7r6T5y4U3i2C1v0B9k8M7s6D5f4G3h2J1l0K9z8X7cW6v5Q4b3N2m1R0g9F8o7L6p5A4e3I2u1Y0t9H8x7W6v5Z4n3Q2w1E0r9T8y7U6i5C4v3B2k1M0s9D8f7G6h5J4l3K2z1X0cW9v8Q7b6N5m4A3r2F1o0Lp9E8u7I6y5T4h3W2"
                    java.lang.String r1 = com.google.android.gms.ads.internal.util.zzs.K(r1, r4)     // Catch: org.json.JSONException -> L49
                L56:
                    java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch: org.json.JSONException -> L49
                    byte[] r1 = r1.getBytes(r4)     // Catch: org.json.JSONException -> L49
                    r4 = 10
                    java.lang.String r1 = android.util.Base64.encodeToString(r1, r4)     // Catch: org.json.JSONException -> L49
                    java.lang.String r4 = "rs"
                    r3.put(r4, r1)     // Catch: org.json.JSONException -> L49
                    java.lang.String r1 = "ts_ms"
                    com.google.android.gms.ads.internal.zzt r4 = com.google.android.gms.ads.internal.zzt.C     // Catch: org.json.JSONException -> L49
                    com.google.android.gms.common.util.Clock r4 = r4.f21687k     // Catch: org.json.JSONException -> L49
                    long r4 = r4.currentTimeMillis()     // Catch: org.json.JSONException -> L49
                    r3.put(r1, r4)     // Catch: org.json.JSONException -> L49
                    goto L7e
                L75:
                    java.lang.String r4 = "DiskCachingManager.createStringToWrite"
                    com.google.android.gms.ads.internal.zzt r5 = com.google.android.gms.ads.internal.zzt.C
                    com.google.android.gms.internal.ads.zzcda r5 = r5.f21684h
                    r5.d(r4, r1)
                L7e:
                    java.lang.String r1 = r3.toString()
                L82:
                    boolean r3 = android.text.TextUtils.isEmpty(r1)
                    if (r3 != 0) goto L9e
                    com.google.android.gms.ads.nonagon.signalgeneration.zzd r2 = r2.f21828b
                    r2.e()
                    java.lang.Object r3 = r2.f21890d
                    monitor-enter(r3)
                    android.content.SharedPreferences$Editor r2 = r2.f21888b     // Catch: java.lang.Throwable -> L9b
                    android.content.SharedPreferences$Editor r0 = r2.putString(r0, r1)     // Catch: java.lang.Throwable -> L9b
                    r0.commit()     // Catch: java.lang.Throwable -> L9b
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L9b
                    goto L9e
                L9b:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L9b
                    throw r0
                L9e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzbk.run():void");
            }
        };
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzcdo.f25982a.execute(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void q(String str) {
    }
}
