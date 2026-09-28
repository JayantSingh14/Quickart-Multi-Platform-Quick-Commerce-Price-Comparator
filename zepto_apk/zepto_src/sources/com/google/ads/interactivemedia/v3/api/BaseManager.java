package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.player.AdProgressProvider;

/* loaded from: classes3.dex */
public interface BaseManager extends AdProgressProvider {
    void addAdErrorListener(@NonNull AdErrorEvent.AdErrorListener adErrorListener);

    void addAdEventListener(@NonNull AdEvent.AdEventListener adEventListener);

    void destroy();

    void focus();

    @NonNull
    AdProgressInfo getAdProgressInfo();

    @NonNull
    Ad getCurrentAd();

    void init();

    void init(@NonNull AdsRenderingSettings adsRenderingSettings);

    @Deprecated
    boolean isCustomPlaybackUsed();

    void removeAdErrorListener(@NonNull AdErrorEvent.AdErrorListener adErrorListener);

    void removeAdEventListener(@NonNull AdEvent.AdEventListener adEventListener);
}
