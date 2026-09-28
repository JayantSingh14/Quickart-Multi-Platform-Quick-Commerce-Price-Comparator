package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.VersionInfo;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzav.class)
/* loaded from: classes3.dex */
public abstract class zzcr {
    public static zzcr create(int i2, int i3, int i4) {
        return new zzav(i2, i3, i4);
    }

    public abstract int major();

    public abstract int micro();

    public abstract int minor();

    public static zzcr create(VersionInfo versionInfo) {
        return create(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }
}
