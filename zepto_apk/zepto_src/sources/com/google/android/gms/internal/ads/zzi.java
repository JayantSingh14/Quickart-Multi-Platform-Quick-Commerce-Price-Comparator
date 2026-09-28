package com.google.android.gms.internal.ads;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzi {

    /* renamed from: h, reason: collision with root package name */
    public static final zzi f34610h;

    /* renamed from: a, reason: collision with root package name */
    public final int f34611a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34612b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34613c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34614d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34615e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34616f;

    /* renamed from: g, reason: collision with root package name */
    public int f34617g;

    static {
        zzh zzhVar = new zzh();
        zzhVar.f33411a = 1;
        zzhVar.f33412b = 2;
        zzhVar.f33413c = 3;
        f34610h = zzhVar.a();
        zzh zzhVar2 = new zzh();
        zzhVar2.f33411a = 1;
        zzhVar2.f33412b = 1;
        zzhVar2.f33413c = 2;
        zzhVar2.a();
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzi(int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.f34611a = i2;
        this.f34612b = i3;
        this.f34613c = i4;
        this.f34614d = bArr;
        this.f34615e = i5;
        this.f34616f = i6;
    }

    public static boolean a(zzi zziVar) {
        if (zziVar == null) {
            return true;
        }
        int i2 = zziVar.f34611a;
        if (i2 != -1 && i2 != 1 && i2 != 2) {
            return false;
        }
        int i3 = zziVar.f34612b;
        if (i3 != -1 && i3 != 2) {
            return false;
        }
        int i4 = zziVar.f34613c;
        if ((i4 != -1 && i4 != 3) || zziVar.f34614d != null) {
            return false;
        }
        int i5 = zziVar.f34616f;
        if (i5 != -1 && i5 != 8) {
            return false;
        }
        int i6 = zziVar.f34615e;
        return i6 == -1 || i6 == 8;
    }

    public static int b(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int c(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    public static String e(int i2) {
        return i2 != -1 ? i2 != 6 ? i2 != 1 ? i2 != 2 ? androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 22), i2, "Undefined color space ") : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String f(int i2) {
        return i2 != -1 ? i2 != 10 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? i2 != 7 ? androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 25), i2, "Undefined color transfer ") : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static String g(int i2) {
        return i2 != -1 ? i2 != 1 ? i2 != 2 ? androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 22), i2, "Undefined color range ") : "Limited range" : "Full range" : "Unset color range";
    }

    public final boolean d() {
        return (this.f34611a == -1 || this.f34612b == -1 || this.f34613c == -1) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzi.class == obj.getClass()) {
            zzi zziVar = (zzi) obj;
            if (this.f34611a == zziVar.f34611a && this.f34612b == zziVar.f34612b && this.f34613c == zziVar.f34613c && Arrays.equals(this.f34614d, zziVar.f34614d) && this.f34615e == zziVar.f34615e && this.f34616f == zziVar.f34616f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f34617g;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = ((((Arrays.hashCode(this.f34614d) + ((((((this.f34611a + 527) * 31) + this.f34612b) * 31) + this.f34613c) * 31)) * 31) + this.f34615e) * 31) + this.f34616f;
        this.f34617g = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String strE = e(this.f34611a);
        String strG = g(this.f34612b);
        String strF = f(this.f34613c);
        String strO = RegionUtil.REGION_STRING_NA;
        int i2 = this.f34615e;
        String strO2 = i2 != -1 ? android.support.v4.media.b.o(new StringBuilder(String.valueOf(i2).length() + 8), i2, "bit Luma") : RegionUtil.REGION_STRING_NA;
        int i3 = this.f34616f;
        if (i3 != -1) {
            strO = android.support.v4.media.b.o(new StringBuilder(String.valueOf(i3).length() + 10), i3, "bit Chroma");
        }
        boolean z = this.f34614d != null;
        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(androidx.fragment.app.e.C(androidx.fragment.app.e.C(androidx.fragment.app.e.C(strE.length() + 12, 2, strG) + strF.length() + 2, 2, String.valueOf(z)), 2, strO2), 1, strO));
        sb.append("ColorInfo(");
        sb.append(strE);
        sb.append(", ");
        sb.append(strG);
        sb.append(", ");
        sb.append(strF);
        sb.append(", ");
        sb.append(z);
        android.support.v4.media.b.B(sb, ", ", strO2, ", ", strO);
        sb.append(")");
        return sb.toString();
    }
}
