package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajq {

    /* renamed from: a, reason: collision with root package name */
    public final int f23301a;

    /* renamed from: b, reason: collision with root package name */
    public int f23302b;

    /* renamed from: c, reason: collision with root package name */
    public int f23303c;

    /* renamed from: d, reason: collision with root package name */
    public long f23304d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f23305e;

    /* renamed from: f, reason: collision with root package name */
    public final zzer f23306f;

    /* renamed from: g, reason: collision with root package name */
    public final zzer f23307g;

    /* renamed from: h, reason: collision with root package name */
    public int f23308h;

    /* renamed from: i, reason: collision with root package name */
    public int f23309i;

    public zzajq(zzer zzerVar, zzer zzerVar2, boolean z) throws zzat {
        this.f23307g = zzerVar;
        this.f23306f = zzerVar2;
        this.f23305e = z;
        zzerVar2.E(12);
        this.f23301a = zzerVar2.h();
        zzerVar.E(12);
        this.f23309i = zzerVar.h();
        zzaes.a("first_chunk must be 1", zzerVar.b() == 1);
        this.f23302b = -1;
    }

    public final boolean a() {
        int i2 = this.f23302b + 1;
        this.f23302b = i2;
        if (i2 == this.f23301a) {
            return false;
        }
        boolean z = this.f23305e;
        zzer zzerVar = this.f23306f;
        this.f23304d = z ? zzerVar.j() : zzerVar.P();
        if (this.f23302b == this.f23308h) {
            zzer zzerVar2 = this.f23307g;
            this.f23303c = zzerVar2.h();
            zzerVar2.G(4);
            int i3 = this.f23309i - 1;
            this.f23309i = i3;
            this.f23308h = i3 > 0 ? (-1) + zzerVar2.h() : -1;
        }
        return true;
    }
}
