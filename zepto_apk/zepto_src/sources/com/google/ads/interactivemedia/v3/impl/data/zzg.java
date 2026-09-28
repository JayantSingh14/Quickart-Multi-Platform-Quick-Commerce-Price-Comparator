package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzoo;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqk;
import javax.annotation.Nullable;

@zzoo(zza = zzn.class)
/* loaded from: classes3.dex */
public abstract class zzg {
    public static zzf builder(AdsRenderingSettings adsRenderingSettings) {
        zzh zzhVar = (zzh) adsRenderingSettings;
        zzl zzlVar = new zzl();
        zzlVar.setBitrate(zzhVar.getBitrateKbps());
        zzlVar.setDisableUi(zzhVar.getDisableUi());
        zzlVar.setEnablePreloading(zzhVar.getEnablePreloading());
        zzlVar.setEnableFocusSkipButton(zzhVar.getFocusSkipButtonWhenAvailable());
        zzlVar.setLoadVideoTimeout(zzhVar.getLoadVideoTimeout());
        zzlVar.setMimeTypes(zzhVar.getMimeTypes());
        zzlVar.setPlayAdsAfterTime(zzhVar.getPlayAdsAfterTime());
        zzlVar.setUiElements(zzhVar.getUiElements());
        return zzlVar;
    }

    public abstract int bitrate();

    public abstract boolean disableUi();

    public abstract boolean enableFocusSkipButton();

    public abstract boolean enablePreloading();

    public abstract int loadVideoTimeout();

    @Nullable
    public abstract zzqf<String> mimeTypes();

    public abstract double playAdsAfterTime();

    public abstract zzf toBuilder();

    @Nullable
    public abstract zzqk<UiElement> uiElements();
}
