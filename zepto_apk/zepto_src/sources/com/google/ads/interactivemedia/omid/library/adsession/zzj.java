package com.google.ads.interactivemedia.omid.library.adsession;

import com.google.ads.interactivemedia.v3.internal.zzcy;

/* loaded from: classes3.dex */
public final class zzj {
    private final String zza = "Google1";
    private final String zzb = "3.33.0";

    private zzj(String str, String str2) {
    }

    public static zzj zza(String str, String str2) {
        zzcy.zza("Google1", "Name is null or empty");
        zzcy.zza("3.33.0", "Version is null or empty");
        return new zzj("Google1", "3.33.0");
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
