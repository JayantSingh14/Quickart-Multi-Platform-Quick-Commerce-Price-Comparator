package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzkl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f39267a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39268b;

    public zzkl(zzli zzliVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f39267a = zzcuVar;
        Objects.requireNonNull(zzliVar);
        this.f39268b = zzliVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzli r0 = r8.f39268b
            com.google.android.gms.measurement.internal.zzib r1 = r0.f39180a
            com.google.android.gms.measurement.internal.zzob r1 = r1.f39091h
            com.google.android.gms.measurement.internal.zzib.k(r1)
            com.google.android.gms.measurement.internal.zzib r1 = r1.f39180a
            com.google.android.gms.measurement.internal.zzhg r2 = r1.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r2)
            com.google.android.gms.measurement.internal.zzjk r2 = r2.n()
            com.google.android.gms.measurement.internal.zzjj r3 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r2 = r2.i(r3)
            r3 = 0
            if (r2 != 0) goto L2b
            com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r1)
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38963k
            r1.a(r2)
        L29:
            r1 = r3
            goto L59
        L2b:
            com.google.android.gms.measurement.internal.zzhg r2 = r1.f39088e
            com.google.android.gms.measurement.internal.zzib.j(r2)
            com.google.android.gms.common.util.Clock r1 = r1.f39094k
            long r4 = r1.currentTimeMillis()
            boolean r1 = r2.q(r4)
            if (r1 != 0) goto L29
            com.google.android.gms.measurement.internal.zzib.j(r2)
            com.google.android.gms.measurement.internal.zzhd r1 = r2.q
            long r4 = r1.a()
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L4c
            goto L29
        L4c:
            com.google.android.gms.measurement.internal.zzib.j(r2)
            com.google.android.gms.measurement.internal.zzhd r1 = r2.q
            long r1 = r1.a()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L59:
            com.google.android.gms.internal.measurement.zzcu r2 = r8.f39267a
            if (r1 == 0) goto L6c
            com.google.android.gms.measurement.internal.zzib r0 = r0.f39180a
            com.google.android.gms.measurement.internal.zzpo r0 = r0.f39092i
            com.google.android.gms.measurement.internal.zzib.j(r0)
            long r3 = r1.longValue()
            r0.O(r2, r3)
            return
        L6c:
            r2.b0(r3)     // Catch: android.os.RemoteException -> L70
            return
        L70:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzib r0 = r0.f39180a
            com.google.android.gms.measurement.internal.zzgt r0 = r0.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r0)
            java.lang.String r2 = "getSessionId failed with exception"
            com.google.android.gms.measurement.internal.zzgr r0 = r0.f38958f
            r0.b(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.run():void");
    }
}
