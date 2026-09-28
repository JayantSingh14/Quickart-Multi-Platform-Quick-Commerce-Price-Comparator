package com.google.ads.interactivemedia.v3.api.player;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public interface VideoStreamPlayer extends ContentProgressProvider, VolumeProvider {

    public interface VideoStreamPlayerCallback {
        void onContentComplete();

        void onPause();

        void onResume();

        void onUserTextReceived(@NonNull String str);

        void onVolumeChanged(int i2);
    }

    void addCallback(@NonNull VideoStreamPlayerCallback videoStreamPlayerCallback);

    void loadUrl(@NonNull String str, @NonNull List<HashMap<String, String>> list);

    void onAdBreakEnded();

    void onAdBreakStarted();

    void onAdPeriodEnded();

    void onAdPeriodStarted();

    void pause();

    void removeCallback(@NonNull VideoStreamPlayerCallback videoStreamPlayerCallback);

    void resume();

    void seek(long j2);
}
