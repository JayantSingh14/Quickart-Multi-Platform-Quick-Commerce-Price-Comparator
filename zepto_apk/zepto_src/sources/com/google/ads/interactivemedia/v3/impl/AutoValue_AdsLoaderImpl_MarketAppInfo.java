package com.google.ads.interactivemedia.v3.impl;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class AutoValue_AdsLoaderImpl_MarketAppInfo extends zzs {
    private final int appVersion;
    private final String packageName;

    public AutoValue_AdsLoaderImpl_MarketAppInfo(int i2, String str) {
        this.appVersion = i2;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.packageName = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzs
    public int appVersion() {
        return this.appVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzs) {
            zzs zzsVar = (zzs) obj;
            if (this.appVersion == zzsVar.appVersion() && this.packageName.equals(zzsVar.packageName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.appVersion ^ 1000003) * 1000003) ^ this.packageName.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzs
    public String packageName() {
        return this.packageName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MarketAppInfo{appVersion=");
        sb.append(this.appVersion);
        sb.append(", packageName=");
        return b.r(sb, this.packageName, "}");
    }
}
