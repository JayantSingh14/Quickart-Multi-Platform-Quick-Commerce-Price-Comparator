package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzvw implements zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final zzhb f35735a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35736b;

    /* renamed from: c, reason: collision with root package name */
    public final zzvv f35737c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f35738d;

    /* renamed from: e, reason: collision with root package name */
    public int f35739e;

    public zzvw(zzhb zzhbVar, int i2, zzvv zzvvVar) {
        zzgqa.a(i2 > 0);
        this.f35735a = zzhbVar;
        this.f35736b = i2;
        this.f35737c = zzvvVar;
        this.f35738d = new byte[1];
        this.f35739e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        int i4 = this.f35739e;
        zzhb zzhbVar = this.f35735a;
        if (i4 == 0) {
            byte[] bArr2 = this.f35738d;
            int i5 = 0;
            if (zzhbVar.b(0, bArr2, 1) != -1) {
                int i6 = (bArr2[0] & 255) << 4;
                if (i6 != 0) {
                    byte[] bArr3 = new byte[i6];
                    int i7 = i6;
                    while (i7 > 0) {
                        int iB = zzhbVar.b(i5, bArr3, i7);
                        if (iB != -1) {
                            i5 += iB;
                            i7 -= iB;
                        }
                    }
                    while (i6 > 0) {
                        int i8 = i6 - 1;
                        if (bArr3[i8] != 0) {
                            break;
                        }
                        i6 = i8;
                    }
                    if (i6 > 0) {
                        zzer zzerVar = new zzer(bArr3, i6);
                        zzxb zzxbVar = (zzxb) this.f35737c;
                        long jMax = !zzxbVar.f35816l ? zzxbVar.f35813i : Math.max(zzxbVar.f35817m.t(true), zzxbVar.f35813i);
                        int iB2 = zzerVar.B();
                        zzaga zzagaVar = zzxbVar.f35815k;
                        zzagaVar.getClass();
                        zzagaVar.b(iB2, zzerVar);
                        zzagaVar.e(jMax, 1, iB2, 0, null);
                        zzxbVar.f35816l = true;
                    }
                }
                i4 = this.f35736b;
                this.f35739e = i4;
            }
            return -1;
        }
        int iB3 = zzhbVar.b(i2, bArr, Math.min(i4, i3));
        if (iB3 != -1) {
            this.f35739e -= iB3;
        }
        return iB3;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void c(zzhz zzhzVar) {
        zzhzVar.getClass();
        this.f35735a.c(zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f35735a.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        return this.f35735a.zzj();
    }
}
