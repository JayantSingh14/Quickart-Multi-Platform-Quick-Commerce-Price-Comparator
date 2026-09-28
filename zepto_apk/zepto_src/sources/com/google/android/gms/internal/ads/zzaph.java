package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaph implements zzapv {

    /* renamed from: a, reason: collision with root package name */
    public final zzapg f24061a;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f24062b = new zzer(32);

    /* renamed from: c, reason: collision with root package name */
    public int f24063c;

    /* renamed from: d, reason: collision with root package name */
    public int f24064d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f24065e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f24066f;

    public zzaph(zzapg zzapgVar) {
        this.f24061a = zzapgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapv
    public final void a(zzfg zzfgVar, zzaer zzaerVar, zzapu zzapuVar) {
        this.f24061a.a(zzfgVar, zzaerVar, zzapuVar);
        this.f24066f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzapv
    public final void b(int i2, zzer zzerVar) {
        int i3 = i2 & 1;
        int iK = i3 != 0 ? zzerVar.f30145b + zzerVar.K() : -1;
        if (this.f24066f) {
            if (i3 == 0) {
                return;
            }
            this.f24066f = false;
            zzerVar.E(iK);
            this.f24064d = 0;
        }
        while (zzerVar.B() > 0) {
            int i4 = this.f24064d;
            zzer zzerVar2 = this.f24062b;
            if (i4 < 3) {
                if (i4 == 0) {
                    int iK2 = zzerVar.K();
                    zzerVar.E(zzerVar.f30145b - 1);
                    if (iK2 == 255) {
                        this.f24066f = true;
                        return;
                    }
                }
                int iMin = Math.min(zzerVar.B(), 3 - this.f24064d);
                zzerVar.H(this.f24064d, zzerVar2.f30144a, iMin);
                int i5 = this.f24064d + iMin;
                this.f24064d = i5;
                if (i5 == 3) {
                    zzerVar2.E(0);
                    zzerVar2.C(3);
                    zzerVar2.G(1);
                    int iK3 = zzerVar2.K();
                    boolean z = (iK3 & 128) != 0;
                    int iK4 = zzerVar2.K();
                    this.f24065e = z;
                    int i6 = (((iK3 & 15) << 8) | iK4) + 3;
                    this.f24063c = i6;
                    byte[] bArr = zzerVar2.f30144a;
                    if (bArr.length < i6) {
                        int length = bArr.length;
                        zzerVar2.A(Math.min(4098, Math.max(i6, length + length)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzerVar.B(), this.f24063c - this.f24064d);
                zzerVar.H(this.f24064d, zzerVar2.f30144a, iMin2);
                int i7 = this.f24064d + iMin2;
                this.f24064d = i7;
                int i8 = this.f24063c;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.f24065e) {
                        zzerVar2.C(i8);
                    } else {
                        if (zzfj.f(0, i8, zzerVar2.f30144a, -1) != 0) {
                            this.f24066f = true;
                            return;
                        }
                        zzerVar2.C(this.f24063c - 4);
                    }
                    zzerVar2.E(0);
                    this.f24061a.b(zzerVar2);
                    this.f24064d = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapv
    public final void zzb() {
        this.f24066f = true;
    }
}
