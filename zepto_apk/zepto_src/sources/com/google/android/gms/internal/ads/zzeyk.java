package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes4.dex */
public final class zzeyk implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final ApplicationInfo f30579a;

    /* renamed from: b, reason: collision with root package name */
    public final PackageInfo f30580b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f30581c;

    public zzeyk(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context) {
        this.f30579a = applicationInfo;
        this.f30580b = packageInfo;
        this.f30581c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    @Override // com.google.android.gms.internal.ads.zzezx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.ListenableFuture zza() throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r9 = this;
            android.content.Context r0 = r9.f30581c
            android.content.pm.ApplicationInfo r1 = r9.f30579a
            java.lang.String r3 = r1.packageName
            r1 = 0
            android.content.pm.PackageInfo r2 = r9.f30580b
            if (r2 != 0) goto Ld
            r4 = r1
            goto L13
        Ld:
            int r4 = r2.versionCode
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L13:
            if (r2 != 0) goto L17
            r5 = r1
            goto L1a
        L17:
            java.lang.String r2 = r2.versionName
            r5 = r2
        L1a:
            com.google.android.gms.ads.internal.util.zzf r2 = com.google.android.gms.ads.internal.util.zzs.f21608l     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            com.google.android.gms.common.wrappers.PackageManagerWrapper r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.CharSequence r2 = r2.getApplicationLabel(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            r6 = r2
            goto L2b
        L2a:
            r6 = r1
        L2b:
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 30
            if (r2 < r7) goto L79
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.Td
            com.google.android.gms.ads.internal.client.zzbd r7 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r7 = r7.f21153c
            java.lang.Object r2 = r7.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L79
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            android.content.pm.InstallSourceInfo r0 = androidx.activity.result.contract.a.e(r0, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            if (r0 == 0) goto L79
            java.lang.String r2 = androidx.activity.result.contract.a.s(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            if (r7 == 0) goto L5d
            java.lang.String r7 = "No installing package name found"
            com.google.android.gms.ads.internal.util.zze.k(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r2 = r1
        L5d:
            java.lang.String r7 = androidx.activity.result.contract.a.j(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6f
            if (r0 == 0) goto L71
            java.lang.String r0 = "No initiating package name found"
            com.google.android.gms.ads.internal.util.zze.k(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6f
        L6c:
            r8 = r1
        L6d:
            r7 = r2
            goto L87
        L6f:
            r0 = move-exception
            goto L73
        L71:
            r8 = r7
            goto L6d
        L73:
            r1 = r7
            goto L7d
        L75:
            r0 = move-exception
            goto L7d
        L77:
            r0 = move-exception
            goto L7c
        L79:
            r7 = r1
            r8 = r7
            goto L87
        L7c:
            r2 = r1
        L7d:
            com.google.android.gms.ads.internal.zzt r7 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.internal.ads.zzcda r7 = r7.f21684h
            java.lang.String r8 = "PackageInfoSignalSource.getInstallSourceInfo"
            r7.d(r8, r0)
            goto L6c
        L87:
            com.google.android.gms.internal.ads.zzeyl r2 = new com.google.android.gms.internal.ads.zzeyl
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgym.a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyk.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 29;
    }
}
