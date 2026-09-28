package com.google.android.gms.internal.ads;

import android.util.Pair;

/* loaded from: classes4.dex */
final class zzlk {

    /* renamed from: a, reason: collision with root package name */
    public final Object f35096a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f35097b;

    /* renamed from: c, reason: collision with root package name */
    public final zzxw[] f35098c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f35099d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f35100e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35101f;

    /* renamed from: g, reason: collision with root package name */
    public zzll f35102g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f35103h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean[] f35104i;

    /* renamed from: j, reason: collision with root package name */
    public final zzmk[] f35105j;

    /* renamed from: k, reason: collision with root package name */
    public final zzaad f35106k;

    /* renamed from: l, reason: collision with root package name */
    public final zzlz f35107l;

    /* renamed from: m, reason: collision with root package name */
    public zzlk f35108m;
    public zzyh n;
    public zzaae o;
    public long p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.google.android.gms.internal.ads.zzvk] */
    public zzlk(zzmk[] zzmkVarArr, long j2, zzaad zzaadVar, zzaah zzaahVar, zzlz zzlzVar, zzll zzllVar, zzaae zzaaeVar) {
        this.f35105j = zzmkVarArr;
        this.p = j2;
        this.f35106k = zzaadVar;
        this.f35107l = zzlzVar;
        zzwg zzwgVar = zzllVar.f35109a;
        this.f35097b = zzwgVar.f35758a;
        this.f35102g = zzllVar;
        this.n = zzyh.f35904d;
        this.o = zzaaeVar;
        this.f35098c = new zzxw[2];
        this.f35104i = new boolean[2];
        zzlzVar.getClass();
        int i2 = zzmg.f35203k;
        Pair pair = (Pair) zzwgVar.f35758a;
        Object obj = pair.first;
        zzwg zzwgVarA = zzwgVar.a(pair.second);
        zzlw zzlwVar = (zzlw) zzlzVar.f35169d.get(obj);
        zzlwVar.getClass();
        zzlzVar.f35172g.add(zzlwVar);
        zzlv zzlvVar = (zzlv) zzlzVar.f35171f.get(zzlwVar);
        if (zzlvVar != null) {
            zzlvVar.f35157a.j(zzlvVar.f35158b);
        }
        zzlwVar.f35162c.add(zzwgVarA);
        zzvy zzvyVarL = zzlwVar.f35160a.l(zzwgVarA, zzaahVar, zzllVar.f35110b);
        zzlzVar.f35168c.put(zzvyVarL, zzlwVar);
        zzlzVar.k();
        long j3 = zzllVar.f35112d;
        this.f35096a = j3 != -9223372036854775807L ? new zzvk(zzvyVarL, j3) : zzvyVarL;
    }

    public final long a() {
        return this.f35102g.f35110b + this.p;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    public final boolean b() {
        if (this.f35100e) {
            return !this.f35101f || this.f35096a.zzi() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean c() {
        if (this.f35100e) {
            return b() || d() - this.f35102g.f35110b >= -9223372036854775807L;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.gms.internal.ads.zzxy, java.lang.Object] */
    public final long d() {
        if (!this.f35100e) {
            return this.f35102g.f35110b;
        }
        long jZzi = this.f35101f ? this.f35096a.zzi() : Long.MIN_VALUE;
        return jZzi == Long.MIN_VALUE ? this.f35102g.f35113e : jZzi;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    public final void e(zzbf zzbfVar) {
        this.f35100e = true;
        this.n = this.f35096a.zzd();
        zzaae zzaaeVarF = f(zzbfVar);
        zzll zzllVar = this.f35102g;
        long j2 = zzllVar.f35113e;
        long jMax = zzllVar.f35110b;
        if (j2 != -9223372036854775807L && jMax >= j2) {
            jMax = Math.max(0L, j2 - 1);
        }
        long jG = g(zzaaeVarF, jMax, false, new boolean[2]);
        long j3 = this.p;
        zzll zzllVar2 = this.f35102g;
        this.p = (zzllVar2.f35110b - jG) + j3;
        this.f35102g = zzllVar2.a(jG);
    }

    public final zzaae f(zzbf zzbfVar) {
        zzzw[] zzzwVarArr;
        zzyh zzyhVar = this.n;
        zzll zzllVar = this.f35102g;
        zzaad zzaadVar = this.f35106k;
        zzmk[] zzmkVarArr = this.f35105j;
        zzaae zzaaeVarF = zzaadVar.f(zzmkVarArr, zzyhVar, zzllVar.f35109a, zzbfVar);
        int i2 = 0;
        while (true) {
            int i3 = zzaaeVarF.f22578a;
            zzzwVarArr = zzaaeVarF.f22580c;
            if (i2 >= i3) {
                break;
            }
            if (zzaaeVarF.a(i2)) {
                if (zzzwVarArr[i2] == null) {
                    zzmkVarArr[i2].getClass();
                    z = false;
                }
                zzgqa.f(z);
            } else {
                zzgqa.f(zzzwVarArr[i2] == null);
            }
            i2++;
        }
        for (zzzw zzzwVar : zzzwVarArr) {
        }
        return zzaaeVarF;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    public final long g(zzaae zzaaeVar, long j2, boolean z, boolean[] zArr) {
        zzmk[] zzmkVarArr;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= zzaaeVar.f22578a) {
                break;
            }
            if (z || !zzaaeVar.b(this.o, i2)) {
                z2 = false;
            }
            this.f35104i[i2] = z2;
            i2++;
        }
        int i3 = 0;
        while (true) {
            zzmkVarArr = this.f35105j;
            if (i3 >= 2) {
                break;
            }
            zzmkVarArr[i3].getClass();
            i3++;
        }
        l();
        this.o = zzaaeVar;
        if (this.f35108m == null) {
            int i4 = 0;
            while (true) {
                zzaae zzaaeVar2 = this.o;
                if (i4 >= zzaaeVar2.f22578a) {
                    break;
                }
                zzaaeVar2.a(i4);
                zzzw zzzwVar = this.o.f22580c[i4];
                i4++;
            }
        }
        ?? r5 = this.f35096a;
        zzzw[] zzzwVarArr = zzaaeVar.f22580c;
        boolean[] zArr2 = this.f35104i;
        zzxw[] zzxwVarArr = this.f35098c;
        long jF = r5.f(zzzwVarArr, zArr2, zzxwVarArr, zArr, j2);
        for (int i5 = 0; i5 < 2; i5++) {
            zzmkVarArr[i5].getClass();
        }
        this.f35101f = false;
        for (int i6 = 0; i6 < 2; i6++) {
            if (zzxwVarArr[i6] != null) {
                zzgqa.f(zzaaeVar.a(i6));
                zzmkVarArr[i6].getClass();
                this.f35101f = true;
            } else {
                zzgqa.f(zzzwVarArr[i6] == null);
            }
        }
        return jF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzwe, java.lang.Object] */
    public final void h() {
        l();
        ?? r0 = this.f35096a;
        try {
            boolean z = r0 instanceof zzvk;
            zzlz zzlzVar = this.f35107l;
            if (z) {
                zzlzVar.d(((zzvk) r0).f35710a);
            } else {
                zzlzVar.d(r0);
            }
        } catch (RuntimeException e2) {
            zzee.f("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public final zzlk i() {
        return this.f35108m;
    }

    public final zzyh j() {
        return this.n;
    }

    public final zzaae k() {
        return this.o;
    }

    public final void l() {
        if (this.f35108m != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            zzaae zzaaeVar = this.o;
            if (i2 >= zzaaeVar.f22578a) {
                return;
            }
            zzaaeVar.a(i2);
            zzzw zzzwVar = this.o.f22580c[i2];
            i2++;
        }
    }
}
