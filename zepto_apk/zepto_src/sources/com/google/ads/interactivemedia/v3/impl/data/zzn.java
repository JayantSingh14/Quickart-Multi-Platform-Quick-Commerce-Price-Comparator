package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqk;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
final class zzn extends zzg {
    private final int bitrate;
    private final boolean disableUi;
    private final boolean enableFocusSkipButton;
    private final boolean enablePreloading;
    private final int loadVideoTimeout;

    @Nullable
    private final zzqf<String> mimeTypes;
    private final double playAdsAfterTime;

    @Nullable
    private final zzqk<UiElement> uiElements;

    private zzn(int i2, @Nullable zzqf<String> zzqfVar, @Nullable zzqk<UiElement> zzqkVar, boolean z, boolean z2, double d2, boolean z3, int i3) {
        this.bitrate = i2;
        this.mimeTypes = zzqfVar;
        this.uiElements = zzqkVar;
        this.enablePreloading = z;
        this.enableFocusSkipButton = z2;
        this.playAdsAfterTime = d2;
        this.disableUi = z3;
        this.loadVideoTimeout = i3;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public int bitrate() {
        return this.bitrate;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public boolean disableUi() {
        return this.disableUi;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public boolean enableFocusSkipButton() {
        return this.enableFocusSkipButton;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public boolean enablePreloading() {
        return this.enablePreloading;
    }

    public boolean equals(Object obj) {
        zzqf<String> zzqfVar;
        zzqk<UiElement> zzqkVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzg) {
            zzg zzgVar = (zzg) obj;
            if (this.bitrate == zzgVar.bitrate() && ((zzqfVar = this.mimeTypes) != null ? zzqfVar.equals(zzgVar.mimeTypes()) : zzgVar.mimeTypes() == null) && ((zzqkVar = this.uiElements) != null ? zzqkVar.equals(zzgVar.uiElements()) : zzgVar.uiElements() == null) && this.enablePreloading == zzgVar.enablePreloading() && this.enableFocusSkipButton == zzgVar.enableFocusSkipButton() && Double.doubleToLongBits(this.playAdsAfterTime) == Double.doubleToLongBits(zzgVar.playAdsAfterTime()) && this.disableUi == zzgVar.disableUi() && this.loadVideoTimeout == zzgVar.loadVideoTimeout()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzqf<String> zzqfVar = this.mimeTypes;
        int iHashCode = zzqfVar == null ? 0 : zzqfVar.hashCode();
        int i2 = this.bitrate;
        zzqk<UiElement> zzqkVar = this.uiElements;
        return ((((((((((((iHashCode ^ ((i2 ^ 1000003) * 1000003)) * 1000003) ^ (zzqkVar != null ? zzqkVar.hashCode() : 0)) * 1000003) ^ (true != this.enablePreloading ? 1237 : 1231)) * 1000003) ^ (true != this.enableFocusSkipButton ? 1237 : 1231)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.playAdsAfterTime) >>> 32) ^ Double.doubleToLongBits(this.playAdsAfterTime)))) * 1000003) ^ (true != this.disableUi ? 1237 : 1231)) * 1000003) ^ this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public int loadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    @Nullable
    public zzqf<String> mimeTypes() {
        return this.mimeTypes;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public double playAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    public zzf toBuilder() {
        return new zzl(this);
    }

    public String toString() {
        zzqk<UiElement> zzqkVar = this.uiElements;
        String strValueOf = String.valueOf(this.mimeTypes);
        String strValueOf2 = String.valueOf(zzqkVar);
        StringBuilder sb = new StringBuilder("AdsRenderingSettingsData{bitrate=");
        sb.append(this.bitrate);
        sb.append(", mimeTypes=");
        sb.append(strValueOf);
        sb.append(", uiElements=");
        sb.append(strValueOf2);
        sb.append(", enablePreloading=");
        sb.append(this.enablePreloading);
        sb.append(", enableFocusSkipButton=");
        sb.append(this.enableFocusSkipButton);
        sb.append(", playAdsAfterTime=");
        sb.append(this.playAdsAfterTime);
        sb.append(", disableUi=");
        sb.append(this.disableUi);
        sb.append(", loadVideoTimeout=");
        return b.o(sb, this.loadVideoTimeout, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzg
    @Nullable
    public zzqk<UiElement> uiElements() {
        return this.uiElements;
    }
}
