package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzafj extends RuntimeException {
    public zzafj(zzadz zzadzVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzacz zza() {
        return new zzacz(getMessage());
    }
}
