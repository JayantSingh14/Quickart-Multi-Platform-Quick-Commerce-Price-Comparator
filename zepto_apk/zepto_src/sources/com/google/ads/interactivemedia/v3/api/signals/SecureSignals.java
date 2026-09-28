package com.google.ads.interactivemedia.v3.api.signals;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class SecureSignals {
    private final String zza;

    private SecureSignals(String str) {
        this.zza = str;
    }

    @NonNull
    public static SecureSignals create(@NonNull String str) {
        return new SecureSignals(str);
    }

    @NonNull
    public String getSecureSignal() {
        return this.zza;
    }
}
