package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzaf.class)
/* loaded from: classes3.dex */
public abstract class zzbv {
    public static zzbv create(@Nullable String str, String str2, boolean z, String str3, int i2, String str4) {
        return new zzaf(str, str2, z, str3, i2, str4);
    }

    public abstract String adsIdentityToken();

    public abstract String appSetId();

    public abstract int appSetIdScope();

    @Nullable
    public abstract String deviceId();

    public abstract String idType();

    public abstract boolean isLimitedAdTracking();
}
