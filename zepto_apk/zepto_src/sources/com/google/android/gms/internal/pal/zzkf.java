package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzkf implements zzkh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpa f37882a;

    public zzkf(zzpa zzpaVar) {
        this.f37882a = zzpaVar;
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final zzkb zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzkd(this.f37882a, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final zzkb zzb() {
        zzpa zzpaVar = this.f37882a;
        return new zzkd(zzpaVar, zzpaVar.f37993c);
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Class zzc() {
        return this.f37882a.getClass();
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Class zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Set zze() {
        return this.f37882a.f37992b.keySet();
    }
}
