package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzk extends zzb {
    private final String appState;
    private final String eventId;
    private final long nativeTime;
    private final zzbh nativeViewBounds;
    private final boolean nativeViewHidden;
    private final zzbh nativeViewVisibleBounds;
    private final double nativeVolume;
    private final String queryId;

    private zzk(String str, String str2, String str3, long j2, double d2, boolean z, zzbh zzbhVar, zzbh zzbhVar2) {
        this.queryId = str;
        this.eventId = str2;
        this.appState = str3;
        this.nativeTime = j2;
        this.nativeVolume = d2;
        this.nativeViewHidden = z;
        this.nativeViewBounds = zzbhVar;
        this.nativeViewVisibleBounds = zzbhVar2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public String appState() {
        return this.appState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzb) {
            zzb zzbVar = (zzb) obj;
            if (this.queryId.equals(zzbVar.queryId()) && this.eventId.equals(zzbVar.eventId()) && this.appState.equals(zzbVar.appState()) && this.nativeTime == zzbVar.nativeTime() && Double.doubleToLongBits(this.nativeVolume) == Double.doubleToLongBits(zzbVar.nativeVolume()) && this.nativeViewHidden == zzbVar.nativeViewHidden() && this.nativeViewBounds.equals(zzbVar.nativeViewBounds()) && this.nativeViewVisibleBounds.equals(zzbVar.nativeViewVisibleBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public String eventId() {
        return this.eventId;
    }

    public int hashCode() {
        int iHashCode = ((((this.queryId.hashCode() ^ 1000003) * 1000003) ^ this.eventId.hashCode()) * 1000003) ^ this.appState.hashCode();
        long jDoubleToLongBits = (Double.doubleToLongBits(this.nativeVolume) >>> 32) ^ Double.doubleToLongBits(this.nativeVolume);
        int i2 = true != this.nativeViewHidden ? 1237 : 1231;
        long j2 = this.nativeTime;
        return (((((((((iHashCode * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) jDoubleToLongBits)) * 1000003) ^ i2) * 1000003) ^ this.nativeViewBounds.hashCode()) * 1000003) ^ this.nativeViewVisibleBounds.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public long nativeTime() {
        return this.nativeTime;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public zzbh nativeViewBounds() {
        return this.nativeViewBounds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public boolean nativeViewHidden() {
        return this.nativeViewHidden;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public zzbh nativeViewVisibleBounds() {
        return this.nativeViewVisibleBounds;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public double nativeVolume() {
        return this.nativeVolume;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzb
    public String queryId() {
        return this.queryId;
    }

    public String toString() {
        zzbh zzbhVar = this.nativeViewVisibleBounds;
        String strValueOf = String.valueOf(this.nativeViewBounds);
        String strValueOf2 = String.valueOf(zzbhVar);
        StringBuilder sb = new StringBuilder("ActivityMonitorData{queryId=");
        sb.append(this.queryId);
        sb.append(", eventId=");
        sb.append(this.eventId);
        sb.append(", appState=");
        sb.append(this.appState);
        sb.append(", nativeTime=");
        sb.append(this.nativeTime);
        sb.append(", nativeVolume=");
        sb.append(this.nativeVolume);
        sb.append(", nativeViewHidden=");
        sb.append(this.nativeViewHidden);
        sb.append(", nativeViewBounds=");
        sb.append(strValueOf);
        sb.append(", nativeViewVisibleBounds=");
        return b.r(sb, strValueOf2, "}");
    }
}
