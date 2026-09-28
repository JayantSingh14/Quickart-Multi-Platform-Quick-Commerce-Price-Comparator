package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzexm implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30533a;

    /* renamed from: b, reason: collision with root package name */
    public final zzeak f30534b;

    public zzexm(zzgyw zzgywVar, zzeak zzeakVar) {
        this.f30533a = zzgywVar;
        this.f30534b = zzeakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30533a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzexl
            /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object call() {
                /*
                    r13 = this;
                    com.google.android.gms.internal.ads.zzexm r0 = r13.f30532a
                    com.google.android.gms.internal.ads.zzeak r1 = r0.f30534b
                    com.google.android.gms.internal.ads.zzexn r2 = new com.google.android.gms.internal.ads.zzexn
                    monitor-enter(r1)
                    com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.aa     // Catch: java.lang.Throwable -> L40
                    com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L40
                    com.google.android.gms.internal.ads.zzbgi r4 = r3.f21153c     // Catch: java.lang.Throwable -> L40
                    java.lang.Object r0 = r4.a(r0)     // Catch: java.lang.Throwable -> L40
                    java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L40
                    boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L40
                    if (r0 == 0) goto L50
                    boolean r0 = r1.f()     // Catch: java.lang.Throwable -> L40
                    if (r0 != 0) goto L20
                    goto L50
                L20:
                    long r4 = r1.q     // Catch: java.lang.Throwable -> L40
                    com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L40
                    com.google.android.gms.common.util.Clock r0 = r0.f21687k     // Catch: java.lang.Throwable -> L40
                    long r6 = r0.currentTimeMillis()     // Catch: java.lang.Throwable -> L40
                    r8 = 1000(0x3e8, double:4.94E-321)
                    long r6 = r6 / r8
                    int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r0 >= 0) goto L42
                    java.lang.String r0 = "{}"
                    r1.o = r0     // Catch: java.lang.Throwable -> L40
                    r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                    r1.q = r4     // Catch: java.lang.Throwable -> L40
                    java.lang.String r0 = ""
                    monitor-exit(r1)
                    goto L53
                L40:
                    r0 = move-exception
                    goto L85
                L42:
                    java.lang.String r0 = r1.o     // Catch: java.lang.Throwable -> L40
                    java.lang.String r4 = "{}"
                    boolean r0 = r0.equals(r4)     // Catch: java.lang.Throwable -> L40
                    if (r0 != 0) goto L50
                    java.lang.String r0 = r1.o     // Catch: java.lang.Throwable -> L40
                    monitor-exit(r1)
                    goto L53
                L50:
                    java.lang.String r0 = ""
                    monitor-exit(r1)
                L53:
                    monitor-enter(r1)
                    boolean r4 = r1.s     // Catch: java.lang.Throwable -> L82
                    monitor-exit(r1)
                    com.google.android.gms.ads.internal.zzt r5 = com.google.android.gms.ads.internal.zzt.C
                    com.google.android.gms.ads.internal.util.zzax r5 = r5.o
                    boolean r5 = r5.g()
                    org.json.JSONObject r6 = r1.p
                    r7 = 0
                    r8 = 1
                    if (r6 == 0) goto L67
                    r6 = r8
                    goto L68
                L67:
                    r6 = r7
                L68:
                    long r9 = r1.w
                    com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.va
                    com.google.android.gms.internal.ads.zzbgi r3 = r3.f21153c
                    java.lang.Object r1 = r3.a(r1)
                    java.lang.Long r1 = (java.lang.Long) r1
                    long r11 = r1.longValue()
                    int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                    if (r1 >= 0) goto L7d
                    r7 = r8
                L7d:
                    r3 = r0
                    r2.<init>(r3, r4, r5, r6, r7)
                    return r2
                L82:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L82
                    throw r0
                L85:
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> L40
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzexl.call():java.lang.Object");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 23;
    }
}
