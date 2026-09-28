package com.google.ads.interactivemedia.v3.impl;

/* loaded from: classes3.dex */
public abstract class zzs {
    public static zzs create(int i2, String str) {
        return new AutoValue_AdsLoaderImpl_MarketAppInfo(i2, str);
    }

    public abstract int appVersion();

    public abstract String packageName();
}
