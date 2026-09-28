package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
final class zzhzx implements zzidu {

    /* renamed from: a, reason: collision with root package name */
    public final zzhzw f34606a;

    public zzhzx(zzhzw zzhzwVar) {
        Charset charset = zzibe.f34660a;
        if (zzhzwVar == null) {
            throw new NullPointerException("output");
        }
        this.f34606a = zzhzwVar;
        zzhzwVar.f34605a = this;
    }

    public final void a(int i2, int i3) {
        this.f34606a.j(i2, i3);
    }

    public final void b(int i2, long j2) {
        this.f34606a.k(i2, j2);
    }

    public final void c(int i2, long j2) {
        this.f34606a.m(i2, j2);
    }

    public final void d(float f2, int i2) {
        this.f34606a.j(i2, Float.floatToRawIntBits(f2));
    }

    public final void e(int i2, double d2) {
        this.f34606a.m(i2, Double.doubleToRawLongBits(d2));
    }

    public final void f(int i2, int i3) {
        this.f34606a.h(i2, i3);
    }

    public final void g(int i2, long j2) {
        this.f34606a.k(i2, j2);
    }

    public final void h(int i2, int i3) {
        this.f34606a.h(i2, i3);
    }

    public final void i(int i2, long j2) {
        this.f34606a.m(i2, j2);
    }

    public final void j(int i2, int i3) {
        this.f34606a.j(i2, i3);
    }

    public final void k(int i2, boolean z) {
        this.f34606a.n(i2, z);
    }

    public final void l(int i2, zzhzl zzhzlVar) {
        this.f34606a.p(i2, zzhzlVar);
    }

    public final void m(int i2, int i3) {
        this.f34606a.i(i2, i3);
    }

    public final void n(int i2, int i3) {
        this.f34606a.i(i2, (i3 >> 31) ^ (i3 + i3));
    }

    public final void o(int i2, long j2) {
        this.f34606a.k(i2, (j2 >> 63) ^ (j2 + j2));
    }

    public final void p(int i2, Object obj, zzicu zzicuVar) {
        zzhyu zzhyuVar = (zzhyu) obj;
        zzhzw zzhzwVar = this.f34606a;
        zzhzwVar.g(i2, 2);
        zzhzwVar.x(zzhyuVar.i(zzicuVar));
        zzicuVar.h(zzhyuVar, this);
    }

    public final void q(int i2, Object obj, zzicu zzicuVar) {
        zzhzw zzhzwVar = this.f34606a;
        zzhzwVar.g(i2, 3);
        zzicuVar.h((zzhyu) obj, this);
        zzhzwVar.g(i2, 4);
    }
}
