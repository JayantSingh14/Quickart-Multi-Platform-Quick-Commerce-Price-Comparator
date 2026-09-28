package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzex;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public class MobileAds {
    @KeepForSdk
    private static void setPlugin(String str) {
        zzex zzexVarD = zzex.d();
        synchronized (zzexVarD.f21221h) {
            Preconditions.checkState(zzexVarD.f21222i != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            zzdb zzdbVar = zzexVarD.f21222i;
            if (zzdbVar == null) {
                return;
            }
            try {
                zzdbVar.Y0(str);
            } catch (RemoteException e2) {
                zzo.d("Unable to set plugin.", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002c A[Catch: all -> 0x001d, TryCatch #2 {, blocks: (B:9:0x0015, B:11:0x0019, B:17:0x0025, B:19:0x002c, B:20:0x0031, B:22:0x0035, B:23:0x003a, B:25:0x003e, B:26:0x0043, B:16:0x0020), top: B:33:0x0015, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[Catch: all -> 0x001d, TryCatch #2 {, blocks: (B:9:0x0015, B:11:0x0019, B:17:0x0025, B:19:0x002c, B:20:0x0031, B:22:0x0035, B:23:0x003a, B:25:0x003e, B:26:0x0043, B:16:0x0020), top: B:33:0x0015, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e A[Catch: all -> 0x001d, TryCatch #2 {, blocks: (B:9:0x0015, B:11:0x0019, B:17:0x0025, B:19:0x002c, B:20:0x0031, B:22:0x0035, B:23:0x003a, B:25:0x003e, B:26:0x0043, B:16:0x0020), top: B:33:0x0015, inners: #0 }] */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void stop() {
        /*
            com.google.android.gms.ads.internal.client.zzex r0 = com.google.android.gms.ads.internal.client.zzex.d()
            java.lang.Object r1 = r0.f21217d
            monitor-enter(r1)
            r2 = 0
            r0.f21220g = r2     // Catch: java.lang.Throwable -> L47
            r0.f21219f = r2     // Catch: java.lang.Throwable -> L47
            java.util.ArrayList r2 = r0.f21218e     // Catch: java.lang.Throwable -> L47
            r2.clear()     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L47
            java.lang.Object r2 = r0.f21221h
            monitor-enter(r2)
            com.google.android.gms.ads.internal.client.zzdb r1 = r0.f21222i     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            if (r1 == 0) goto L25
            r1.j()     // Catch: java.lang.Throwable -> L1d android.os.RemoteException -> L1f
            goto L25
        L1d:
            r0 = move-exception
            goto L45
        L1f:
            r1 = move-exception
            java.lang.String r3 = "Unable to stop the SDK."
            com.google.android.gms.ads.internal.util.client.zzo.d(r3, r1)     // Catch: java.lang.Throwable -> L1d
        L25:
            r1 = 0
            r0.f21222i = r1     // Catch: java.lang.Throwable -> L1d
            com.google.android.gms.ads.internal.client.zzep r3 = r0.f21214a     // Catch: java.lang.Throwable -> L1d
            if (r3 == 0) goto L31
            r3.a()     // Catch: java.lang.Throwable -> L1d
            r0.f21214a = r1     // Catch: java.lang.Throwable -> L1d
        L31:
            com.google.android.gms.ads.internal.client.zzfb r3 = r0.f21215b     // Catch: java.lang.Throwable -> L1d
            if (r3 == 0) goto L3a
            r3.a()     // Catch: java.lang.Throwable -> L1d
            r0.f21215b = r1     // Catch: java.lang.Throwable -> L1d
        L3a:
            com.google.android.gms.ads.internal.client.zzeo r3 = r0.f21216c     // Catch: java.lang.Throwable -> L1d
            if (r3 == 0) goto L43
            r3.a()     // Catch: java.lang.Throwable -> L1d
            r0.f21216c = r1     // Catch: java.lang.Throwable -> L1d
        L43:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1d
            return
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1d
            throw r0
        L47:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L47
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.MobileAds.stop():void");
    }
}
