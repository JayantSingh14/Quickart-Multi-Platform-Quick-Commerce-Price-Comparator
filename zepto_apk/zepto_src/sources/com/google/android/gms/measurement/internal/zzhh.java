package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzhh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzbq f39033a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzhi f39034b;

    public zzhh(zzhi zzhiVar, com.google.android.gms.internal.measurement.zzbq zzbqVar, zzhi zzhiVar2) {
        this.f39033a = zzbqVar;
        this.f39034b = zzhiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhi zzhiVar = this.f39034b;
        zzib zzibVar = zzhiVar.f39036b.f39037a;
        zzhy zzhyVar = zzibVar.f39090g;
        zzib.l(zzhyVar);
        zzhyVar.g();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", zzhiVar.f39035a);
        try {
            if (this.f39033a.W(bundle) == null) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Install Referrer Service returned a null response");
            }
        } catch (Exception e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e2.getMessage(), "Exception occurred while retrieving the Install Referrer");
        }
        zzhy zzhyVar2 = zzibVar.f39090g;
        zzib.l(zzhyVar2);
        zzhyVar2.g();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
