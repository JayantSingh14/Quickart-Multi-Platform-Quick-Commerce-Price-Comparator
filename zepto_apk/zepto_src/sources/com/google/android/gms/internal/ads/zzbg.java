package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzbg {

    /* renamed from: a, reason: collision with root package name */
    public final int f24983a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24984b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24985c;

    /* renamed from: d, reason: collision with root package name */
    public final zzv[] f24986d;

    /* renamed from: e, reason: collision with root package name */
    public int f24987e;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbg(String str, zzv... zzvVarArr) {
        int length = zzvVarArr.length;
        int i2 = 1;
        zzgqa.a(length > 0);
        this.f24984b = str;
        this.f24986d = zzvVarArr;
        this.f24983a = length;
        int iF = zzas.f(zzvVarArr[0].f35691m);
        this.f24985c = iF == -1 ? zzas.f(zzvVarArr[0].f35690l) : iF;
        zzv zzvVar = zzvVarArr[0];
        String str2 = zzvVar.f35682d;
        str2 = (str2 == null || str2.equals("und")) ? "" : str2;
        int i3 = zzvVar.f35684f | 16384;
        while (true) {
            zzv[] zzvVarArr2 = this.f24986d;
            if (i2 >= zzvVarArr2.length) {
                return;
            }
            zzv zzvVar2 = zzvVarArr2[i2];
            String str3 = zzvVar2.f35682d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? "" : str3)) {
                a(i2, "languages", zzvVarArr2[0].f35682d, str3);
                return;
            } else {
                if (i3 != (zzvVar2.f35684f | 16384)) {
                    a(i2, "role flags", Integer.toBinaryString(zzvVarArr2[0].f35684f), Integer.toBinaryString(this.f24986d[i2].f35684f));
                    return;
                }
                i2++;
            }
        }
    }

    public static void a(int i2, String str, String str2, String str3) {
        int length = String.valueOf(str2).length();
        int length2 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(str.length() + 40 + length + 17 + length2 + 9 + String.valueOf(i2).length() + 1);
        android.support.v4.media.b.B(sb, "Different ", str, " combined in one TrackGroup: '", str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i2);
        sb.append(")");
        zzee.f("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbg.class == obj.getClass()) {
            zzbg zzbgVar = (zzbg) obj;
            if (this.f24984b.equals(zzbgVar.f24984b) && Arrays.equals(this.f24986d, zzbgVar.f24986d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f24987e;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f24986d) + ((this.f24984b.hashCode() + 527) * 31);
        this.f24987e = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String string = Arrays.toString(this.f24986d);
        String str = this.f24984b;
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(string).length()), str, ": ", string);
    }
}
