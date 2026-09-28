package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzatl implements zzatk {
    @Override // com.google.android.gms.internal.ads.zzatk
    public final byte a(zzatw zzatwVar, int i2) {
        return zzatwVar.b(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final zzatw b(zzatw zzatwVar, int i2, int i3) {
        byte[] bArr;
        int length;
        byte[] bArr2;
        if (i2 < 0 || i2 > i3 || i3 > (length = (bArr = zzatwVar.f24367a).length) || i2 > i3 || i3 > length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        if (i4 == 0) {
            bArr2 = new byte[0];
        } else {
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr, i2, bArr3, 0, i4);
            bArr2 = bArr3;
        }
        return new zzatw(bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final zzatk zzc() {
        return new zzatl();
    }
}
