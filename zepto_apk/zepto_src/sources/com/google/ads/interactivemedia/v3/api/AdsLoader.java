package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* loaded from: classes3.dex */
public interface AdsLoader {

    public interface AdsLoadedListener {
        void onAdsManagerLoaded(@NonNull AdsManagerLoadedEvent adsManagerLoadedEvent);
    }

    void addAdErrorListener(@NonNull AdErrorEvent.AdErrorListener adErrorListener);

    void addAdsLoadedListener(@NonNull AdsLoadedListener adsLoadedListener);

    @Deprecated
    void contentComplete();

    @NonNull
    ImaSdkSettings getSettings();

    void release();

    void removeAdErrorListener(@NonNull AdErrorEvent.AdErrorListener adErrorListener);

    void removeAdsLoadedListener(@NonNull AdsLoadedListener adsLoadedListener);

    void requestAds(@NonNull AdsRequest adsRequest);

    @NonNull
    String requestStream(@NonNull StreamRequest streamRequest);
}
