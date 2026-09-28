package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.internal.zzoo;

@zzoo(zza = zzag.class)
/* loaded from: classes3.dex */
public abstract class zzca {
    public static zzca create(long j2, AdErrorEvent adErrorEvent) {
        return create(j2, (zzbx) null, (zzbz) null, adErrorEvent, (zzch) null);
    }

    @Nullable
    public abstract AdErrorEvent adErrorEvent();

    @Nullable
    public abstract zzbx component();

    @Nullable
    public abstract zzcc eventTimestampInfo();

    @Nullable
    public abstract Long latency();

    @Nullable
    public abstract zzch loggableException();

    @Nullable
    public abstract zzbz method();

    public abstract long timestamp();

    public static zzca create(long j2, zzbx zzbxVar, zzbz zzbzVar) {
        return create(j2, zzbxVar, zzbzVar, (AdErrorEvent) null, (zzch) null);
    }

    private static zzca create(long j2, zzbx zzbxVar, zzbz zzbzVar, AdErrorEvent adErrorEvent, zzch zzchVar) {
        return new zzag(j2, zzbxVar, zzbzVar, adErrorEvent, zzchVar, null, null);
    }

    public static zzca create(long j2, zzbx zzbxVar, zzbz zzbzVar, zzcc zzccVar) {
        return new zzag(j2, zzbxVar, zzbzVar, null, null, null, zzccVar);
    }

    public static zzca create(long j2, zzbx zzbxVar, zzbz zzbzVar, long j3) {
        return new zzag(j2, zzbxVar, zzbzVar, null, null, Long.valueOf(j3), null);
    }

    public static zzca create(long j2, zzbx zzbxVar, zzbz zzbzVar, Throwable th) {
        return create(j2, zzbxVar, zzbzVar, (AdErrorEvent) null, zzch.create(th));
    }

    public static zzca create(long j2, zzbx zzbxVar, zzbz zzbzVar, long j3, zzcc zzccVar) {
        return new zzag(j2, zzbxVar, zzbzVar, null, null, Long.valueOf(j3), zzccVar);
    }
}
