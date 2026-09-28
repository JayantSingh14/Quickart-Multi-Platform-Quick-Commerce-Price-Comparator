package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzir implements zzlj {

    /* renamed from: a, reason: collision with root package name */
    public final zzmt f34960a;

    /* renamed from: b, reason: collision with root package name */
    public final zziq f34961b;

    /* renamed from: c, reason: collision with root package name */
    public zzmi f34962c;

    /* renamed from: d, reason: collision with root package name */
    public zzlj f34963d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34964e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34965f;

    public zzir(zziq zziqVar) {
        this.f34961b = zziqVar;
        zzmt zzmtVar = new zzmt();
        zzmtVar.f35231d = zzav.f24411d;
        this.f34960a = zzmtVar;
        this.f34964e = true;
    }

    public final void a(zzmi zzmiVar) {
        zzlj zzljVar;
        zzlj zzljVarZzd = zzmiVar.zzd();
        if (zzljVarZzd == null || zzljVarZzd == (zzljVar = this.f34963d)) {
            return;
        }
        if (zzljVar != null) {
            throw new zzit(2, new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.f34963d = zzljVarZzd;
        this.f34962c = zzmiVar;
        ((zzsw) zzljVarZzd).s(this.f34960a.f35231d);
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final void s(zzav zzavVar) {
        zzlj zzljVar = this.f34963d;
        if (zzljVar != null) {
            zzljVar.s(zzavVar);
            zzavVar = this.f34963d.zzj();
        }
        this.f34960a.s(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final long zzg() {
        if (this.f34964e) {
            return this.f34960a.zzg();
        }
        zzlj zzljVar = this.f34963d;
        zzljVar.getClass();
        return zzljVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final boolean zzh() {
        if (this.f34964e) {
            return false;
        }
        zzlj zzljVar = this.f34963d;
        zzljVar.getClass();
        return zzljVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzlj
    public final zzav zzj() {
        zzlj zzljVar = this.f34963d;
        return zzljVar != null ? zzljVar.zzj() : this.f34960a.f35231d;
    }
}
