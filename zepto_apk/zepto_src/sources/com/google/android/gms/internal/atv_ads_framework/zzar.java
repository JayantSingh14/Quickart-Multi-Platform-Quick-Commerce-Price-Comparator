package com.google.android.gms.internal.atv_ads_framework;

import android.os.Build;

/* loaded from: classes4.dex */
final class zzar extends zzat {
    @Override // com.google.android.gms.internal.atv_ads_framework.zzat
    public final int b(int i2) {
        return i2 + 1;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzat
    public final int c(int i2) {
        String str = Build.FINGERPRINT;
        int length = str.length();
        zzaq.b(i2, length);
        while (i2 < length) {
            if (str.charAt(i2) == ':') {
                return i2;
            }
            i2++;
        }
        return -1;
    }
}
