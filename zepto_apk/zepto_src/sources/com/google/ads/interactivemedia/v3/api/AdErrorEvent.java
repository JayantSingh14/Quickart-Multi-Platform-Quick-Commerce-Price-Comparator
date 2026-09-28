package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface AdErrorEvent {

    /* loaded from: classes.dex */
    public interface AdErrorListener {
        void onAdError(@NonNull AdErrorEvent adErrorEvent);
    }

    @NonNull
    AdError getError();

    @NonNull
    Object getUserRequestContext();
}
