package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeo extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzep f29938a;

    public /* synthetic */ zzeo(zzep zzepVar) {
        Objects.requireNonNull(zzepVar);
        this.f29938a = zzepVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, Intent intent) {
        this.f29938a.f30016a.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzen
            /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final /* synthetic */ void run() {
                /*
                    r11 = this;
                    com.google.android.gms.internal.ads.zzeo r0 = r11.f29846a
                    com.google.android.gms.internal.ads.zzep r0 = r0.f29938a
                    r0.getClass()
                    android.content.Context r1 = r2
                    java.lang.String r2 = "connectivity"
                    java.lang.Object r2 = r1.getSystemService(r2)
                    android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
                    r3 = 0
                    r4 = 5
                    if (r2 != 0) goto L16
                    goto L57
                L16:
                    android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L57
                    r5 = 1
                    if (r2 == 0) goto L23
                    boolean r6 = r2.isConnected()
                    if (r6 != 0) goto L25
                L23:
                    r3 = r5
                    goto L57
                L25:
                    int r6 = r2.getType()
                    r7 = 2
                    r8 = 9
                    r9 = 6
                    r10 = 4
                    if (r6 == 0) goto L43
                    if (r6 == r5) goto L41
                    if (r6 == r10) goto L43
                    if (r6 == r4) goto L43
                    if (r6 == r9) goto L3f
                    if (r6 == r8) goto L3d
                    r3 = 8
                    goto L57
                L3d:
                    r3 = 7
                    goto L57
                L3f:
                    r3 = r4
                    goto L57
                L41:
                    r3 = r7
                    goto L57
                L43:
                    int r2 = r2.getSubtype()
                    switch(r2) {
                        case 1: goto L56;
                        case 2: goto L56;
                        case 3: goto L54;
                        case 4: goto L54;
                        case 5: goto L54;
                        case 6: goto L54;
                        case 7: goto L54;
                        case 8: goto L54;
                        case 9: goto L54;
                        case 10: goto L54;
                        case 11: goto L54;
                        case 12: goto L54;
                        case 13: goto L3f;
                        case 14: goto L54;
                        case 15: goto L54;
                        case 16: goto L4a;
                        case 17: goto L54;
                        case 18: goto L41;
                        case 19: goto L4a;
                        case 20: goto L4c;
                        default: goto L4a;
                    }
                L4a:
                    r3 = r9
                    goto L57
                L4c:
                    int r2 = android.os.Build.VERSION.SDK_INT
                    r5 = 29
                    if (r2 < r5) goto L57
                    r3 = r8
                    goto L57
                L54:
                    r3 = r10
                    goto L57
                L56:
                    r3 = 3
                L57:
                    int r2 = android.os.Build.VERSION.SDK_INT
                    r5 = 31
                    if (r2 < r5) goto L7d
                    if (r3 != r4) goto L7d
                    java.lang.String r2 = "phone"
                    java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.RuntimeException -> L79
                    android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.RuntimeException -> L79
                    if (r1 == 0) goto L77
                    com.google.android.gms.internal.ads.zzei r2 = new com.google.android.gms.internal.ads.zzei     // Catch: java.lang.RuntimeException -> L79
                    r2.<init>(r0)     // Catch: java.lang.RuntimeException -> L79
                    java.util.concurrent.Executor r3 = r0.f30016a     // Catch: java.lang.RuntimeException -> L79
                    androidx.core.os.a.t(r1, r3, r2)     // Catch: java.lang.RuntimeException -> L79
                    androidx.core.os.a.s(r1, r2)     // Catch: java.lang.RuntimeException -> L79
                    goto L80
                L77:
                    r1 = 0
                    throw r1     // Catch: java.lang.RuntimeException -> L79
                L79:
                    r0.c(r4)
                    goto L80
                L7d:
                    r0.c(r3)
                L80:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.run():void");
            }
        });
    }
}
