package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzatm implements zzatk {

    /* renamed from: a, reason: collision with root package name */
    public int f24319a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f24320b = new byte[8];

    /* renamed from: c, reason: collision with root package name */
    public final zzato f24321c;

    public zzatm(zzato zzatoVar) {
        this.f24321c = zzatoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final byte a(zzatw zzatwVar, int i2) {
        int i3 = ((((~1264448664) & 231739608) | 1128901767) + ((1264448664 & 479203675) | 860794247)) - 1823332376;
        int i4 = 1761855727 % 1384724137;
        int i5 = (((((~143154913) & 992498304) | 439467622) + ((143154913 & 1627930754) | 1212551295)) - (-2089988634)) ^ (2033018190 % 70061690);
        int i6 = ((((~1661299468) & 613450408) | 2017391535) + ((1661299468 & 109051904) | 2071555381)) - (-441392543);
        int i7 = 1694830070 % 1383960411;
        int i8 = i2 >>> i5;
        int i9 = this.f24319a;
        byte[] bArr = this.f24320b;
        if (i8 != i9) {
            this.f24321c.a(i8, bArr);
            this.f24319a = i8;
        }
        int i10 = i6 ^ i7;
        return (byte) (((zzatwVar.b(i2) ^ bArr[i2 % (i3 ^ i4)]) << i10) >> i10);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final zzatw b(zzatw zzatwVar, int i2, int i3) {
        if (i2 < 0 || i2 > i3 || i3 > zzatwVar.f24367a.length) {
            throw new IndexOutOfBoundsException();
        }
        byte[] bArr = new byte[i3 - i2];
        int i4 = 0;
        while (i2 < i3) {
            bArr[i4] = a(zzatwVar, i2);
            i2++;
            i4++;
        }
        return zzatw.e(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final /* bridge */ /* synthetic */ zzatk zzc() {
        return new zzatm(this.f24321c);
    }
}
