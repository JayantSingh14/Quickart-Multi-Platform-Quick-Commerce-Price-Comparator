package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzand implements zzaly {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23722a = new zzer();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23723b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23724c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23725d;

    /* renamed from: e, reason: collision with root package name */
    public final String f23726e;

    /* renamed from: f, reason: collision with root package name */
    public final float f23727f;

    /* renamed from: g, reason: collision with root package name */
    public final int f23728g;

    public zzand(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f23724c = 0;
            this.f23725d = -1;
            this.f23726e = "sans-serif";
            this.f23723b = false;
            this.f23727f = 0.85f;
            this.f23728g = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f23724c = bArr[24];
        this.f23725d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        int length = bArr.length - 43;
        String str = zzfj.f31254a;
        this.f23726e = true == "Serif".equals(new String(bArr, 43, length, StandardCharsets.UTF_8)) ? "serif" : "sans-serif";
        int i2 = bArr[25] * 20;
        this.f23728g = i2;
        boolean z = (bArr[0] & 32) != 0;
        this.f23723b = z;
        if (z) {
            this.f23727f = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i2, 0.95f));
        } else {
            this.f23727f = 0.85f;
        }
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            int i7 = i6 | 33;
            int i8 = i2 & 1;
            int i9 = i2 & 2;
            boolean z = true;
            if (i8 != 0) {
                if (i9 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                    z = false;
                }
            } else if (i9 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            } else {
                z = false;
            }
            if ((i2 & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            } else {
                if (i8 != 0 || z) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
            }
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] bArr, int i2, int i3, zzdr zzdrVar) {
        String strK;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        SpannableStringBuilder spannableStringBuilder;
        int i10;
        int i11;
        zzer zzerVar = this.f23722a;
        zzerVar.z(i2 + i3, bArr);
        zzerVar.E(i2);
        int i12 = 1;
        int i13 = 0;
        int i14 = 2;
        zzgqa.a(zzerVar.B() >= 2);
        int iL = zzerVar.L();
        if (iL == 0) {
            strK = "";
        } else {
            int i15 = zzerVar.f30145b;
            Charset charsetQ = zzerVar.q();
            int i16 = zzerVar.f30145b - i15;
            if (charsetQ == null) {
                charsetQ = StandardCharsets.UTF_8;
            }
            strK = zzerVar.k(iL - i16, charsetQ);
        }
        if (strK.isEmpty()) {
            zzgvs zzgvsVar = zzgtd.f33183b;
            ((zzama) zzdrVar).zza(new zzalq(zzguy.f33232e, -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strK);
        int length = spannableStringBuilder2.length();
        int i17 = this.f23724c;
        b(spannableStringBuilder2, i17, 0, 0, length, 16711680);
        int i18 = i17;
        int length2 = spannableStringBuilder2.length();
        int i19 = this.f23725d;
        c(spannableStringBuilder2, i19, -1, 0, length2, 16711680);
        int i20 = i19;
        int length3 = spannableStringBuilder2.length();
        String str = this.f23726e;
        if (str != "sans-serif") {
            spannableStringBuilder2.setSpan(new TypefaceSpan(str), 0, length3, 16711713);
        }
        float fMax = this.f23727f;
        while (zzerVar.B() >= 8) {
            int i21 = zzerVar.f30145b;
            int iB = zzerVar.b();
            int iB2 = zzerVar.b();
            if (iB2 == 1937013100) {
                zzgqa.a(zzerVar.B() >= i14 ? i12 : i13);
                int iL2 = zzerVar.L();
                int i22 = i13;
                while (i22 < iL2) {
                    zzgqa.a(zzerVar.B() >= 12 ? i12 : i13);
                    int iL3 = zzerVar.L();
                    int iL4 = zzerVar.L();
                    zzerVar.G(i14);
                    int i23 = iL2;
                    int iK = zzerVar.K();
                    zzerVar.G(i12);
                    int iB3 = zzerVar.b();
                    int i24 = i12;
                    if (iL4 > spannableStringBuilder2.length()) {
                        int length4 = spannableStringBuilder2.length();
                        i8 = i18;
                        i9 = i20;
                        spannableStringBuilder = spannableStringBuilder2;
                        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(String.valueOf(iL4).length() + 44, 2, String.valueOf(length4)));
                        sb.append("Truncating styl end (");
                        sb.append(iL4);
                        sb.append(") to cueText.length() (");
                        sb.append(length4);
                        sb.append(").");
                        zzee.c("Tx3gParser", sb.toString());
                        iL4 = spannableStringBuilder.length();
                    } else {
                        i8 = i18;
                        i9 = i20;
                        spannableStringBuilder = spannableStringBuilder2;
                    }
                    if (iL3 >= iL4) {
                        StringBuilder sb2 = new StringBuilder(androidx.fragment.app.e.C(String.valueOf(iL3).length() + 36, 2, String.valueOf(iL4)));
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iL3);
                        sb2.append(") >= end (");
                        sb2.append(iL4);
                        sb2.append(").");
                        zzee.c("Tx3gParser", sb2.toString());
                        i11 = i22;
                        i10 = i23;
                        spannableStringBuilder2 = spannableStringBuilder;
                    } else {
                        i10 = i23;
                        i11 = i22;
                        spannableStringBuilder2 = spannableStringBuilder;
                        b(spannableStringBuilder2, iK, i8, iL3, iL4, 0);
                        c(spannableStringBuilder2, iB3, i9, iL3, iL4, 0);
                    }
                    i22 = i11 + 1;
                    i12 = i24;
                    iL2 = i10;
                    i18 = i8;
                    i20 = i9;
                    i13 = 0;
                    i14 = 2;
                }
                i4 = i18;
                i5 = i12;
                i6 = i20;
                i7 = i14;
            } else {
                i4 = i18;
                i5 = i12;
                i6 = i20;
                if (iB2 == 1952608120 && this.f23723b) {
                    i7 = 2;
                    zzgqa.a(zzerVar.B() >= 2 ? i5 : 0);
                    float fL = zzerVar.L();
                    String str2 = zzfj.f31254a;
                    fMax = Math.max(0.0f, Math.min(fL / this.f23728g, 0.95f));
                } else {
                    i7 = 2;
                }
            }
            zzerVar.E(i21 + iB);
            i14 = i7;
            i18 = i4;
            i20 = i6;
            i13 = 0;
            i12 = i5;
        }
        zzcw zzcwVar = new zzcw();
        zzcwVar.a(spannableStringBuilder2);
        zzcwVar.f27260e = fMax;
        zzcwVar.f27261f = 0;
        zzcwVar.f27262g = 0;
        ((zzama) zzdrVar).zza(new zzalq(zzgtd.n(zzcwVar.b()), -9223372036854775807L, -9223372036854775807L));
    }
}
