package com.google.android.gms.internal.fido;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
class zzbe extends zzbf {

    /* renamed from: b, reason: collision with root package name */
    public final zzbb f36607b;

    /* renamed from: c, reason: collision with root package name */
    public final Character f36608c;

    public zzbe(zzbb zzbbVar, Character ch2) {
        this.f36607b = zzbbVar;
        if (ch2 != null && zzbbVar.f36605g[61] != -1) {
            throw new IllegalArgumentException(zzan.a("Padding character %s was already in alphabet", ch2));
        }
        this.f36608c = ch2;
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    public void a(StringBuilder sb, byte[] bArr, int i2) {
        int i3 = 0;
        zzam.b(0, i2, bArr.length);
        while (i3 < i2) {
            zzbb zzbbVar = this.f36607b;
            d(sb, bArr, i3, Math.min(zzbbVar.f36604f, i2 - i3));
            i3 += zzbbVar.f36604f;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzbf
    public final int b(int i2) {
        zzbb zzbbVar = this.f36607b;
        int i3 = zzbbVar.f36603e;
        RoundingMode roundingMode = RoundingMode.CEILING;
        return zzbh.a(i2, zzbbVar.f36604f) * i3;
    }

    public final void d(StringBuilder sb, byte[] bArr, int i2, int i3) {
        zzam.b(i2, i2 + i3, bArr.length);
        zzbb zzbbVar = this.f36607b;
        if (i3 > zzbbVar.f36604f) {
            throw new IllegalArgumentException();
        }
        int i4 = 0;
        long j2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            j2 = (j2 | (bArr[i2 + i5] & 255)) << 8;
        }
        int i6 = zzbbVar.f36602d;
        int i7 = ((i3 + 1) * 8) - i6;
        while (i4 < i3 * 8) {
            sb.append(zzbbVar.f36600b[zzbbVar.f36601c & ((int) (j2 >>> (i7 - i4)))]);
            i4 += i6;
        }
        if (this.f36608c != null) {
            while (i4 < zzbbVar.f36604f * 8) {
                sb.append('=');
                i4 += i6;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (this.f36607b.equals(zzbeVar.f36607b)) {
                Character ch2 = this.f36608c;
                Character ch3 = zzbeVar.f36608c;
                if (ch2 == ch3) {
                    return true;
                }
                if (ch2 != null && ch2.equals(ch3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f36607b.hashCode();
        Character ch2 = this.f36608c;
        return iHashCode ^ (ch2 == null ? 0 : ch2.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzbb zzbbVar = this.f36607b;
        sb.append(zzbbVar);
        if (8 % zzbbVar.f36602d != 0) {
            Character ch2 = this.f36608c;
            if (ch2 == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch2);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public zzbe(String str, String str2) {
        this(new zzbb(str, str2.toCharArray()), (Character) '=');
    }
}
