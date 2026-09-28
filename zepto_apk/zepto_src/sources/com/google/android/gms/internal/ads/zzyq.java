package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class zzyq implements zzzw {

    /* renamed from: a, reason: collision with root package name */
    public final zzbg f35913a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35914b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f35915c;

    /* renamed from: d, reason: collision with root package name */
    public final zzv[] f35916d;

    /* renamed from: e, reason: collision with root package name */
    public int f35917e;

    public zzyq(zzbg zzbgVar, int[] iArr) {
        zzv[] zzvVarArr;
        int length = iArr.length;
        zzgqa.f(length > 0);
        zzbgVar.getClass();
        this.f35913a = zzbgVar;
        this.f35914b = length;
        this.f35916d = new zzv[length];
        int i2 = 0;
        while (true) {
            int length2 = iArr.length;
            zzvVarArr = zzbgVar.f24986d;
            if (i2 >= length2) {
                break;
            }
            this.f35916d[i2] = zzvVarArr[iArr[i2]];
            i2++;
        }
        Arrays.sort(this.f35916d, zzyp.f35912a);
        this.f35915c = new int[this.f35914b];
        for (int i3 = 0; i3 < this.f35914b; i3++) {
            int[] iArr2 = this.f35915c;
            zzv zzvVar = this.f35916d[i3];
            int i4 = 0;
            while (true) {
                if (i4 >= zzvVarArr.length) {
                    i4 = -1;
                    break;
                } else if (zzvVar == zzvVarArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
            iArr2[i3] = i4;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzyq zzyqVar = (zzyq) obj;
            if (this.f35913a.equals(zzyqVar.f35913a) && Arrays.equals(this.f35915c, zzyqVar.f35915c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f35917e;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f35915c) + (System.identityHashCode(this.f35913a) * 31);
        this.f35917e = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final zzbg zza() {
        return this.f35913a;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final zzv zzb(int i2) {
        return this.f35916d[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzzw
    public final zzv zzc() {
        return this.f35916d[0];
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final int zze() {
        return this.f35915c.length;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final int zzf(int i2) {
        return this.f35915c[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final int zzg(int i2) {
        for (int i3 = 0; i3 < this.f35914b; i3++) {
            if (this.f35915c[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzzw
    public final int zzh() {
        return this.f35915c[0];
    }
}
