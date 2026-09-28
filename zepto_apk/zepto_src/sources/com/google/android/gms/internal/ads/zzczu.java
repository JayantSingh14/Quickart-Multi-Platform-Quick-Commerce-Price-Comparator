package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzczu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzczt f27525a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27526b;

    public zzczu(zzczt zzcztVar, zzijf zzijfVar) {
        this.f27525a = zzcztVar;
        this.f27526b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        String str = (String) this.f27526b.zzb();
        zzejl zzejlVar = this.f27525a.f27523f;
        return zzejlVar != null ? zzejlVar : new zzejl(str);
    }
}
