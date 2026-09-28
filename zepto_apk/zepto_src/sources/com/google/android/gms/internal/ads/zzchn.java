package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzchn implements zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final zzgw f26278a;

    /* renamed from: b, reason: collision with root package name */
    public final long f26279b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhb f26280c;

    /* renamed from: d, reason: collision with root package name */
    public long f26281d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f26282e;

    public zzchn(zzgw zzgwVar, int i2, zzhb zzhbVar) {
        this.f26278a = zzgwVar;
        this.f26279b = i2;
        this.f26280c = zzhbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) {
        zzhf zzhfVar2;
        zzhf zzhfVar3;
        zzhf zzhfVar4;
        Uri uri = zzhfVar.f33691a;
        this.f26282e = uri;
        long j2 = zzhfVar.f33693c;
        long j3 = this.f26279b;
        long j4 = zzhfVar.f33694d;
        if (j2 >= j3) {
            zzhfVar2 = null;
        } else {
            long jMin = j3 - j2;
            if (j4 != -1) {
                jMin = Math.min(j4, jMin);
            }
            zzhfVar2 = new zzhf(uri, j2, jMin);
        }
        if (j4 == -1 || j2 + j4 > j3) {
            zzhfVar3 = zzhfVar2;
            zzhfVar4 = new zzhf(uri, Math.max(j3, j2), j4 != -1 ? Math.min(j4, (j2 + j4) - j3) : -1L);
        } else {
            zzhfVar3 = zzhfVar2;
            zzhfVar4 = null;
        }
        long jA = zzhfVar3 != null ? this.f26278a.a(zzhfVar3) : 0L;
        long jA2 = zzhfVar4 != null ? this.f26280c.a(zzhfVar4) : 0L;
        this.f26281d = j2;
        if (jA == -1 || jA2 == -1) {
            return -1L;
        }
        return jA + jA2;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        int i4;
        long j2 = this.f26281d;
        long j3 = this.f26279b;
        if (j2 < j3) {
            int iB = this.f26278a.b(i2, bArr, (int) Math.min(i3, j3 - j2));
            long j4 = this.f26281d + iB;
            this.f26281d = j4;
            i4 = iB;
            j2 = j4;
        } else {
            i4 = 0;
        }
        if (j2 < j3) {
            return i4;
        }
        int iB2 = this.f26280c.b(i2 + i4, bArr, i3 - i4);
        int i5 = i4 + iB2;
        this.f26281d += iB2;
        return i5;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void c(zzhz zzhzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f26282e;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        this.f26278a.zzd();
        this.f26280c.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzhb, com.google.android.gms.internal.ads.zzhu
    public final Map zzj() {
        return zzgvd.f33244g;
    }
}
