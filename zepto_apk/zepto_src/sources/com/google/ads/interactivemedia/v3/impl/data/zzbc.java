package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
final class zzbc extends zzcy {

    @Nullable
    private final Integer downloadBandwidthKbps;
    private final boolean rendersUiNatively;

    public zzbc(@Nullable Integer num, boolean z) {
        this.downloadBandwidthKbps = num;
        this.rendersUiNatively = z;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcy
    @Nullable
    public Integer downloadBandwidthKbps() {
        return this.downloadBandwidthKbps;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcy) {
            zzcy zzcyVar = (zzcy) obj;
            Integer num = this.downloadBandwidthKbps;
            if (num != null ? num.equals(zzcyVar.downloadBandwidthKbps()) : zzcyVar.downloadBandwidthKbps() == null) {
                if (this.rendersUiNatively == zzcyVar.rendersUiNatively()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.downloadBandwidthKbps;
        return (((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ (true != this.rendersUiNatively ? 1237 : 1231);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcy
    public boolean rendersUiNatively() {
        return this.rendersUiNatively;
    }

    public String toString() {
        return "VideoEnvironmentData{downloadBandwidthKbps=" + this.downloadBandwidthKbps + ", rendersUiNatively=" + this.rendersUiNatively + "}";
    }
}
