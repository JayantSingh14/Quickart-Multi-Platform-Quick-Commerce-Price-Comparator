package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
final class zzah extends zzag {
    public final String toString() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i2 = 58;
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(i2 & 15);
            i2 >>= 4;
        }
        return b.D("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }
}
