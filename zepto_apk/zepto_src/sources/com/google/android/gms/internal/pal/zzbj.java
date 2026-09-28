package com.google.android.gms.internal.pal;

import android.util.Base64;

/* loaded from: classes4.dex */
public final class zzbj {
    public static byte[] a(String str, boolean z) {
        byte[] bArrDecode = Base64.decode(str, true != z ? 2 : 11);
        if (bArrDecode.length != 0 || str.length() <= 0) {
            return bArrDecode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
