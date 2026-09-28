package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
final class zzaf extends zzbv {
    private final String adsIdentityToken;
    private final String appSetId;
    private final int appSetIdScope;

    @Nullable
    private final String deviceId;
    private final String idType;
    private final boolean isLimitedAdTracking;

    public zzaf(@Nullable String str, String str2, boolean z, String str3, int i2, String str4) {
        this.deviceId = str;
        if (str2 == null) {
            throw new NullPointerException("Null idType");
        }
        this.idType = str2;
        this.isLimitedAdTracking = z;
        if (str3 == null) {
            throw new NullPointerException("Null appSetId");
        }
        this.appSetId = str3;
        this.appSetIdScope = i2;
        if (str4 == null) {
            throw new NullPointerException("Null adsIdentityToken");
        }
        this.adsIdentityToken = str4;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbv
    public String adsIdentityToken() {
        return this.adsIdentityToken;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbv
    public String appSetId() {
        return this.appSetId;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbv
    public int appSetIdScope() {
        return this.appSetIdScope;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbv
    @Nullable
    public String deviceId() {
        return this.deviceId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbv) {
            zzbv zzbvVar = (zzbv) obj;
            String str = this.deviceId;
            if (str != null ? str.equals(zzbvVar.deviceId()) : zzbvVar.deviceId() == null) {
                if (this.idType.equals(zzbvVar.idType()) && this.isLimitedAdTracking == zzbvVar.isLimitedAdTracking() && this.appSetId.equals(zzbvVar.appSetId()) && this.appSetIdScope == zzbvVar.appSetIdScope() && this.adsIdentityToken.equals(zzbvVar.adsIdentityToken())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.deviceId;
        return (((((((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.idType.hashCode()) * 1000003) ^ (true != this.isLimitedAdTracking ? 1237 : 1231)) * 1000003) ^ this.appSetId.hashCode()) * 1000003) ^ this.appSetIdScope) * 1000003) ^ this.adsIdentityToken.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbv
    public String idType() {
        return this.idType;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbv
    public boolean isLimitedAdTracking() {
        return this.isLimitedAdTracking;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdentifierInfo{deviceId=");
        sb.append(this.deviceId);
        sb.append(", idType=");
        sb.append(this.idType);
        sb.append(", isLimitedAdTracking=");
        sb.append(this.isLimitedAdTracking);
        sb.append(", appSetId=");
        sb.append(this.appSetId);
        sb.append(", appSetIdScope=");
        sb.append(this.appSetIdScope);
        sb.append(", adsIdentityToken=");
        return b.r(sb, this.adsIdentityToken, "}");
    }
}
