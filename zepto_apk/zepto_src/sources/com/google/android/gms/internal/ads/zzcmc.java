package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes4.dex */
public final class zzcmc implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f26533a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f26534b;

    public zzcmc(zzclp zzclpVar, zzijf zzijfVar) {
        this.f26533a = zzclpVar;
        this.f26534b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager(this.f26533a.a()).getPackageInfo(((ApplicationInfo) this.f26534b.zzb()).packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
