package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzot extends zzok {
    public static final boolean j(String str) {
        String str2 = (String) zzfx.t.a(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        if (java.lang.Math.abs(r6.hashCode() % 100) < r8.H().s()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzos h(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzot.h(java.lang.String):com.google.android.gms.measurement.internal.zzos");
    }

    public final String i(String str) {
        zzhs zzhsVar = this.f39551b.f39594a;
        zzpf.S(zzhsVar);
        String strT = zzhsVar.t(str);
        if (TextUtils.isEmpty(strT)) {
            return (String) zzfx.r.a(null);
        }
        Uri uri = Uri.parse((String) zzfx.r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String authority = uri.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(strT).length() + 1 + String.valueOf(authority).length());
        sb.append(strT);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(authority);
        builderBuildUpon.authority(sb.toString());
        return builderBuildUpon.build().toString();
    }
}
