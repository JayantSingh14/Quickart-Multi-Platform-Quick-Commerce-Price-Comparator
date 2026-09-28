package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* loaded from: classes4.dex */
class zzfzi {

    /* renamed from: h, reason: collision with root package name */
    public static final String f32094h = new UUID(0, 0).toString();

    /* renamed from: a, reason: collision with root package name */
    public final String f32095a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32096b;

    /* renamed from: c, reason: collision with root package name */
    public final String f32097c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32098d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32099e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfzh f32100f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfzg f32101g;

    public zzfzi(Context context, String str, String str2, String str3) {
        if (zzfzh.f32091c == null) {
            zzfzh.f32091c = new zzfzh(context);
        }
        this.f32100f = zzfzh.f32091c;
        this.f32101g = zzfzg.a(context);
        this.f32095a = str;
        this.f32096b = str.concat("_3p");
        this.f32097c = str2;
        this.f32098d = str2.concat("_3p");
        this.f32099e = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzfzf a(java.lang.String r17, java.lang.String r18, long r19, boolean r21) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = r0.f32096b
            r3 = 0
            com.google.android.gms.internal.ads.zzfzh r4 = r0.f32100f
            if (r1 == 0) goto L3b
            java.util.UUID.fromString(r1)     // Catch: java.lang.IllegalArgumentException -> L3e
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfzi.f32094h
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L17
            goto L3e
        L17:
            android.content.SharedPreferences r5 = r4.f32093b
            java.lang.String r5 = r5.getString(r2, r3)
            android.content.SharedPreferences r6 = r4.f32093b
            java.lang.String r7 = "paid_3p_hash_key"
            java.lang.String r6 = r6.getString(r7, r3)
            if (r5 == 0) goto L3b
            if (r6 == 0) goto L3b
            r7 = r18
            java.lang.String r6 = r0.e(r1, r7, r6)
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L36
            goto L44
        L36:
            com.google.android.gms.internal.ads.zzfzf r1 = r16.b(r17, r18)
            return r1
        L3b:
            r7 = r18
            goto L44
        L3e:
            com.google.android.gms.internal.ads.zzfzf r1 = new com.google.android.gms.internal.ads.zzfzf
            r1.<init>()
            return r1
        L44:
            if (r1 == 0) goto L48
            r5 = 1
            goto L49
        L48:
            r5 = 0
        L49:
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 < 0) goto La8
            java.lang.String r6 = r0.f32097c
            java.lang.String r10 = r0.f32098d
            if (r5 == 0) goto L5b
            r11 = r10
            goto L5c
        L5b:
            r11 = r6
        L5c:
            android.content.SharedPreferences r12 = r4.f32093b
            r13 = -1
            long r11 = r12.getLong(r11, r13)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 != 0) goto L69
            goto L85
        L69:
            int r15 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r15 >= 0) goto L7a
            if (r5 == 0) goto L71
            r11 = r10
            goto L72
        L71:
            r11 = r6
        L72:
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r4.a(r8, r11)
            goto L85
        L7a:
            long r11 = r11 + r19
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 < 0) goto L85
            com.google.android.gms.internal.ads.zzfzf r1 = r16.b(r17, r18)
            return r1
        L85:
            if (r5 == 0) goto L88
            goto L8a
        L88:
            java.lang.String r2 = r0.f32095a
        L8a:
            android.content.SharedPreferences r8 = r4.f32093b
            java.lang.String r2 = r8.getString(r2, r3)
            if (r2 != 0) goto L99
            if (r21 != 0) goto L99
            com.google.android.gms.internal.ads.zzfzf r1 = r16.b(r17, r18)
            return r1
        L99:
            com.google.android.gms.internal.ads.zzfzf r1 = new com.google.android.gms.internal.ads.zzfzf
            if (r5 == 0) goto L9e
            r6 = r10
        L9e:
            android.content.SharedPreferences r3 = r4.f32093b
            long r3 = r3.getLong(r6, r13)
            r1.<init>(r2, r3)
            return r1
        La8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = r0.f32099e
            java.lang.String r3 = ": Invalid negative current timestamp. Updating PAID failed"
            java.lang.String r2 = r2.concat(r3)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfzi.a(java.lang.String, java.lang.String, long, boolean):com.google.android.gms.internal.ads.zzfzf");
    }

    public final zzfzf b(String str, String str2) throws IOException {
        if (str == null) {
            return d(UUID.randomUUID().toString(), false);
        }
        String string = UUID.randomUUID().toString();
        this.f32100f.a(string, "paid_3p_hash_key");
        return d(e(str, str2, string), true);
    }

    public final void c(boolean z) throws IOException {
        String str = z ? this.f32098d : this.f32097c;
        zzfzh zzfzhVar = this.f32100f;
        zzfzhVar.b(str);
        zzfzhVar.b(z ? this.f32096b : this.f32095a);
    }

    public final zzfzf d(String str, boolean z) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.f32099e.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        String str2 = z ? this.f32098d : this.f32097c;
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        zzfzh zzfzhVar = this.f32100f;
        zzfzhVar.a(lValueOf, str2);
        zzfzhVar.a(str, z ? this.f32096b : this.f32095a);
        return new zzfzf(str, jCurrentTimeMillis);
    }

    public final String e(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            return UUID.nameUUIDFromBytes(android.support.v4.media.b.s(new StringBuilder(str2.length() + str.length() + str3.length()), str, str2, str3).getBytes(StandardCharsets.UTF_8)).toString();
        }
        String str4 = str2 == null ? "null" : "not null";
        int length = str4.length();
        String str5 = str3 == null ? "null" : "not null";
        StringBuilder sb = new StringBuilder(str5.length() + length + 120);
        android.support.v4.media.b.B(sb, this.f32099e, ": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ", str4, ", hashKey is ");
        sb.append(str5);
        throw new IllegalArgumentException(sb.toString());
    }
}
