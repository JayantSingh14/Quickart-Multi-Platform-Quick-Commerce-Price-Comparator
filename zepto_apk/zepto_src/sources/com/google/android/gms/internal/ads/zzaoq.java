package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaoq implements zzaog {

    /* renamed from: b, reason: collision with root package name */
    public zzaga f23966b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23967c;

    /* renamed from: e, reason: collision with root package name */
    public int f23969e;

    /* renamed from: f, reason: collision with root package name */
    public int f23970f;

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23965a = new zzer(10);

    /* renamed from: d, reason: collision with root package name */
    public long f23968d = -9223372036854775807L;

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        if ((i2 & 4) == 0) {
            return;
        }
        this.f23967c = true;
        this.f23968d = j2;
        this.f23969e = 0;
        this.f23970f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
        int i2;
        this.f23966b.getClass();
        if (this.f23967c && (i2 = this.f23969e) != 0 && this.f23970f == i2) {
            zzgqa.f(this.f23968d != -9223372036854775807L);
            this.f23966b.e(this.f23968d, 1, this.f23969e, 0, null);
            this.f23967c = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void d(zzer zzerVar) {
        this.f23966b.getClass();
        if (this.f23967c) {
            int iB = zzerVar.B();
            int i2 = this.f23970f;
            if (i2 < 10) {
                int iMin = Math.min(iB, 10 - i2);
                byte[] bArr = zzerVar.f30144a;
                int i3 = zzerVar.f30145b;
                zzer zzerVar2 = this.f23965a;
                System.arraycopy(bArr, i3, zzerVar2.f30144a, this.f23970f, iMin);
                if (this.f23970f + iMin == 10) {
                    zzerVar2.E(0);
                    if (zzerVar2.K() != 73 || zzerVar2.K() != 68 || zzerVar2.K() != 51) {
                        zzee.c("Id3Reader", "Discarding invalid ID3 tag");
                        this.f23967c = false;
                        return;
                    } else {
                        zzerVar2.G(3);
                        this.f23969e = zzerVar2.g() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iB, this.f23969e - this.f23970f);
            this.f23966b.b(iMin2, zzerVar);
            this.f23970f += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 5);
        this.f23966b = zzagaVarE;
        zzt zztVar = new zzt();
        zzapuVar.b();
        zztVar.f35564a = zzapuVar.f24112e;
        zztVar.d("video/mp2t");
        zztVar.e("application/id3");
        zzagaVarE.c(new zzv(zztVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23967c = false;
        this.f23968d = -9223372036854775807L;
    }
}
