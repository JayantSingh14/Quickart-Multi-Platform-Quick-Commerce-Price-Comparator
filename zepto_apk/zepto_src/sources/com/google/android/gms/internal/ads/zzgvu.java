package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgvu extends zzgvx {

    /* renamed from: g, reason: collision with root package name */
    public final char[] f33271g;

    public zzgvu(zzgvt zzgvtVar) {
        super(zzgvtVar, (Character) null);
        this.f33271g = new char[512];
        zzgqa.a(zzgvtVar.f33263b.length == 16);
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr = this.f33271g;
            char[] cArr2 = zzgvtVar.f33263b;
            cArr[i2] = cArr2[i2 >>> 4];
            cArr[i2 | 256] = cArr2[i2 & 15];
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgvx, com.google.android.gms.internal.ads.zzgvy
    public final void a(StringBuilder sb, byte[] bArr, int i2) {
        zzgqa.k(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.f33271g;
            sb.append(cArr[i4]);
            sb.append(cArr[i4 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgvx, com.google.android.gms.internal.ads.zzgvy
    public final int b(byte[] bArr, CharSequence charSequence) throws zzgvw {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            throw new zzgvw(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length).length() + 21), length, "Invalid input length "));
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            zzgvt zzgvtVar = this.f33272d;
            bArr[i3] = (byte) ((zzgvtVar.a(cCharAt) << 4) | zzgvtVar.a(charSequence.charAt(i2 + 1)));
            i2 += 2;
            i3++;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgvx
    public final zzgvy i(zzgvt zzgvtVar, Character ch2) {
        return new zzgvu(zzgvtVar);
    }
}
