package com.google.ads.interactivemedia.pal;

import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
enum zzr {
    CORRELATOR("c"),
    EVENT_ID("lid"),
    LOGGER_ID(CLConstants.SHARED_PREFERENCE_ITEM_ID),
    PALV("palv"),
    SDKV("sdkv");

    private final String zzg;

    zzr(String str) {
        this.zzg = str;
    }

    public final String zza() {
        return this.zzg;
    }
}
