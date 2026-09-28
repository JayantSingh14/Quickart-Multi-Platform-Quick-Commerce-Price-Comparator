package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.api.CompanionAd;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;

/* loaded from: classes3.dex */
public final class zzbi implements CompanionAd {

    @Nullable
    private String apiFramework;

    @Nullable
    private String resourceValue;
    private zzcs size = zzcs.create(0, 0);

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.v3.api.CompanionAd
    public String getApiFramework() {
        return this.apiFramework;
    }

    @Override // com.google.ads.interactivemedia.v3.api.CompanionAd
    public int getHeight() {
        return this.size.height().intValue();
    }

    @Override // com.google.ads.interactivemedia.v3.api.CompanionAd
    public String getResourceValue() {
        return this.resourceValue;
    }

    @Override // com.google.ads.interactivemedia.v3.api.CompanionAd
    public int getWidth() {
        return this.size.width().intValue();
    }

    public int hashCode() {
        return zzagk.zza(this, new String[0]);
    }

    @VisibleForTesting
    public void setApiFramework(String str) {
        this.apiFramework = str;
    }

    @VisibleForTesting
    public void setResourceValue(String str) {
        this.resourceValue = str;
    }

    @VisibleForTesting
    public void setSize(zzcs zzcsVar) {
        this.size = zzcsVar;
    }

    public String toString() {
        String str = this.apiFramework;
        String str2 = this.resourceValue;
        Integer numWidth = this.size.width();
        Integer numHeight = this.size.height();
        StringBuilder sbV = e.v("CompanionAd [apiFramework=", str, ", resourceUrl=", str2, ", width=");
        sbV.append(numWidth);
        sbV.append(", height=");
        sbV.append(numHeight);
        sbV.append("]");
        return sbV.toString();
    }
}
