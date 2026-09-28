package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
final class zzbc extends zzbe {

    /* renamed from: d, reason: collision with root package name */
    public final char[] f36606d;

    public zzbc() {
        zzbb zzbbVar = new zzbb("base16()", "0123456789ABCDEF".toCharArray());
        super(zzbbVar, (Character) null);
        this.f36606d = new char[512];
        char[] cArr = zzbbVar.f36600b;
        if (cArr.length != 16) {
            throw new IllegalArgumentException();
        }
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr2 = this.f36606d;
            cArr2[i2] = cArr[i2 >>> 4];
            cArr2[i2 | 256] = cArr[i2 & 15];
        }
    }

    @Override // com.google.android.gms.internal.fido.zzbe, com.google.android.gms.internal.fido.zzbf
    public final void a(StringBuilder sb, byte[] bArr, int i2) {
        zzam.b(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.f36606d;
            sb.append(cArr[i4]);
            sb.append(cArr[i4 | 256]);
        }
    }
}
