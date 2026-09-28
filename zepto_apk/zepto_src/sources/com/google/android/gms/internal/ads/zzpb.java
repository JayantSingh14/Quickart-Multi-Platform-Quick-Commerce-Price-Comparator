package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzpb {

    /* renamed from: a, reason: collision with root package name */
    public final String f35283a;

    /* renamed from: b, reason: collision with root package name */
    public int f35284b;

    /* renamed from: c, reason: collision with root package name */
    public long f35285c;

    /* renamed from: d, reason: collision with root package name */
    public final zzwg f35286d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f35287e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35288f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzpc f35289g;

    public zzpb(zzpc zzpcVar, String str, int i2, zzwg zzwgVar) {
        Objects.requireNonNull(zzpcVar);
        this.f35289g = zzpcVar;
        this.f35283a = str;
        this.f35284b = i2;
        this.f35285c = zzwgVar == null ? -1L : zzwgVar.f35761d;
        if (zzwgVar == null || !zzwgVar.b()) {
            return;
        }
        this.f35286d = zzwgVar;
    }

    public final boolean a(zzbf zzbfVar, zzbf zzbfVar2) {
        zzwg zzwgVar;
        int i2 = this.f35284b;
        if (i2 < zzbfVar.a()) {
            zzpc zzpcVar = this.f35289g;
            zzbfVar.b(i2, zzpcVar.f35292a, 0L);
            zzbe zzbeVar = zzpcVar.f35292a;
            for (int i3 = zzbeVar.f24833k; i3 <= zzbeVar.f24834l; i3++) {
                int iE = zzbfVar2.e(zzbfVar.f(i3));
                if (iE != -1) {
                    i2 = zzbfVar2.d(iE, zzpcVar.f35293b, false).f24739c;
                    break;
                }
            }
            i2 = -1;
        } else if (i2 >= zzbfVar2.a()) {
            i2 = -1;
        }
        this.f35284b = i2;
        return i2 != -1 && ((zzwgVar = this.f35286d) == null || zzbfVar2.e(zzwgVar.f35758a) != -1);
    }

    public final boolean b(zzmv zzmvVar) {
        zzwg zzwgVar = zzmvVar.f35235d;
        if (zzwgVar == null) {
            return this.f35284b != zzmvVar.f35234c;
        }
        long j2 = this.f35285c;
        if (j2 == -1) {
            return false;
        }
        long j3 = zzwgVar.f35761d;
        if (j3 > j2) {
            return true;
        }
        zzwg zzwgVar2 = this.f35286d;
        if (zzwgVar2 == null) {
            return false;
        }
        zzbf zzbfVar = zzmvVar.f35233b;
        int iE = zzbfVar.e(zzwgVar.f35758a);
        int iE2 = zzbfVar.e(zzwgVar2.f35758a);
        if (j3 < zzwgVar2.f35761d || iE < iE2) {
            return false;
        }
        if (iE > iE2) {
            return true;
        }
        boolean zB = zzwgVar.b();
        int i2 = zzwgVar2.f35759b;
        if (!zB) {
            int i3 = zzwgVar.f35762e;
            return i3 == -1 || i3 > i2;
        }
        int i4 = zzwgVar.f35759b;
        if (i4 > i2) {
            return true;
        }
        if (i4 == i2) {
            return zzwgVar.f35760c > zzwgVar2.f35760c;
        }
        return false;
    }
}
