package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: classes3.dex */
public enum FriendlyObstructionPurpose {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;

    @NonNull
    @KeepForSdk
    public com.google.ads.interactivemedia.omid.library.adsession.FriendlyObstructionPurpose getOmidPurpose() {
        return (com.google.ads.interactivemedia.omid.library.adsession.FriendlyObstructionPurpose) Enum.valueOf(com.google.ads.interactivemedia.omid.library.adsession.FriendlyObstructionPurpose.class, name());
    }
}
