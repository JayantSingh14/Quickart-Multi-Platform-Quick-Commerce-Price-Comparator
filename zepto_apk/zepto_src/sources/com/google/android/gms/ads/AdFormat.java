package com.google.android.gms.ads;

/* loaded from: classes4.dex */
public enum AdFormat {
    BANNER(0),
    INTERSTITIAL(1),
    REWARDED(2),
    REWARDED_INTERSTITIAL(3),
    NATIVE(4),
    APP_OPEN_AD(6);


    /* renamed from: a, reason: collision with root package name */
    public final int f20992a;

    AdFormat(int i2) {
        this.f20992a = i2;
    }

    public static AdFormat a(int i2) {
        for (AdFormat adFormat : values()) {
            if (adFormat.f20992a == i2) {
                return adFormat;
            }
        }
        return null;
    }
}
