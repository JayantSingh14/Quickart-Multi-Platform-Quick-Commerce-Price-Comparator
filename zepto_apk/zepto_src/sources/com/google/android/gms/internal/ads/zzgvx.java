package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
class zzgvx extends zzgvy {

    /* renamed from: d, reason: collision with root package name */
    public final zzgvt f33272d;

    /* renamed from: e, reason: collision with root package name */
    public final Character f33273e;

    /* renamed from: f, reason: collision with root package name */
    public volatile zzgvy f33274f;

    public zzgvx(zzgvt zzgvtVar, Character ch2) {
        this.f33272d = zzgvtVar;
        boolean z = true;
        if (ch2 != null) {
            byte[] bArr = zzgvtVar.f33268g;
            if (bArr.length > 61 && bArr[61] != -1) {
                z = false;
            }
        }
        zzgqa.e(z, "Padding character %s was already in alphabet", ch2);
        this.f33273e = ch2;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy
    public void a(StringBuilder sb, byte[] bArr, int i2) {
        int i3 = 0;
        zzgqa.k(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.f33272d.f33267f;
            j(sb, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgvy
    public int b(byte[] bArr, CharSequence charSequence) throws zzgvw {
        int i2;
        CharSequence charSequenceE = e(charSequence);
        int length = charSequenceE.length();
        zzgvt zzgvtVar = this.f33272d;
        boolean[] zArr = zzgvtVar.f33269h;
        int i3 = zzgvtVar.f33266e;
        if (!zArr[length % i3]) {
            int length2 = charSequenceE.length();
            throw new zzgvw(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(length2).length() + 21), length2, "Invalid input length "));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < charSequenceE.length(); i5 += i3) {
            long jA = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                i2 = zzgvtVar.f33265d;
                if (i6 >= i3) {
                    break;
                }
                jA <<= i2;
                if (i5 + i6 < charSequenceE.length()) {
                    jA |= zzgvtVar.a(charSequenceE.charAt(i7 + i5));
                    i7++;
                }
                i6++;
            }
            int i8 = i7 * i2;
            int i9 = zzgvtVar.f33267f;
            int i10 = (i9 - 1) * 8;
            while (i10 >= (i9 * 8) - i8) {
                bArr[i4] = (byte) ((jA >>> i10) & 255);
                i10 -= 8;
                i4++;
            }
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy
    public final int c(int i2) {
        zzgvt zzgvtVar = this.f33272d;
        int i3 = zzgvtVar.f33267f;
        RoundingMode roundingMode = RoundingMode.CEILING;
        return zzgvtVar.f33266e * zzgwq.a(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgvy
    public final int d(int i2) {
        return (int) (((this.f33272d.f33265d * i2) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgvy
    public final CharSequence e(CharSequence charSequence) {
        charSequence.getClass();
        if (this.f33273e == null) {
            return charSequence;
        }
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgvx) {
            zzgvx zzgvxVar = (zzgvx) obj;
            if (this.f33272d.equals(zzgvxVar.f33272d) && Objects.equals(this.f33273e, zzgvxVar.f33273e)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    @Override // com.google.android.gms.internal.ads.zzgvy
    public final zzgvy f() {
        zzgvt zzgvtVar;
        boolean z;
        zzgvy zzgvyVarI = this.f33274f;
        if (zzgvyVarI == null) {
            zzgvt zzgvtVar2 = this.f33272d;
            int i2 = 0;
            while (true) {
                char[] cArr = zzgvtVar2.f33263b;
                int length = cArr.length;
                if (i2 >= length) {
                    zzgvtVar = zzgvtVar2;
                    break;
                }
                if (zzgpj.c(cArr[i2])) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        char c2 = cArr[i3];
                        if (c2 >= 'a' && c2 <= 'z') {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    zzgqa.g("Cannot call lowerCase() on a mixed-case alphabet", !z);
                    char[] cArr2 = new char[cArr.length];
                    for (int i4 = 0; i4 < cArr.length; i4++) {
                        char c3 = cArr[i4];
                        if (zzgpj.c(c3)) {
                            c3 ^= 32;
                        }
                        cArr2[i4] = (char) c3;
                    }
                    zzgvtVar = new zzgvt(zzgvtVar2.f33262a.concat(".lowerCase()"), cArr2);
                    if (zzgvtVar2.f33270i && !zzgvtVar.f33270i) {
                        byte[] bArr = zzgvtVar.f33268g;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        for (int i5 = 65; i5 <= 90; i5++) {
                            int i6 = i5 | 32;
                            byte b2 = bArr[i5];
                            byte b3 = bArr[i6];
                            if (b2 == -1) {
                                bArrCopyOf[i5] = b3;
                            } else {
                                char c4 = (char) i5;
                                char c5 = (char) i6;
                                if (b3 != -1) {
                                    throw new IllegalStateException(zzgqr.b("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c4), Character.valueOf(c5)));
                                }
                                bArrCopyOf[i6] = b2;
                            }
                        }
                        zzgvtVar = new zzgvt(zzgvtVar.f33262a.concat(".ignoreCase()"), zzgvtVar.f33263b, bArrCopyOf, true);
                    }
                } else {
                    i2++;
                }
            }
            zzgvyVarI = zzgvtVar == zzgvtVar2 ? this : i(zzgvtVar, this.f33273e);
            this.f33274f = zzgvyVarI;
        }
        return zzgvyVarI;
    }

    public final int hashCode() {
        return this.f33272d.hashCode() ^ Objects.hashCode(this.f33273e);
    }

    public zzgvy i(zzgvt zzgvtVar, Character ch2) {
        return new zzgvx(zzgvtVar, ch2);
    }

    public final void j(StringBuilder sb, byte[] bArr, int i2, int i3) {
        int i4;
        zzgqa.k(i2, i2 + i3, bArr.length);
        zzgvt zzgvtVar = this.f33272d;
        int i5 = zzgvtVar.f33267f;
        int i6 = 0;
        zzgqa.a(i3 <= i5);
        long j2 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            j2 = (j2 | (bArr[i2 + i7] & 255)) << 8;
        }
        int i8 = (i3 + 1) * 8;
        while (true) {
            int i9 = i3 * 8;
            i4 = zzgvtVar.f33265d;
            if (i6 >= i9) {
                break;
            }
            sb.append(zzgvtVar.f33263b[zzgvtVar.f33264c & ((int) (j2 >>> ((i8 - i4) - i6)))]);
            i6 += i4;
        }
        if (this.f33273e != null) {
            while (i6 < i5 * 8) {
                sb.append('=');
                i6 += i4;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgvt zzgvtVar = this.f33272d;
        sb.append(zzgvtVar);
        if (8 % zzgvtVar.f33265d != 0) {
            Character ch2 = this.f33273e;
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

    public zzgvx(String str, String str2) {
        this(new zzgvt(str, str2.toCharArray()), (Character) '=');
    }
}
