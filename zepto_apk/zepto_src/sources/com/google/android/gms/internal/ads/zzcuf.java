package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzcuf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcua f27164a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27165b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27166c;

    public zzcuf(zzcua zzcuaVar, zzijf zzijfVar, zzcwb zzcwbVar) {
        this.f27164a = zzcuaVar;
        this.f27165b = zzijfVar;
        this.f27166c = zzcwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzctj zzctjVar = this.f27164a.f27154a;
        return new zzcue(zzctjVar.f27120d, (zzdxe) this.f27165b.zzb(), this.f27166c.a());
    }
}
