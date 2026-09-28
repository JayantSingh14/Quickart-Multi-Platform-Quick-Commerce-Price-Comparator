package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzkg implements zzkh {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpr f37883a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzpa f37884b;

    public zzkg(zzpr zzprVar, zzpa zzpaVar) {
        this.f37883a = zzprVar;
        this.f37884b = zzpaVar;
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final zzkb zza(Class cls) throws GeneralSecurityException {
        try {
            return new zzld(this.f37883a, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final zzkb zzb() {
        zzpr zzprVar = this.f37883a;
        return new zzld(zzprVar, zzprVar.f37993c);
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Class zzc() {
        return this.f37883a.getClass();
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Class zzd() {
        return this.f37884b.getClass();
    }

    @Override // com.google.android.gms.internal.pal.zzkh
    public final Set zze() {
        return this.f37883a.f37992b.keySet();
    }
}
