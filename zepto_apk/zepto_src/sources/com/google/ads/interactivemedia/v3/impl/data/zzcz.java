package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
public abstract class zzcz {
    public abstract zzda build();

    public abstract zzcz volume(float f2);

    public zzcz volumePercentage(int i2) {
        return volume(i2 / 100.0f);
    }
}
