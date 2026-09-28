package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzanv implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final zzanw f23795a = new zzanw(null, 0, "audio/ac3");

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23796b = new zzer(2786);

    /* renamed from: c, reason: collision with root package name */
    public boolean f23797c;

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23797c = false;
        this.f23795a.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23795a.e(zzaerVar, new zzapu(Integer.MIN_VALUE, 0, 1));
        zzxk zzxkVar = (zzxk) zzaerVar;
        zzxkVar.h();
        zzxkVar.d(new zzafq(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        zzaef zzaefVar;
        int iA;
        zzer zzerVar = new zzer(10);
        int i2 = 0;
        while (true) {
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
        int i3 = 0;
        int i4 = i2;
        while (true) {
            zzaefVar.t(zzerVar.f30144a, 0, 6, false);
            zzerVar.E(0);
            if (zzerVar.L() != 2935) {
                zzaefVar2.f22874f = 0;
                i4++;
                if (i4 - i2 >= 8192) {
                    break;
                }
                zzaefVar.f(i4, false);
                i3 = 0;
            } else {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = zzerVar.f30144a;
                if (bArr.length < 6) {
                    iA = -1;
                } else if (((bArr[5] & 248) >> 3) > 10) {
                    int i5 = (((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1;
                    iA = i5 + i5;
                } else {
                    byte b2 = bArr[4];
                    iA = zzadp.a((b2 & 192) >> 6, b2 & 63);
                }
                if (iA == -1) {
                    break;
                }
                zzaefVar.f(iA - 6, false);
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) throws EOFException, InterruptedIOException {
        zzer zzerVar = this.f23796b;
        int iB = ((zzaef) zzaepVar).b(0, zzerVar.f30144a, 2786);
        if (iB == -1) {
            return -1;
        }
        zzerVar.E(0);
        zzerVar.C(iB);
        boolean z = this.f23797c;
        zzanw zzanwVar = this.f23795a;
        if (!z) {
            zzanwVar.n = 0L;
            this.f23797c = true;
        }
        zzanwVar.d(zzerVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
