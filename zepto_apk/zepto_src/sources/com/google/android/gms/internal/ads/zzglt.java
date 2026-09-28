package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzglt implements zzgls {

    /* renamed from: a, reason: collision with root package name */
    public final zzija f32872a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgnc f32873b;

    /* renamed from: c, reason: collision with root package name */
    public final long f32874c;

    public zzglt(zzija zzijaVar, zzgnc zzgncVar, long j2) {
        this.f32872a = zzijaVar;
        this.f32873b = zzgncVar;
        this.f32874c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzgls
    public final boolean a(zzgcs zzgcsVar) {
        zzgnc zzgncVar = this.f32873b;
        if (zzgcsVar == null || zzgcsVar.equals(zzgcs.H())) {
            zzgncVar.b(15102);
            return false;
        }
        if (zzgcsVar.E() == this.f32872a.zzb()) {
            return true;
        }
        zzgncVar.b(15103);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgls
    public final boolean b(zzgcs zzgcsVar) {
        zzgnc zzgncVar = this.f32873b;
        if (zzgcsVar == null || zzgcsVar.equals(zzgcs.H())) {
            zzgncVar.b(15104);
            return true;
        }
        if (zzgcsVar.E() != this.f32872a.zzb()) {
            zzgncVar.b(15105);
            return true;
        }
        boolean z = (zzgcsVar.C().E() * 1000) - System.currentTimeMillis() <= this.f32874c;
        if (z) {
            zzgncVar.b(15106);
        }
        return z;
    }
}
