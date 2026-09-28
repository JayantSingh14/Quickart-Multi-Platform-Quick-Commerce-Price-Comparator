package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface AdsManagerLoadedEvent {
    @NonNull
    AdsManager getAdsManager();

    @NonNull
    StreamManager getStreamManager();

    @NonNull
    Object getUserRequestContext();
}
