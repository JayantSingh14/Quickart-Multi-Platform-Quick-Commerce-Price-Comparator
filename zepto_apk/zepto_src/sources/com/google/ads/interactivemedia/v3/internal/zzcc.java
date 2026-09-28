package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.omid.library.adsession.FriendlyObstructionPurpose;

/* loaded from: classes3.dex */
public final class zzcc {
    private final zzdp zza;
    private final String zzb;
    private final FriendlyObstructionPurpose zzc;
    private final String zzd;

    public zzcc(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.zza = new zzdp(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = friendlyObstructionPurpose;
        this.zzd = str;
    }

    public final FriendlyObstructionPurpose zza() {
        return this.zzc;
    }

    public final zzdp zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
