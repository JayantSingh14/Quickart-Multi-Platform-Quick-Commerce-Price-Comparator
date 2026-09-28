package com.google.ads.interactivemedia.v3.impl;

import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzh implements AdProgressInfo {
    private final double zza;
    private final double zzb;
    private final List zzc;
    private final int zzd;
    private final int zze;
    private final double zzf;
    private final double zzg;

    public zzh(double d2, double d3, int i2, int i3, double d4, double d5, List list) {
        this.zza = d2;
        this.zzb = d3;
        this.zzc = list;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = d4;
        this.zzg = d5;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getAdBreakDuration() {
        return this.zzf;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getAdPeriodDuration() {
        return this.zzg;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final int getAdPosition() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getCurrentTime() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getDuration() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final int getTotalAds() {
        return this.zze;
    }
}
