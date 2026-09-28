package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzea f31654a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31655b;

    public zzfqp(zzfqy zzfqyVar, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.f31654a = zzeaVar;
        Objects.requireNonNull(zzfqyVar);
        this.f31655b = zzfqyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzfqy r0 = r4.f31655b
            com.google.android.gms.ads.internal.client.zzea r1 = r4.f31654a
            monitor-enter(r0)
            com.google.android.gms.ads.internal.client.zzce r2 = r0.f31674h     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto L18
            com.google.android.gms.ads.internal.client.zzft r3 = r0.f31671e     // Catch: java.lang.Throwable -> Lf android.os.RemoteException -> L11
            r2.Jb(r3)     // Catch: java.lang.Throwable -> Lf android.os.RemoteException -> L11
            goto L18
        Lf:
            r1 = move-exception
            goto L2c
        L11:
            int r2 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> Lf
            java.lang.String r2 = "Failed to call onAdsAvailable"
            com.google.android.gms.ads.internal.util.client.zzo.f(r2)     // Catch: java.lang.Throwable -> Lf
        L18:
            com.google.android.gms.ads.internal.client.zzch r2 = r0.f31675i     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto L21
            java.lang.String r3 = r0.f31678l     // Catch: java.lang.Throwable -> Lf android.os.RemoteException -> L23
            r2.A5(r3, r1)     // Catch: java.lang.Throwable -> Lf android.os.RemoteException -> L23
        L21:
            monitor-exit(r0)
            goto L2b
        L23:
            int r1 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = "Failed to call onAdPreloaded"
            com.google.android.gms.ads.internal.util.client.zzo.f(r1)     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r0)
        L2b:
            return
        L2c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfqp.run():void");
    }
}
