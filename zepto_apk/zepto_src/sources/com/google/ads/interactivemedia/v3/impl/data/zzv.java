package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzv extends zzbn {
    private final String androidVersion;
    private final String manufacturer;
    private final String model;
    private final int requestCounter;
    private final String sdkVersion;

    private zzv(String str, String str2, String str3, String str4, int i2) {
        this.model = str;
        this.manufacturer = str2;
        this.sdkVersion = str3;
        this.androidVersion = str4;
        this.requestCounter = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbn
    public String androidVersion() {
        return this.androidVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbn) {
            zzbn zzbnVar = (zzbn) obj;
            if (this.model.equals(zzbnVar.model()) && this.manufacturer.equals(zzbnVar.manufacturer()) && this.sdkVersion.equals(zzbnVar.sdkVersion()) && this.androidVersion.equals(zzbnVar.androidVersion()) && this.requestCounter == zzbnVar.requestCounter()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.model.hashCode() ^ 1000003) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.sdkVersion.hashCode()) * 1000003) ^ this.androidVersion.hashCode()) * 1000003) ^ this.requestCounter;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbn
    public String manufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbn
    public String model() {
        return this.model;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbn
    public int requestCounter() {
        return this.requestCounter;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbn
    public String sdkVersion() {
        return this.sdkVersion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EventTimestampMetadata{model=");
        sb.append(this.model);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", sdkVersion=");
        sb.append(this.sdkVersion);
        sb.append(", androidVersion=");
        sb.append(this.androidVersion);
        sb.append(", requestCounter=");
        return b.o(sb, this.requestCounter, "}");
    }
}
