package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzaof implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final List f23865a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaga[] f23866b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23867c;

    /* renamed from: d, reason: collision with root package name */
    public int f23868d;

    /* renamed from: e, reason: collision with root package name */
    public int f23869e;

    /* renamed from: f, reason: collision with root package name */
    public long f23870f = -9223372036854775807L;

    public zzaof(List list) {
        this.f23865a = list;
        this.f23866b = new zzaga[list.size()];
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        if ((i2 & 4) == 0) {
            return;
        }
        this.f23867c = true;
        this.f23870f = j2;
        this.f23869e = 0;
        this.f23868d = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
        if (!this.f23867c) {
            return;
        }
        zzgqa.f(this.f23870f != -9223372036854775807L);
        int i2 = 0;
        while (true) {
            zzaga[] zzagaVarArr = this.f23866b;
            if (i2 >= zzagaVarArr.length) {
                this.f23867c = false;
                return;
            } else {
                zzagaVarArr[i2].e(this.f23870f, 1, this.f23869e, 0, null);
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void d(zzer zzerVar) {
        boolean z;
        boolean z2;
        if (!this.f23867c) {
            return;
        }
        int i2 = 0;
        if (this.f23868d == 2) {
            if (zzerVar.B() == 0) {
                z2 = false;
            } else {
                if (zzerVar.K() != 32) {
                    this.f23867c = false;
                }
                this.f23868d--;
                z2 = this.f23867c;
            }
            if (!z2) {
                return;
            }
        }
        if (this.f23868d == 1) {
            if (zzerVar.B() == 0) {
                z = false;
            } else {
                if (zzerVar.K() != 0) {
                    this.f23867c = false;
                }
                this.f23868d--;
                z = this.f23867c;
            }
            if (!z) {
                return;
            }
        }
        int i3 = zzerVar.f30145b;
        int iB = zzerVar.B();
        while (true) {
            zzaga[] zzagaVarArr = this.f23866b;
            if (i2 >= zzagaVarArr.length) {
                this.f23869e += iB;
                return;
            }
            zzaga zzagaVar = zzagaVarArr[i2];
            zzerVar.E(i3);
            zzagaVar.b(iB, zzerVar);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        int i2 = 0;
        while (true) {
            zzaga[] zzagaVarArr = this.f23866b;
            if (i2 >= zzagaVarArr.length) {
                return;
            }
            zzapr zzaprVar = (zzapr) this.f23865a.get(i2);
            zzapuVar.a();
            zzapuVar.b();
            zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 3);
            zzt zztVar = new zzt();
            zzapuVar.b();
            zztVar.f35564a = zzapuVar.f24112e;
            zztVar.d("video/mp2t");
            zztVar.e("application/dvbsubs");
            zztVar.o = Collections.singletonList(zzaprVar.f24104b);
            zztVar.f35567d = zzaprVar.f24103a;
            zzagaVarE.c(new zzv(zztVar));
            zzagaVarArr[i2] = zzagaVarE;
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23867c = false;
        this.f23870f = -9223372036854775807L;
    }
}
