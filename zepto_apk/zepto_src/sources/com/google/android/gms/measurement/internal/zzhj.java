package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes.dex */
public final class zzhj {

    /* renamed from: a, reason: collision with root package name */
    public final zzib f39037a;

    public zzhj(zzpf zzpfVar) {
        this.f39037a = zzpfVar.f39605l;
    }

    public final boolean a() {
        zzib zzibVar = this.f39037a;
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(zzibVar.f39084a);
            if (packageManagerWrapperPackageManager != null) {
                return packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.n.b(e2, "Failed to retrieve Play Store version for Install Referrer");
            return false;
        }
    }
}
