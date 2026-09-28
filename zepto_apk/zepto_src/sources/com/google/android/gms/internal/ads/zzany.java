package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzany implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final zzanz f23812a = new zzanz(null, 0, "audio/ac4");

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23813b = new zzer(16384);

    /* renamed from: c, reason: collision with root package name */
    public boolean f23814c;

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23814c = false;
        this.f23812a.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23812a.e(zzaerVar, new zzapu(Integer.MIN_VALUE, 0, 1));
        zzxk zzxkVar = (zzxk) zzaerVar;
        zzxkVar.h();
        zzxkVar.d(new zzafq(-9223372036854775807L, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        zzaef zzaefVar;
        int i2;
        zzer zzerVar = new zzer(10);
        int i3 = 0;
        while (true) {
            zzaefVar = (zzaef) zzaepVar;
            zzaefVar.t(zzerVar.f30144a, 0, 10, false);
            zzerVar.E(0);
            if (zzerVar.O() != 4801587) {
                break;
            }
            zzerVar.G(3);
            int iG = zzerVar.g();
            i3 += iG + 10;
            zzaefVar.f(iG, false);
        }
        zzaef zzaefVar2 = (zzaef) zzaepVar;
        zzaefVar2.f22874f = 0;
        zzaefVar.f(i3, false);
        int i4 = 0;
        int i5 = i3;
        while (true) {
            int i6 = 7;
            zzaefVar.t(zzerVar.f30144a, 0, 7, false);
            zzerVar.E(0);
            int iL = zzerVar.L();
            if (iL != 44096 && iL != 44097) {
                zzaefVar2.f22874f = 0;
                i5++;
                if (i5 - i3 >= 8192) {
                    break;
                }
                zzaefVar.f(i5, false);
                i4 = 0;
            } else {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                byte[] bArr = zzerVar.f30144a;
                if (bArr.length < 7) {
                    i2 = -1;
                } else {
                    int i7 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    if (i7 == 65535) {
                        i7 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                    } else {
                        i6 = 4;
                    }
                    if (iL == 44097) {
                        i6 += 2;
                    }
                    i2 = i7 + i6;
                }
                if (i2 == -1) {
                    break;
                }
                zzaefVar.f(i2 - 7, false);
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) throws EOFException, InterruptedIOException {
        zzer zzerVar = this.f23813b;
        int iB = ((zzaef) zzaepVar).b(0, zzerVar.f30144a, 16384);
        if (iB == -1) {
            return -1;
        }
        zzerVar.E(0);
        zzerVar.C(iB);
        boolean z = this.f23814c;
        zzanz zzanzVar = this.f23812a;
        if (!z) {
            zzanzVar.n = 0L;
            this.f23814c = true;
        }
        zzanzVar.d(zzerVar);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
