package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.signals.SecureSignals;
import com.google.ads.interactivemedia.v3.internal.zzef;

/* loaded from: classes3.dex */
public interface BaseRequest {
    @NonNull
    String getContentUrl();

    @Nullable
    SecureSignals getSecureSignals();

    @NonNull
    Object getUserRequestContext();

    void setContentUrl(@NonNull String str);

    void setSecureSignals(@Nullable SecureSignals secureSignals);

    void setUserRequestContext(@NonNull Object obj);

    zzef zza();
}
