package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zznt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f39514a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzob f39515b;

    public zznt(zzob zzobVar, long j2) {
        this.f39514a = j2;
        Objects.requireNonNull(zzobVar);
        this.f39515b = zzobVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzob r0 = r8.f39515b
            r0.g()
            r0.k()
            com.google.android.gms.measurement.internal.zzib r1 = r0.f39180a
            com.google.android.gms.measurement.internal.zzgt r2 = r1.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r2)
            long r3 = r8.f39514a
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
            com.google.android.gms.measurement.internal.zzgr r2 = r2.n
            java.lang.String r6 = "Activity resumed, time"
            r2.b(r5, r6)
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.U0
            com.google.android.gms.measurement.internal.zzal r5 = r1.f39087d
            r6 = 0
            boolean r2 = r5.q(r6, r2)
            com.google.android.gms.measurement.internal.zznz r7 = r0.f39535f
            if (r2 == 0) goto L42
            boolean r1 = r5.u()
            if (r1 != 0) goto L33
            boolean r1 = r0.f39533d
            if (r1 == 0) goto L63
        L33:
            com.google.android.gms.measurement.internal.zzob r1 = r7.f39528d
            r1.g()
            com.google.android.gms.measurement.internal.zzny r1 = r7.f39527c
            r1.c()
            r7.f39525a = r3
            r7.f39526b = r3
            goto L63
        L42:
            boolean r2 = r5.u()
            if (r2 != 0) goto L55
            com.google.android.gms.measurement.internal.zzhg r1 = r1.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r1)
            com.google.android.gms.measurement.internal.zzhb r1 = r1.s
            boolean r1 = r1.a()
            if (r1 == 0) goto L63
        L55:
            com.google.android.gms.measurement.internal.zzob r1 = r7.f39528d
            r1.g()
            com.google.android.gms.measurement.internal.zzny r1 = r7.f39527c
            r1.c()
            r7.f39525a = r3
            r7.f39526b = r3
        L63:
            com.google.android.gms.measurement.internal.zznx r1 = r0.f39536g
            com.google.android.gms.measurement.internal.zzob r2 = r1.f39523b
            r2.g()
            com.google.android.gms.measurement.internal.zznw r1 = r1.f39522a
            if (r1 == 0) goto L73
            com.google.android.gms.internal.measurement.zzcn r3 = r2.f39532c
            r3.removeCallbacks(r1)
        L73:
            com.google.android.gms.measurement.internal.zzib r1 = r2.f39180a
            com.google.android.gms.measurement.internal.zzhg r3 = r1.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r3)
            com.google.android.gms.measurement.internal.zzhb r3 = r3.s
            r4 = 0
            r3.b(r4)
            r2.g()
            r2.f39533d = r4
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.T0
            com.google.android.gms.measurement.internal.zzal r3 = r1.f39087d
            boolean r2 = r3.q(r6, r2)
            if (r2 == 0) goto Laa
            com.google.android.gms.measurement.internal.zzli r2 = r1.f39096m
            com.google.android.gms.measurement.internal.zzib.k(r2)
            boolean r3 = r2.n
            if (r3 == 0) goto Laa
            com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r1)
            java.lang.String r3 = "Retrying trigger URI registration in foreground"
            com.google.android.gms.measurement.internal.zzgr r1 = r1.n
            r1.a(r3)
            com.google.android.gms.measurement.internal.zzib.k(r2)
            r2.L()
        Laa:
            com.google.android.gms.measurement.internal.zzoa r0 = r0.f39534e
            com.google.android.gms.measurement.internal.zzob r1 = r0.f39531a
            r1.g()
            com.google.android.gms.measurement.internal.zzib r1 = r1.f39180a
            boolean r2 = r1.a()
            if (r2 != 0) goto Lba
            return
        Lba:
            com.google.android.gms.common.util.Clock r1 = r1.f39094k
            long r1 = r1.currentTimeMillis()
            r0.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznt.run():void");
    }
}
