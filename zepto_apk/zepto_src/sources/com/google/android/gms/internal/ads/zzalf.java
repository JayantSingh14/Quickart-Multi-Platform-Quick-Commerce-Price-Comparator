package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzalf implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public zzaer f23471a;

    /* renamed from: b, reason: collision with root package name */
    public zzalm f23472b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23473c;

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        zzalm zzalmVar = this.f23472b;
        if (zzalmVar != null) {
            zzalg zzalgVar = zzalmVar.f23488a;
            zzalh zzalhVar = zzalgVar.f23474a;
            zzalhVar.f23479a = 0;
            zzalhVar.f23480b = 0L;
            zzalhVar.f23481c = 0;
            zzalhVar.f23482d = 0;
            zzalhVar.f23483e = 0;
            zzalgVar.f23475b.y(0);
            zzalgVar.f23476c = -1;
            zzalgVar.f23478e = false;
            if (j2 == 0) {
                zzalmVar.a(!zzalmVar.f23499l);
                return;
            }
            if (zzalmVar.f23495h != 0) {
                long j4 = (zzalmVar.f23496i * j3) / 1000000;
                zzalmVar.f23492e = j4;
                zzali zzaliVar = zzalmVar.f23491d;
                String str = zzfj.f31254a;
                zzaliVar.a(j4);
                zzalmVar.f23495h = 2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23471a = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        try {
            return e((zzaef) zzaepVar);
        } catch (zzat unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0173 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r22, com.google.android.gms.internal.ads.zzafo r23) throws com.google.android.gms.internal.ads.zzat, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalf.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final boolean e(zzaef zzaefVar) {
        zzalh zzalhVar = new zzalh();
        if (zzalhVar.b(zzaefVar, true) && (zzalhVar.f23479a & 2) == 2) {
            int iMin = Math.min(zzalhVar.f23483e, 8);
            zzer zzerVar = new zzer(iMin);
            zzaefVar.t(zzerVar.f30144a, 0, iMin, false);
            zzerVar.E(0);
            if (zzerVar.B() >= 5 && zzerVar.K() == 127 && zzerVar.P() == 1179402563) {
                this.f23472b = new zzald();
                return true;
            }
            zzerVar.E(0);
            try {
                if (zzagg.d(1, zzerVar, true)) {
                    this.f23472b = new zzalo();
                    return true;
                }
            } catch (zzat unused) {
            }
            zzerVar.E(0);
            if (zzalj.e(zzerVar, zzalj.o)) {
                this.f23472b = new zzalj();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
