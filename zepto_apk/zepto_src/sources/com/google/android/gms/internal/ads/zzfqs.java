package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfqs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfqy f31661a;

    public zzfqs(zzfqy zzfqyVar) {
        Objects.requireNonNull(zzfqyVar);
        this.f31661a = zzfqyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x001a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzfqy r0 = r3.f31661a
            monitor-enter(r0)
            com.google.android.gms.ads.internal.client.zzce r1 = r0.f31674h     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L16
            com.google.android.gms.ads.internal.client.zzft r2 = r0.f31671e     // Catch: java.lang.Throwable -> Ld android.os.RemoteException -> Lf
            r1.L9(r2)     // Catch: java.lang.Throwable -> Ld android.os.RemoteException -> Lf
            goto L16
        Ld:
            r1 = move-exception
            goto L2a
        Lf:
            int r1 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> Ld
            java.lang.String r1 = "Failed to call onAdsExhausted"
            com.google.android.gms.ads.internal.util.client.zzo.f(r1)     // Catch: java.lang.Throwable -> Ld
        L16:
            com.google.android.gms.ads.internal.client.zzch r1 = r0.f31675i     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L1f
            java.lang.String r2 = r0.f31678l     // Catch: java.lang.Throwable -> Ld android.os.RemoteException -> L21
            r1.c0(r2)     // Catch: java.lang.Throwable -> Ld android.os.RemoteException -> L21
        L1f:
            monitor-exit(r0)
            goto L29
        L21:
            int r1 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> Ld
            java.lang.String r1 = "Failed to call onAdsExhausted"
            com.google.android.gms.ads.internal.util.client.zzo.f(r1)     // Catch: java.lang.Throwable -> Ld
            monitor-exit(r0)
        L29:
            return
        L2a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfqs.run():void");
    }
}
