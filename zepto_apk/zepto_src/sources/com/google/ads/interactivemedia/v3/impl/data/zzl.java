package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqk;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
final class zzl extends zzf {
    private int bitrate;
    private boolean disableUi;
    private boolean enableFocusSkipButton;
    private boolean enablePreloading;
    private int loadVideoTimeout;
    private zzqf<String> mimeTypes;
    private double playAdsAfterTime;
    private byte set$0;
    private zzqk<UiElement> uiElements;

    public zzl() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzg build() {
        if (this.set$0 == 63) {
            return new zzn(this.bitrate, this.mimeTypes, this.uiElements, this.enablePreloading, this.enableFocusSkipButton, this.playAdsAfterTime, this.disableUi, this.loadVideoTimeout);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" bitrate");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" enablePreloading");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" enableFocusSkipButton");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" playAdsAfterTime");
        }
        if ((this.set$0 & 16) == 0) {
            sb.append(" disableUi");
        }
        if ((this.set$0 & 32) == 0) {
            sb.append(" loadVideoTimeout");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setBitrate(int i2) {
        this.bitrate = i2;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setDisableUi(boolean z) {
        this.disableUi = z;
        this.set$0 = (byte) (this.set$0 | 16);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setEnableFocusSkipButton(boolean z) {
        this.enableFocusSkipButton = z;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setEnablePreloading(boolean z) {
        this.enablePreloading = z;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setLoadVideoTimeout(int i2) {
        this.loadVideoTimeout = i2;
        this.set$0 = (byte) (this.set$0 | 32);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setMimeTypes(@Nullable List<String> list) {
        this.mimeTypes = list == null ? null : zzqf.zzk(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setPlayAdsAfterTime(double d2) {
        this.playAdsAfterTime = d2;
        this.set$0 = (byte) (this.set$0 | 8);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzf
    public zzf setUiElements(@Nullable Set<UiElement> set) {
        this.uiElements = set == null ? null : zzqk.zzl(set);
        return this;
    }

    public zzl(zzg zzgVar) {
        this.bitrate = zzgVar.bitrate();
        this.mimeTypes = zzgVar.mimeTypes();
        this.uiElements = zzgVar.uiElements();
        this.enablePreloading = zzgVar.enablePreloading();
        this.enableFocusSkipButton = zzgVar.enableFocusSkipButton();
        this.playAdsAfterTime = zzgVar.playAdsAfterTime();
        this.disableUi = zzgVar.disableUi();
        this.loadVideoTimeout = zzgVar.loadVideoTimeout();
        this.set$0 = (byte) 63;
    }
}
