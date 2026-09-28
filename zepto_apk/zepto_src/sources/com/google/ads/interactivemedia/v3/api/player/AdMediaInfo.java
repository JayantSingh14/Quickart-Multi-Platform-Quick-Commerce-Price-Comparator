package com.google.ads.interactivemedia.v3.api.player;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes3.dex */
public class AdMediaInfo {
    private final String zza;

    @KeepForSdk
    public AdMediaInfo(@NonNull String str) {
        this.zza = str;
    }

    @NonNull
    public String getUrl() {
        return this.zza;
    }
}
