package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final class VersionInfo {
    private final int zza;
    private final int zzb;
    private final int zzc;

    public VersionInfo(int i2, int i3, int i4) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
    }

    public int getMajorVersion() {
        return this.zza;
    }

    public int getMicroVersion() {
        return this.zzc;
    }

    public int getMinorVersion() {
        return this.zzb;
    }

    @NonNull
    public String toString() {
        return this.zza + CLConstants.DOT_SALT_DELIMETER + this.zzb + CLConstants.DOT_SALT_DELIMETER + this.zzc;
    }
}
