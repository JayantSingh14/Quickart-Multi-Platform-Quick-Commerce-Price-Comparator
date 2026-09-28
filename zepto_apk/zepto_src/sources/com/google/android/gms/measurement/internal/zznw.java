package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zznw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f39519a;

    /* renamed from: b, reason: collision with root package name */
    public final long f39520b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zznx f39521c;

    public zznw(zznx zznxVar, long j2, long j3) {
        Objects.requireNonNull(zznxVar);
        this.f39521c = zznxVar;
        this.f39519a = j2;
        this.f39520b = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhy zzhyVar = this.f39521c.f39523b.f39180a.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznv
            /* JADX WARN: Removed duplicated region for block: B:10:0x007c  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    r8 = this;
                    com.google.android.gms.measurement.internal.zznw r0 = r8.f39518a
                    com.google.android.gms.measurement.internal.zznx r1 = r0.f39521c
                    com.google.android.gms.measurement.internal.zzob r1 = r1.f39523b
                    r1.g()
                    com.google.android.gms.measurement.internal.zzib r2 = r1.f39180a
                    com.google.android.gms.measurement.internal.zzgt r3 = r2.f39089f
                    com.google.android.gms.measurement.internal.zzib.l(r3)
                    java.lang.String r4 = "Application going to the background"
                    com.google.android.gms.measurement.internal.zzgr r3 = r3.f38965m
                    r3.a(r4)
                    com.google.android.gms.measurement.internal.zzhg r3 = r2.f39088e
                    com.google.android.gms.measurement.internal.zzib.j(r3)
                    com.google.android.gms.measurement.internal.zzhb r3 = r3.s
                    r4 = 1
                    r3.b(r4)
                    r1.g()
                    r1.f39533d = r4
                    com.google.android.gms.measurement.internal.zzal r3 = r2.f39087d
                    boolean r5 = r3.u()
                    if (r5 != 0) goto L3c
                    r5 = 0
                    long r6 = r0.f39520b
                    com.google.android.gms.measurement.internal.zznz r1 = r1.f39535f
                    r1.a(r6, r5, r5)
                    com.google.android.gms.measurement.internal.zzny r1 = r1.f39527c
                    r1.c()
                L3c:
                    com.google.android.gms.measurement.internal.zzgt r1 = r2.f39089f
                    com.google.android.gms.measurement.internal.zzib.l(r1)
                    long r5 = r0.f39519a
                    java.lang.Long r0 = java.lang.Long.valueOf(r5)
                    com.google.android.gms.measurement.internal.zzgr r5 = r1.f38964l
                    java.lang.String r6 = "Application backgrounded at: timestamp_millis"
                    r5.b(r0, r6)
                    com.google.android.gms.measurement.internal.zzli r0 = r2.f39096m
                    com.google.android.gms.measurement.internal.zzib.k(r0)
                    r0.g()
                    r0.h()
                    com.google.android.gms.measurement.internal.zzib r0 = r0.f39180a
                    com.google.android.gms.measurement.internal.zznk r5 = r0.o()
                    r5.g()
                    r5.h()
                    boolean r6 = r5.n()
                    if (r6 != 0) goto L6c
                    goto L7c
                L6c:
                    com.google.android.gms.measurement.internal.zzib r5 = r5.f39180a
                    com.google.android.gms.measurement.internal.zzpo r5 = r5.f39092i
                    com.google.android.gms.measurement.internal.zzib.j(r5)
                    int r5 = r5.L()
                    r6 = 242600(0x3b3a8, float:3.39955E-40)
                    if (r5 < r6) goto L92
                L7c:
                    com.google.android.gms.measurement.internal.zznk r0 = r0.o()
                    r0.g()
                    r0.h()
                    com.google.android.gms.measurement.internal.zzr r4 = r0.w(r4)
                    com.google.android.gms.measurement.internal.zzmk r5 = new com.google.android.gms.measurement.internal.zzmk
                    r5.<init>(r0, r4)
                    r0.u(r5)
                L92:
                    r0 = 0
                    com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.N0
                    boolean r0 = r3.q(r0, r4)
                    if (r0 == 0) goto Ld3
                    com.google.android.gms.measurement.internal.zzpo r0 = r2.f39092i
                    com.google.android.gms.measurement.internal.zzib.j(r0)
                    android.content.Context r4 = r2.f39084a
                    java.lang.String r5 = r4.getPackageName()
                    java.lang.String r6 = r3.f38689c
                    boolean r0 = r0.F(r5, r6)
                    if (r0 == 0) goto Lb1
                    r3 = 1000(0x3e8, double:4.94E-321)
                    goto Lbb
                Lb1:
                    java.lang.String r0 = r4.getPackageName()
                    com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.E
                    long r3 = r3.n(r0, r4)
                Lbb:
                    com.google.android.gms.measurement.internal.zzib.l(r1)
                    java.lang.Long r0 = java.lang.Long.valueOf(r3)
                    com.google.android.gms.measurement.internal.zzgr r1 = r1.n
                    java.lang.String r5 = "[sgtm] Scheduling batch upload with minimum latency in millis"
                    r1.b(r0, r5)
                    com.google.android.gms.measurement.internal.zzlp r0 = r2.u
                    com.google.android.gms.measurement.internal.zzib.i(r0)
                    com.google.android.gms.measurement.internal.zzlp r0 = r2.u
                    r0.k(r3)
                Ld3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznv.run():void");
            }
        });
    }
}
