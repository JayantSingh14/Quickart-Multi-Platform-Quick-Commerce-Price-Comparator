package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
final class zzbd extends zzbe {
    public zzbd(String str, String str2) {
        zzbb zzbbVar = new zzbb(str, str2.toCharArray());
        super(zzbbVar, (Character) '=');
        if (zzbbVar.f36600b.length != 64) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.google.android.gms.internal.fido.zzbe, com.google.android.gms.internal.fido.zzbf
    public final void a(StringBuilder sb, byte[] bArr, int i2) {
        int i3 = 0;
        zzam.b(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
            zzbb zzbbVar = this.f36607b;
            sb.append(zzbbVar.f36600b[i5 >>> 18]);
            char[] cArr = zzbbVar.f36600b;
            sb.append(cArr[(i5 >>> 12) & 63]);
            sb.append(cArr[(i5 >>> 6) & 63]);
            sb.append(cArr[i5 & 63]);
            i3 += 3;
        }
        if (i3 < i2) {
            d(sb, bArr, i3, i2 - i3);
        }
    }
}
