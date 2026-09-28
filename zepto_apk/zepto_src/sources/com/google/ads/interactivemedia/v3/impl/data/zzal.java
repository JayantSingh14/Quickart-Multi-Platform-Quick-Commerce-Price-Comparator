package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
final class zzal extends zzcj {
    private final int connectionTimeoutMs;

    @Nullable
    private final String content;
    private final String id;
    private final int readTimeoutMs;
    private final zzci requestType;
    private final String url;
    private final String userAgent;

    public zzal(zzci zzciVar, String str, String str2, @Nullable String str3, String str4, int i2, int i3) {
        if (zzciVar == null) {
            throw new NullPointerException("Null requestType");
        }
        this.requestType = zzciVar;
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.id = str;
        if (str2 == null) {
            throw new NullPointerException("Null url");
        }
        this.url = str2;
        this.content = str3;
        if (str4 == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.userAgent = str4;
        this.connectionTimeoutMs = i2;
        this.readTimeoutMs = i3;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    public int connectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    @Nullable
    public String content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcj) {
            zzcj zzcjVar = (zzcj) obj;
            if (this.requestType.equals(zzcjVar.requestType()) && this.id.equals(zzcjVar.id()) && this.url.equals(zzcjVar.url()) && ((str = this.content) != null ? str.equals(zzcjVar.content()) : zzcjVar.content() == null) && this.userAgent.equals(zzcjVar.userAgent()) && this.connectionTimeoutMs == zzcjVar.connectionTimeoutMs() && this.readTimeoutMs == zzcjVar.readTimeoutMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.requestType.hashCode() ^ 1000003) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.url.hashCode();
        String str = this.content;
        return (((((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.userAgent.hashCode()) * 1000003) ^ this.connectionTimeoutMs) * 1000003) ^ this.readTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    public String id() {
        return this.id;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    public int readTimeoutMs() {
        return this.readTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    public zzci requestType() {
        return this.requestType;
    }

    public String toString() {
        StringBuilder sbY = b.y("NetworkRequestData{requestType=", String.valueOf(this.requestType), ", id=");
        sbY.append(this.id);
        sbY.append(", url=");
        sbY.append(this.url);
        sbY.append(", content=");
        sbY.append(this.content);
        sbY.append(", userAgent=");
        sbY.append(this.userAgent);
        sbY.append(", connectionTimeoutMs=");
        sbY.append(this.connectionTimeoutMs);
        sbY.append(", readTimeoutMs=");
        return b.o(sbY, this.readTimeoutMs, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    public String url() {
        return this.url;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcj
    public String userAgent() {
        return this.userAgent;
    }
}
