package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class b {
    public static int a(int i2, int i3, int i4) {
        return zzhzw.b(i2) + i3 + i4;
    }

    public static int b(int i2, int i3, int i4, int i5) {
        return zzhzw.b(i2) + i3 + i4 + i5;
    }

    public static void c(String str, String str2, String str3) {
        zzee.c(str3, str2.concat(String.valueOf(str)));
    }

    public static void d(StringBuilder sb, String str, int i2, String str2) {
        sb.append(str);
        sb.append(i2);
        zzee.c(str2, sb.toString());
    }
}
