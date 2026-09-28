package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzal.class)
/* loaded from: classes3.dex */
public abstract class zzcj {
    public static zzcj create(zzci zzciVar, String str, String str2, String str3, String str4, int i2, int i3) {
        return new zzal(zzciVar, str, str2, str4, str3, i2, i3);
    }

    public abstract int connectionTimeoutMs();

    @Nullable
    public abstract String content();

    public abstract String id();

    public abstract int readTimeoutMs();

    public abstract zzci requestType();

    public abstract String url();

    public abstract String userAgent();
}
