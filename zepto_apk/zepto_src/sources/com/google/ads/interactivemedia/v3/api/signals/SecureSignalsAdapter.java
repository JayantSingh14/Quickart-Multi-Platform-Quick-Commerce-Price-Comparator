package com.google.ads.interactivemedia.v3.api.signals;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.ads.interactivemedia.v3.api.VersionInfo;

/* loaded from: classes3.dex */
public interface SecureSignalsAdapter {
    void collectSignals(@NonNull Context context, @NonNull SecureSignalsCollectSignalsCallback secureSignalsCollectSignalsCallback);

    @NonNull
    VersionInfo getSDKVersion();

    @NonNull
    VersionInfo getVersion();

    void initialize(@NonNull Context context, @NonNull SecureSignalsInitializeCallback secureSignalsInitializeCallback);
}
