package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzhg implements zzha {

    /* renamed from: a, reason: collision with root package name */
    public final Context f33747a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhi f33748b;

    public zzhg(Context context) {
        zzhi zzhiVar = new zzhi();
        this.f33747a = context.getApplicationContext();
        this.f33748b = zzhiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzha
    public final /* bridge */ /* synthetic */ zzhb zza() {
        return new zzhh(this.f33747a, this.f33748b.zza());
    }
}
