package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.VersionInfo;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzau.class)
/* loaded from: classes3.dex */
public abstract class zzcq {
    public static zzcq createBy1stPartyData(SecureSignals secureSignals) {
        return new zzau(null, null, "", secureSignals.getSecureSignal(), Boolean.TRUE);
    }

    public static zzcq createBy3rdPartyData(VersionInfo versionInfo, VersionInfo versionInfo2, String str, String str2) {
        return createBy3rdPartyData(zzcr.create(versionInfo), zzcr.create(versionInfo2), str, str2);
    }

    @Nullable
    public abstract zzcr adapterVersion();

    public abstract Boolean isPublisherCreated();

    public abstract String name();

    @Nullable
    public abstract zzcr sdkVersion();

    public abstract String signals();

    public static zzcq createBy3rdPartyData(zzcr zzcrVar, zzcr zzcrVar2, String str, String str2) {
        return new zzau(zzcrVar, zzcrVar2, str, str2, Boolean.FALSE);
    }
}
