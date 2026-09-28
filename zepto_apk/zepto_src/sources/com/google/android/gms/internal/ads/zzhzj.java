package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
class zzhzj extends zzhzi {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34550c;

    public zzhzj(byte[] bArr) {
        bArr.getClass();
        this.f34550c = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final boolean A(zzhzl zzhzlVar, int i2, int i3) {
        if (i3 > zzhzlVar.i()) {
            int i4 = i();
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 18 + String.valueOf(i4).length());
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        }
        int i5 = i2 + i3;
        if (i5 > zzhzlVar.i()) {
            int i6 = zzhzlVar.i();
            int length = String.valueOf(i2).length();
            StringBuilder sb2 = new StringBuilder(length + 24 + String.valueOf(i3).length() + 2 + String.valueOf(i6).length());
            androidx.fragment.app.e.w(i2, i3, "Ran off end of other: ", ", ", sb2);
            throw new IllegalArgumentException(androidx.fragment.app.e.r(sb2, i6, ", "));
        }
        if (!(zzhzlVar instanceof zzhzj)) {
            return zzhzlVar.o(i2, i5).equals(o(0, i3));
        }
        zzhzj zzhzjVar = (zzhzj) zzhzlVar;
        int iB = B() + i3;
        int iB2 = B();
        int iB3 = zzhzjVar.B() + i2;
        while (iB2 < iB) {
            if (this.f34550c[iB2] != zzhzjVar.f34550c[iB3]) {
                return false;
            }
            iB2++;
            iB3++;
        }
        return true;
    }

    public int B() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public byte f(int i2) {
        return this.f34550c[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public byte g(int i2) {
        return this.f34550c[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public int i() {
        return this.f34550c.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public void k(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f34550c, i2, bArr, i3, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final zzhzl o(int i2, int i3) {
        int iD = zzhzl.d(i2, i3, i());
        if (iD == 0) {
            return zzhzl.f34557b;
        }
        return new zzhzf(this.f34550c, B() + i2, iD);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final ByteBuffer p() {
        return ByteBuffer.wrap(this.f34550c, B(), i()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final void q(zzhzw zzhzwVar) {
        zzhzwVar.a(B(), this.f34550c, i());
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final boolean r(zzhzl zzhzlVar) {
        return zzhzlVar instanceof zzhzj ? A(zzhzlVar, 0, i()) : zzhzlVar.r(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final int s(int i2, int i3, int i4) {
        int iB = B() + i3;
        Charset charset = zzibe.f34660a;
        for (int i5 = iB; i5 < iB + i4; i5++) {
            i2 = (i2 * 31) + this.f34550c[i5];
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final zzhzq t() {
        return zzhzq.d(B(), this.f34550c, i());
    }
}
