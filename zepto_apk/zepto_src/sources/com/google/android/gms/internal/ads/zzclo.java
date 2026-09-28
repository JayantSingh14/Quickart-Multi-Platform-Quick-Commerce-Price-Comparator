package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* loaded from: classes4.dex */
public final class zzclo implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f26519a;

    public zzclo(zzclp zzclpVar) {
        this.f26519a = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo applicationInfo = this.f26519a.a().getApplicationInfo();
        zzijo.a(applicationInfo);
        return applicationInfo;
    }
}
