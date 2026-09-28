package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;

/* loaded from: classes4.dex */
public final class zzfkv {

    /* renamed from: a, reason: collision with root package name */
    public final zzfjz f31332a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfks f31333b;

    /* renamed from: d, reason: collision with root package name */
    public zzflb f31335d;

    /* renamed from: e, reason: collision with root package name */
    public int f31336e = 1;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f31334c = new ArrayDeque();

    public zzfkv(zzfjz zzfjzVar, zzfjv zzfjvVar, zzfks zzfksVar) {
        this.f31332a = zzfjzVar;
        this.f31333b = zzfksVar;
        zzfjvVar.f31285a = new zzfku(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0074 A[Catch: all -> 0x002b, DONT_GENERATE, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0013, B:8:0x0024, B:13:0x002e, B:17:0x0035, B:22:0x003c, B:24:0x0044, B:26:0x004c, B:28:0x0052, B:29:0x005a, B:36:0x0077, B:34:0x0074, B:43:0x0080, B:44:0x0081, B:45:0x0091, B:47:0x00ac, B:52:0x00b1, B:19:0x0038, B:57:0x00b6, B:14:0x002f, B:30:0x005b, B:32:0x0065, B:46:0x0092), top: B:64:0x0001, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.U6     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r0 = r1.a(r0)     // Catch: java.lang.Throwable -> L2b
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2b
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L2e
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzcda r0 = r0.f21684h     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.ads.internal.util.zzj r0 = r0.g()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzccv r0 = r0.i()     // Catch: java.lang.Throwable -> L2b
            boolean r0 = r0.f25916j     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L24
            goto L2e
        L24:
            java.util.ArrayDeque r0 = r6.f31334c     // Catch: java.lang.Throwable -> L2b
            r0.clear()     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r6)
            return
        L2b:
            r0 = move-exception
            goto Lb7
        L2e:
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzflb r0 = r6.f31335d     // Catch: java.lang.Throwable -> Lb4
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L38
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            r0 = r2
            goto L3a
        L38:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            r0 = r1
        L3a:
            if (r0 == 0) goto Lb2
        L3c:
            java.util.ArrayDeque r0 = r6.f31334c     // Catch: java.lang.Throwable -> L2b
            boolean r3 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2b
            if (r3 != 0) goto Lb2
            java.lang.Object r0 = r0.pollFirst()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfkt r0 = (com.google.android.gms.internal.ads.zzfkt) r0     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L81
            com.google.android.gms.internal.ads.zzfkj r3 = r0.zzb()     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L3c
            com.google.android.gms.internal.ads.zzfjz r3 = r6.f31332a     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfkj r4 = r0.zzb()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfka r3 = (com.google.android.gms.internal.ads.zzfka) r3     // Catch: java.lang.Throwable -> L2b
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L2b
            java.util.concurrent.ConcurrentHashMap r5 = r3.f31292a     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.internal.ads.zzfjy r4 = (com.google.android.gms.internal.ads.zzfjy) r4     // Catch: java.lang.Throwable -> L7a
            if (r4 == 0) goto L74
            com.google.android.gms.internal.ads.zzfkg r5 = r3.f31293b     // Catch: java.lang.Throwable -> L7a
            r4.a()     // Catch: java.lang.Throwable -> L7a
            java.util.LinkedList r4 = r4.f31287a     // Catch: java.lang.Throwable -> L7a
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L7a
            int r5 = r5.f31311e     // Catch: java.lang.Throwable -> L7a
            if (r4 >= r5) goto L77
        L74:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2b
            r3 = r2
            goto L7c
        L77:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2b
            r3 = r1
            goto L7c
        L7a:
            r0 = move-exception
            goto L7f
        L7c:
            if (r3 == 0) goto L3c
            goto L81
        L7f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7a
            throw r0     // Catch: java.lang.Throwable -> L2b
        L81:
            com.google.android.gms.internal.ads.zzfjz r1 = r6.f31332a     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfks r2 = r6.f31333b     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzflb r3 = new com.google.android.gms.internal.ads.zzflb     // Catch: java.lang.Throwable -> L2b
            r3.<init>(r1, r2, r0)     // Catch: java.lang.Throwable -> L2b
            r6.f31335d = r3     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzfkq r1 = new com.google.android.gms.internal.ads.zzfkq     // Catch: java.lang.Throwable -> L2b
            r1.<init>(r6, r0)     // Catch: java.lang.Throwable -> L2b
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L2b
            com.google.common.util.concurrent.ListenableFuture r2 = r3.f31356b     // Catch: java.lang.Throwable -> Laf
            com.google.android.gms.internal.ads.zzfkz r4 = com.google.android.gms.internal.ads.zzfkz.f31347a     // Catch: java.lang.Throwable -> Laf
            java.util.concurrent.Executor r5 = r0.zza()     // Catch: java.lang.Throwable -> Laf
            com.google.common.util.concurrent.ListenableFuture r2 = com.google.android.gms.internal.ads.zzgym.h(r2, r4, r5)     // Catch: java.lang.Throwable -> Laf
            java.util.concurrent.Executor r0 = r0.zza()     // Catch: java.lang.Throwable -> Laf
            com.google.android.gms.internal.ads.zzgyk r4 = new com.google.android.gms.internal.ads.zzgyk     // Catch: java.lang.Throwable -> Laf
            r4.<init>(r2, r1)     // Catch: java.lang.Throwable -> Laf
            com.google.android.gms.internal.ads.zzgxf r2 = (com.google.android.gms.internal.ads.zzgxf) r2     // Catch: java.lang.Throwable -> Laf
            r2.q(r4, r0)     // Catch: java.lang.Throwable -> Laf
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r6)
            return
        Laf:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Laf
            throw r0     // Catch: java.lang.Throwable -> L2b
        Lb2:
            monitor-exit(r6)
            return
        Lb4:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb4
            throw r0     // Catch: java.lang.Throwable -> L2b
        Lb7:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2b
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfkv.a():void");
    }
}
