package com.google.ads.interactivemedia.v3.impl;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* loaded from: classes3.dex */
public final class zzd implements AdErrorEvent {
    private final AdError zza;

    @Nullable
    private final Object zzb;

    public zzd(AdError adError) {
        this.zza = adError;
        this.zzb = null;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent
    public final AdError getError() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent
    public final Object getUserRequestContext() {
        return this.zzb;
    }

    public final String toString() {
        return "AdErrorEvent: [error=" + this.zza + "]";
    }

    public zzd(AdError adError, Object obj) {
        this.zza = adError;
        this.zzb = obj;
    }
}
