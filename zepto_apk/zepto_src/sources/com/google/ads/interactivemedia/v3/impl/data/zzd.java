package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzd implements AdPodInfo {
    public int podIndex;
    public double timeOffset;
    public int totalAds = 1;
    public int adPosition = 1;
    public boolean isBumper = false;
    public double maxDuration = -1.0d;
    public List<Long> adsDurationsMs = new ArrayList();

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdPodInfo
    public int getAdPosition() {
        return this.adPosition;
    }

    public List<Long> getAdsDurationsMs() {
        return this.adsDurationsMs;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdPodInfo
    public double getMaxDuration() {
        return this.maxDuration;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdPodInfo
    public int getPodIndex() {
        return this.podIndex;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdPodInfo
    public double getTimeOffset() {
        return this.timeOffset;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdPodInfo
    public int getTotalAds() {
        return this.totalAds;
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdPodInfo
    public boolean isBumper() {
        return this.isBumper;
    }

    public String toString() {
        int i2 = this.totalAds;
        int i3 = this.adPosition;
        boolean z = this.isBumper;
        double d2 = this.maxDuration;
        String strValueOf = String.valueOf(this.adsDurationsMs);
        int i4 = this.podIndex;
        double d3 = this.timeOffset;
        StringBuilder sbT = b.t(i2, i3, "AdPodInfo [totalAds=", ", adPosition=", ", isBumper=");
        sbT.append(z);
        sbT.append(", maxDuration=");
        sbT.append(d2);
        sbT.append(", adsDurationsMs=");
        sbT.append(strValueOf);
        sbT.append(", podIndex=");
        sbT.append(i4);
        sbT.append(", timeOffset=");
        sbT.append(d3);
        sbT.append("]");
        return sbT.toString();
    }
}
