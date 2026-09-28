package com.google.ads.interactivemedia.v3.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public interface AdsRenderingSettings {
    int getBitrateKbps();

    @KeepForSdk
    boolean getDisableUi();

    boolean getEnableCustomTabs();

    boolean getEnablePreloading();

    boolean getFocusSkipButtonWhenAvailable();

    @NonNull
    List<String> getMimeTypes();

    void setBitrateKbps(int i2);

    @KeepForSdk
    void setDisableUi(boolean z);

    void setEnableCustomTabs(boolean z);

    void setEnablePreloading(boolean z);

    void setFocusSkipButtonWhenAvailable(boolean z);

    void setLoadVideoTimeout(int i2);

    void setMimeTypes(@NonNull List<String> list);

    void setPlayAdsAfterTime(double d2);

    void setUiElements(@NonNull Set<UiElement> set);
}
