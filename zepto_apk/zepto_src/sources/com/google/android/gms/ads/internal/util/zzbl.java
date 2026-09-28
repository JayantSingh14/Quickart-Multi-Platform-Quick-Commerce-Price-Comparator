package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzarn;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbl {

    /* renamed from: a, reason: collision with root package name */
    public static zzarn f21534a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f21535b = new Object();

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:17:0x005c, B:16:0x0058, B:18:0x005e), top: B:22:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbl(android.content.Context r5) {
        /*
            r4 = this;
            r4.<init>()
            android.content.Context r0 = r5.getApplicationContext()
            if (r0 == 0) goto Ld
            android.content.Context r5 = r5.getApplicationContext()
        Ld:
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzbl.f21535b
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzarn r1 = com.google.android.gms.ads.internal.util.zzbl.f21534a     // Catch: java.lang.Throwable -> L56
            if (r1 != 0) goto L5e
            com.google.android.gms.internal.ads.zzbgk.a(r5)     // Catch: java.lang.Throwable -> L56
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.Throwable -> L56
            if (r1 != 0) goto L58
            com.google.android.gms.internal.ads.zzbgb r1 = com.google.android.gms.internal.ads.zzbgk.e5     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.internal.ads.zzbgi r2 = r2.f21153c     // Catch: java.lang.Throwable -> L56
            java.lang.Object r1 = r2.a(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L56
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L58
            com.google.android.gms.ads.internal.util.zzay r1 = new com.google.android.gms.ads.internal.util.zzay     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.internal.ads.zzasl r2 = new com.google.android.gms.internal.ads.zzasl     // Catch: java.lang.Throwable -> L56
            r2.<init>()     // Catch: java.lang.Throwable -> L56
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L56
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L56
            java.io.File r5 = r5.getCacheDir()     // Catch: java.lang.Throwable -> L56
            java.lang.String r3 = "admob_volley"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfwk.a(r5, r3)     // Catch: java.lang.Throwable -> L56
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.internal.ads.zzarn r5 = new com.google.android.gms.internal.ads.zzarn     // Catch: java.lang.Throwable -> L56
            com.google.android.gms.internal.ads.zzasg r3 = new com.google.android.gms.internal.ads.zzasg     // Catch: java.lang.Throwable -> L56
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L56
            r5.<init>(r3, r1)     // Catch: java.lang.Throwable -> L56
            r5.a()     // Catch: java.lang.Throwable -> L56
            goto L5c
        L56:
            r5 = move-exception
            goto L60
        L58:
            com.google.android.gms.internal.ads.zzarn r5 = com.google.android.gms.internal.ads.zzasp.a(r5)     // Catch: java.lang.Throwable -> L56
        L5c:
            com.google.android.gms.ads.internal.util.zzbl.f21534a = r5     // Catch: java.lang.Throwable -> L56
        L5e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L60:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbl.<init>(android.content.Context):void");
    }

    public final ListenableFuture a(int i2, String str, HashMap map, byte[] bArr) {
        zzbi zzbiVar = new zzbi();
        zzbg zzbgVar = new zzbg(this, str, zzbiVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(0);
        zzbh zzbhVar = new zzbh(this, i2, str, zzbiVar, zzbgVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.e()) {
            try {
                zzlVar.b(str, zzbhVar.e(), bArr == null ? null : bArr);
            } catch (zzaqs e2) {
                String message = e2.getMessage();
                int i3 = zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.f(message);
            }
        }
        f21534a.b(zzbhVar);
        return zzbiVar;
    }
}
