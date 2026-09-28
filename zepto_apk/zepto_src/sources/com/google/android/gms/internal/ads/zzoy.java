package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzoy {

    /* renamed from: a, reason: collision with root package name */
    public final zzbd f35262a;

    /* renamed from: b, reason: collision with root package name */
    public zzgtd f35263b;

    /* renamed from: c, reason: collision with root package name */
    public zzgtg f35264c;

    /* renamed from: d, reason: collision with root package name */
    public zzwg f35265d;

    /* renamed from: e, reason: collision with root package name */
    public zzwg f35266e;

    /* renamed from: f, reason: collision with root package name */
    public zzwg f35267f;

    public zzoy(zzbd zzbdVar) {
        this.f35262a = zzbdVar;
        zzgvs zzgvsVar = zzgtd.f33183b;
        this.f35263b = zzguy.f33232e;
        this.f35264c = zzgvd.f33244g;
    }

    public static zzwg c(zzms zzmsVar, zzgtd zzgtdVar, zzwg zzwgVar, zzbd zzbdVar) {
        zzbf zzbfVarZzq = zzmsVar.zzq();
        zzmsVar.f35227c.b();
        int iQ = zzmsVar.f35226b.q();
        Object objF = zzbfVarZzq.g() ? null : zzbfVarZzq.f(iQ);
        if (!zzmsVar.f() && !zzbfVarZzq.g()) {
            zzbd zzbdVarD = zzbfVarZzq.d(iQ, zzbdVar, false);
            zzmsVar.d();
            String str = zzfj.f31254a;
            zzbdVarD.getClass();
        }
        for (int i2 = 0; i2 < zzgtdVar.size(); i2++) {
            zzwg zzwgVar2 = (zzwg) zzgtdVar.get(i2);
            if (d(zzwgVar2, objF, zzmsVar.f(), zzmsVar.g(), zzmsVar.h())) {
                return zzwgVar2;
            }
        }
        if (zzgtdVar.isEmpty() && zzwgVar != null && d(zzwgVar, objF, zzmsVar.f(), zzmsVar.g(), zzmsVar.h())) {
            return zzwgVar;
        }
        return null;
    }

    public static boolean d(zzwg zzwgVar, Object obj, boolean z, int i2, int i3) {
        if (!zzwgVar.f35758a.equals(obj)) {
            return false;
        }
        int i4 = zzwgVar.f35759b;
        return z ? i4 == i2 && zzwgVar.f35760c == i3 : i4 == -1 && zzwgVar.f35762e == -1;
    }

    public final void a(zzbf zzbfVar) {
        zzgtf zzgtfVar = new zzgtf();
        if (this.f35263b.isEmpty()) {
            b(zzgtfVar, this.f35266e, zzbfVar);
            if (!Objects.equals(this.f35267f, this.f35266e)) {
                b(zzgtfVar, this.f35267f, zzbfVar);
            }
            if (!Objects.equals(this.f35265d, this.f35266e) && !Objects.equals(this.f35265d, this.f35267f)) {
                b(zzgtfVar, this.f35265d, zzbfVar);
            }
        } else {
            for (int i2 = 0; i2 < this.f35263b.size(); i2++) {
                b(zzgtfVar, (zzwg) this.f35263b.get(i2), zzbfVar);
            }
            if (!this.f35263b.contains(this.f35265d)) {
                b(zzgtfVar, this.f35265d, zzbfVar);
            }
        }
        this.f35264c = zzgtfVar.d(true);
    }

    public final void b(zzgtf zzgtfVar, zzwg zzwgVar, zzbf zzbfVar) {
        if (zzwgVar == null) {
            return;
        }
        if (zzbfVar.e(zzwgVar.f35758a) != -1) {
            zzgtfVar.a(zzwgVar, zzbfVar);
            return;
        }
        zzbf zzbfVar2 = (zzbf) this.f35264c.get(zzwgVar);
        if (zzbfVar2 != null) {
            zzgtfVar.a(zzwgVar, zzbfVar2);
        }
    }
}
