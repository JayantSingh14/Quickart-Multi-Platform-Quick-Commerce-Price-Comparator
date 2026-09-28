package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgvv extends zzgvx {
    public zzgvv(zzgvt zzgvtVar, Character ch2) {
        super(zzgvtVar, ch2);
        zzgqa.a(zzgvtVar.f33263b.length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgvx, com.google.android.gms.internal.ads.zzgvy
    public final void a(StringBuilder sb, byte[] bArr, int i2) {
        int i3 = 0;
        zzgqa.k(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
            zzgvt zzgvtVar = this.f33272d;
            sb.append(zzgvtVar.f33263b[i5 >>> 18]);
            char[] cArr = zzgvtVar.f33263b;
            sb.append(cArr[(i5 >>> 12) & 63]);
            sb.append(cArr[(i5 >>> 6) & 63]);
            sb.append(cArr[i5 & 63]);
            i3 += 3;
        }
        if (i3 < i2) {
            j(sb, bArr, i3, i2 - i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgvx, com.google.android.gms.internal.ads.zzgvy
    public final int b(byte[] bArr, CharSequence charSequence) throws zzgvw {
        CharSequence charSequenceE = e(charSequence);
        int length = charSequenceE.length();
        zzgvt zzgvtVar = this.f33272d;
        if (!zzgvtVar.f33269h[length % zzgvtVar.f33266e]) {
            int length2 = charSequenceE.length();
            throw new zzgvw(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length2).length() + 21), length2, "Invalid input length "));
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceE.length()) {
            int i4 = i3 + 1;
            int iA = (zzgvtVar.a(charSequenceE.charAt(i2 + 1)) << 12) | (zzgvtVar.a(charSequenceE.charAt(i2)) << 18);
            bArr[i3] = (byte) (iA >>> 16);
            int i5 = i2 + 2;
            if (i5 < charSequenceE.length()) {
                int i6 = i2 + 3;
                int iA2 = iA | (zzgvtVar.a(charSequenceE.charAt(i5)) << 6);
                int i7 = i3 + 2;
                bArr[i4] = (byte) ((iA2 >>> 8) & 255);
                if (i6 < charSequenceE.length()) {
                    i2 += 4;
                    i3 += 3;
                    bArr[i7] = (byte) ((iA2 | zzgvtVar.a(charSequenceE.charAt(i6))) & 255);
                } else {
                    i3 = i7;
                    i2 = i6;
                }
            } else {
                i2 = i5;
                i3 = i4;
            }
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgvx
    public final zzgvy i(zzgvt zzgvtVar, Character ch2) {
        return new zzgvv(zzgvtVar, ch2);
    }

    public zzgvv(String str, String str2) {
        this(new zzgvt(str, str2.toCharArray()), (Character) '=');
    }
}
