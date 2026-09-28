package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzemp implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f29789a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhu f29790b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29791c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f29792d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzfpe f29793e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzfic f29794f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzemr f29795g;

    public zzemp(zzemr zzemrVar, long j2, zzfhu zzfhuVar, zzfhr zzfhrVar, String str, zzfpe zzfpeVar, zzfic zzficVar) {
        this.f29789a = j2;
        this.f29790b = zzfhuVar;
        this.f29791c = zzfhrVar;
        this.f29792d = str;
        this.f29793e = zzfpeVar;
        this.f29794f = zzficVar;
        Objects.requireNonNull(zzemrVar);
        this.f29795g = zzemrVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgyj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Throwable r14) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemp.zza(java.lang.Throwable):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: all -> 0x0020, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0020, blocks: (B:4:0x000d, B:6:0x0011, B:10:0x0023, B:12:0x0027, B:14:0x0029, B:15:0x002b, B:18:0x0036, B:25:0x004a, B:26:0x005a, B:27:0x0064, B:23:0x003e, B:24:0x003f, B:31:0x0068, B:16:0x002c, B:20:0x0038), top: B:34:0x000d, inners: #1 }] */
    @Override // com.google.android.gms.internal.ads.zzgyj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(java.lang.Object r12) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzemr r12 = r11.f29795g
            com.google.android.gms.common.util.Clock r0 = r12.f29801a
            long r0 = r0.elapsedRealtime()
            long r2 = r11.f29789a
            long r6 = r0 - r2
            monitor-enter(r12)
            boolean r0 = r12.f29805e     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L22
            com.google.android.gms.internal.ads.zzemt r4 = r12.f29802b     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfhu r5 = r11.f29790b     // Catch: java.lang.Throwable -> L20
            r8 = r6
            com.google.android.gms.internal.ads.zzfhr r6 = r11.f29791c     // Catch: java.lang.Throwable -> L20
            r7 = 0
            r9 = r8
            r8 = 0
            r4.a(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L20
            r8 = r9
            goto L23
        L20:
            r0 = move-exception
            goto L69
        L22:
            r8 = r6
        L23:
            boolean r0 = r12.f29807g     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L29
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L20
            return
        L29:
            com.google.android.gms.internal.ads.zzfhr r0 = r11.f29791c     // Catch: java.lang.Throwable -> L20
            monitor-enter(r12)     // Catch: java.lang.Throwable -> L20
            java.util.LinkedHashMap r1 = r12.f29804d     // Catch: java.lang.Throwable -> L66
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.internal.ads.zzemq r1 = (com.google.android.gms.internal.ads.zzemq) r1     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto L38
        L36:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L20
            goto L4a
        L38:
            int r1 = r1.f29798c     // Catch: java.lang.Throwable -> L66
            r2 = 8
            if (r1 != r2) goto L36
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L20
            java.util.LinkedHashMap r1 = r12.f29804d     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzemq r1 = (com.google.android.gms.internal.ads.zzemq) r1     // Catch: java.lang.Throwable -> L20
            r1.f29799d = r8     // Catch: java.lang.Throwable -> L20
            goto L5a
        L4a:
            java.util.LinkedHashMap r1 = r12.f29804d     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzemq r4 = new com.google.android.gms.internal.ads.zzemq     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = r11.f29792d     // Catch: java.lang.Throwable -> L20
            java.lang.String r6 = r0.f0     // Catch: java.lang.Throwable -> L20
            r7 = 0
            r10 = 0
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L20
            r1.put(r0, r4)     // Catch: java.lang.Throwable -> L20
        L5a:
            com.google.android.gms.internal.ads.zzejl r4 = r12.f29806f     // Catch: java.lang.Throwable -> L20
            r9 = r8
            r8 = 0
            r6 = r9
            r9 = 1
            r5 = r0
            r4.c(r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L20
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L20
            return
        L66:
            r0 = move-exception
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L66
            throw r0     // Catch: java.lang.Throwable -> L20
        L69:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L20
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemp.zzb(java.lang.Object):void");
    }
}
