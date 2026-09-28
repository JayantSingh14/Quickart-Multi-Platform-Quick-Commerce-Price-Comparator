package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class zzh implements AdsRenderingSettings {
    private boolean enablePreloading;

    @Nullable
    private Set<UiElement> uiElements;
    private int bitrate = -1;

    @Nullable
    private List<String> mimeTypes = null;
    private boolean enableFocusSkipButton = true;
    private double playAdsAfterTime = -1.0d;
    private boolean disableUi = false;
    private boolean enableCustomTabs = false;
    private int loadVideoTimeout = -1;

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public int getBitrateKbps() {
        return this.bitrate;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public boolean getDisableUi() {
        return this.disableUi;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public boolean getEnableCustomTabs() {
        return this.enableCustomTabs;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public boolean getEnablePreloading() {
        return this.enablePreloading;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public boolean getFocusSkipButtonWhenAvailable() {
        return this.enableFocusSkipButton;
    }

    public int getLoadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public List<String> getMimeTypes() {
        return this.mimeTypes;
    }

    public double getPlayAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    public Set<UiElement> getUiElements() {
        return this.uiElements;
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setBitrateKbps(int i2) {
        this.bitrate = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setDisableUi(boolean z) {
        this.disableUi = z;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setEnableCustomTabs(boolean z) {
        this.enableCustomTabs = z;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setEnablePreloading(boolean z) {
        this.enablePreloading = z;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setFocusSkipButtonWhenAvailable(boolean z) {
        this.enableFocusSkipButton = z;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setLoadVideoTimeout(int i2) {
        this.loadVideoTimeout = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setMimeTypes(List<String> list) {
        this.mimeTypes = list;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setPlayAdsAfterTime(double d2) {
        this.playAdsAfterTime = d2;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsRenderingSettings
    public void setUiElements(Set<UiElement> set) {
        this.uiElements = set;
    }
}
