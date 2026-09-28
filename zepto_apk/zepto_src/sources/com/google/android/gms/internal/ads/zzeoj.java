package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzeoj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29963a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29964b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijp f29965c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijg f29966d;

    public zzeoj(zzijf zzijfVar, zzijf zzijfVar2, zzijp zzijpVar, zzijg zzijgVar) {
        this.f29963a = zzijfVar;
        this.f29964b = zzijfVar2;
        this.f29965c = zzijpVar;
        this.f29966d = zzijgVar;
    }

    public static zzeoj b(zzijf zzijfVar, zzijf zzijfVar2, zzijp zzijpVar, zzijg zzijgVar) {
        return new zzeoj(zzijfVar, zzijfVar2, zzijpVar, zzijgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzeoi zzb() {
        return new zzeoi((zzfmu) this.f29963a.zzb(), (zzgyw) this.f29964b.zzb(), (zzeji) this.f29965c.zzb(), (zzejm) this.f29966d.zzb());
    }
}
