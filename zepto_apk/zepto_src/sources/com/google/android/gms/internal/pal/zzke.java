package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzke implements zzkh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzkb f37881a;

    public zzke(zzkb zzkbVar) {
        this.f37881a = zzkbVar;
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final zzkb zza(Class cls) {
        zzkb zzkbVar = this.f37881a;
        if (zzkbVar.zzc().equals(cls)) {
            return zzkbVar;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final zzkb zzb() {
        return this.f37881a;
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Class zzc() {
        return this.f37881a.getClass();
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Class zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Set zze() {
        return Collections.singleton(this.f37881a.zzc());
    }
}
