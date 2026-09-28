package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class zzanh {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f23743c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f23744d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23745a = new zzer();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f23746b = new StringBuilder();

    public static void a(zzer zzerVar) {
        while (true) {
            for (boolean z = true; zzerVar.B() > 0 && z; z = false) {
                int i2 = zzerVar.f30145b;
                byte[] bArr = zzerVar.f30144a;
                byte b2 = bArr[i2];
                char c2 = (char) b2;
                if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    zzerVar.G(1);
                } else {
                    int i3 = zzerVar.f30146c;
                    if (i2 + 2 <= i3) {
                        int i4 = i2 + 1;
                        if (b2 == 47) {
                            int i5 = i2 + 2;
                            if (bArr[i4] == 42) {
                                while (true) {
                                    int i6 = i5 + 1;
                                    if (i6 >= i3) {
                                        break;
                                    }
                                    if (((char) bArr[i5]) == '*' && ((char) bArr[i6]) == '/') {
                                        i3 = i5 + 2;
                                        i5 = i3;
                                    } else {
                                        i5 = i6;
                                    }
                                }
                                zzerVar.G(i3 - zzerVar.f30145b);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    public static String b(zzer zzerVar, StringBuilder sb) {
        a(zzerVar);
        if (zzerVar.B() == 0) {
            return null;
        }
        String strC = c(zzerVar, sb);
        if (!strC.isEmpty()) {
            return strC;
        }
        char cK = (char) zzerVar.K();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cK).length());
        sb2.append(cK);
        return sb2.toString();
    }

    public static String c(zzer zzerVar, StringBuilder sb) {
        boolean z;
        char c2;
        sb.setLength(0);
        int i2 = zzerVar.f30145b;
        int i3 = zzerVar.f30146c;
        loop0: while (true) {
            for (false; i2 < i3 && !z; true) {
                c2 = (char) zzerVar.f30144a[i2];
                z = (c2 < 'A' || c2 > 'Z') && (c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_');
            }
            sb.append(c2);
            i2++;
        }
        zzerVar.G(i2 - zzerVar.f30145b);
        return sb.toString();
    }
}
