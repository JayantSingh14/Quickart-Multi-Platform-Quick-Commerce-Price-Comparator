package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzgw extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public final zzgv f33278e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f33279f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f33280g;

    /* renamed from: h, reason: collision with root package name */
    public int f33281h;

    /* renamed from: i, reason: collision with root package name */
    public int f33282i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f33283j;

    public zzgw(byte[] bArr) {
        zzgu zzguVar = new zzgu(bArr);
        super(false);
        this.f33278e = zzguVar;
        zzgqa.a(bArr.length > 0);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws zzhc {
        d(zzhfVar);
        this.f33279f = zzhfVar.f33691a;
        byte[] bArr = ((zzgu) this.f33278e).f33217a;
        this.f33280g = bArr;
        int length = bArr.length;
        long j2 = length;
        long j3 = zzhfVar.f33693c;
        if (j3 > j2) {
            throw new zzhc();
        }
        int i2 = (int) j3;
        this.f33281h = i2;
        int i3 = length - i2;
        this.f33282i = i3;
        long j4 = zzhfVar.f33694d;
        if (j4 != -1) {
            this.f33282i = (int) Math.min(i3, j4);
        }
        this.f33283j = true;
        e(zzhfVar);
        return j4 != -1 ? j4 : this.f33282i;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f33282i;
        if (i4 == 0) {
            return -1;
        }
        int iMin = Math.min(i3, i4);
        byte[] bArr2 = this.f33280g;
        bArr2.getClass();
        System.arraycopy(bArr2, this.f33281h, bArr, i2, iMin);
        this.f33281h += iMin;
        this.f33282i -= iMin;
        f(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f33279f;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        if (this.f33283j) {
            this.f33283j = false;
            g();
        }
        this.f33279f = null;
        this.f33280g = null;
    }
}
