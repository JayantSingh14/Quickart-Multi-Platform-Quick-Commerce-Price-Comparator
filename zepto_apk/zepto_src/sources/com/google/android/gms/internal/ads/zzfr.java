package com.google.android.gms.internal.ads;

import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzfr {

    /* renamed from: a, reason: collision with root package name */
    public final String f31688a;

    public zzfr(String str) {
        this.f31688a = str;
    }

    public static zzfr a(zzer zzerVar) {
        String str;
        zzerVar.G(2);
        int iK = zzerVar.K();
        int i2 = iK >> 1;
        int i3 = iK & 1;
        int iK2 = zzerVar.K() >> 3;
        if (i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8) {
            str = "dvhe";
        } else if (i2 == 9) {
            str = "dvav";
        } else {
            if (i2 != 10) {
                return null;
            }
            str = "dav1";
        }
        int i4 = iK2 | (i3 << 5);
        String str2 = CLConstants.DOT_SALT_DELIMETER;
        String str3 = i2 < 10 ? ".0" : CLConstants.DOT_SALT_DELIMETER;
        int length = str3.length() + 4;
        int length2 = String.valueOf(i2).length();
        int length3 = String.valueOf(i4).length();
        if (i4 < 10) {
            str2 = ".0";
        }
        StringBuilder sb = new StringBuilder(androidx.fragment.app.e.C(length + length2, length3, str2));
        sb.append(str);
        sb.append(str3);
        sb.append(i2);
        sb.append(str2);
        sb.append(i4);
        return new zzfr(sb.toString());
    }
}
