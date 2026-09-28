package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzaob implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final zzaoc f23829a;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23830b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23831c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeq f23832d;

    /* renamed from: e, reason: collision with root package name */
    public zzaer f23833e;

    /* renamed from: f, reason: collision with root package name */
    public long f23834f;

    /* renamed from: g, reason: collision with root package name */
    public long f23835g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23836h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23837i;

    public zzaob() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23836h = false;
        this.f23829a.zza();
        this.f23834f = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23833e = zzaerVar;
        this.f23829a.e(zzaerVar, new zzapu(Integer.MIN_VALUE, 0, 1));
        ((zzxk) zzaerVar).h();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        zzer zzerVar;
        zzaef zzaefVar;
        int i2 = 0;
        while (true) {
            zzerVar = this.f23831c;
            zzaefVar = (zzaef) zzaepVar;
            zzaefVar.t(zzerVar.f30144a, 0, 10, false);
            zzerVar.E(0);
            if (zzerVar.O() != 4801587) {
                break;
            }
            zzerVar.G(3);
            int iG = zzerVar.g();
            i2 += iG + 10;
            zzaefVar.f(iG, false);
        }
        zzaef zzaefVar2 = (zzaef) zzaepVar;
        zzaefVar2.f22874f = 0;
        zzaefVar.f(i2, false);
        if (this.f23835g == -1) {
            this.f23835g = i2;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        do {
            zzaefVar.t(zzerVar.f30144a, 0, 2, false);
            zzerVar.E(0);
            if ((zzerVar.L() & 65526) == 65520) {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                zzaefVar.t(zzerVar.f30144a, 0, 4, false);
                zzeq zzeqVar = this.f23832d;
                zzeqVar.d(14);
                int iH = zzeqVar.h(13);
                if (iH <= 6) {
                    i5++;
                    zzaefVar2.f22874f = 0;
                    zzaefVar.f(i5, false);
                } else {
                    zzaefVar.f(iH - 6, false);
                    i4 += iH;
                }
            } else {
                i5++;
                zzaefVar2.f22874f = 0;
                zzaefVar.f(i5, false);
            }
            i3 = 0;
            i4 = 0;
        } while (i5 - i2 < 8192);
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) throws EOFException, InterruptedIOException {
        this.f23833e.getClass();
        zzer zzerVar = this.f23830b;
        int iB = ((zzaef) zzaepVar).b(0, zzerVar.f30144a, 2048);
        if (!this.f23837i) {
            ((zzxk) this.f23833e).d(new zzafq(-9223372036854775807L, 0L));
            this.f23837i = true;
        }
        if (iB == -1) {
            return -1;
        }
        zzerVar.E(0);
        zzerVar.C(iB);
        boolean z = this.f23836h;
        zzaoc zzaocVar = this.f23829a;
        if (!z) {
            zzaocVar.u = this.f23834f;
            this.f23836h = true;
        }
        zzaocVar.d(zzerVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzaob(int i2) {
        this.f23829a = new zzaoc(null, 0, "audio/mp4a-latm", true);
        this.f23830b = new zzer(2048);
        this.f23835g = -1L;
        zzer zzerVar = new zzer(10);
        this.f23831c = zzerVar;
        byte[] bArr = zzerVar.f30144a;
        this.f23832d = new zzeq(bArr, bArr.length);
    }
}
