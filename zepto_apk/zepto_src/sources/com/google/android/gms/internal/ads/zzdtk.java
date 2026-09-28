package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdtk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeoj f28520a;

    /* renamed from: b, reason: collision with root package name */
    public final zzeoj f28521b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdab f28522c;

    public zzdtk(zzeoj zzeojVar, zzeoj zzeojVar2, zzdab zzdabVar) {
        this.f28520a = zzeojVar;
        this.f28521b = zzeojVar2;
        this.f28522c = zzdabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* synthetic */ Object zzb() {
        int i2 = this.f28522c.a().p.f31184a;
        if (i2 != 0) {
            return i2 + (-1) != 0 ? this.f28521b.zzb() : this.f28520a.zzb();
        }
        throw null;
    }
}
