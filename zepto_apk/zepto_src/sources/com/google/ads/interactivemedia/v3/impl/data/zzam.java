package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzam extends zzck {
    private final String content;
    private final String contentType;
    private final int errorCode;
    private final String id;

    public zzam(String str, String str2, String str3, int i2) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.id = str;
        if (str2 == null) {
            throw new NullPointerException("Null content");
        }
        this.content = str2;
        if (str3 == null) {
            throw new NullPointerException("Null contentType");
        }
        this.contentType = str3;
        this.errorCode = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzck
    public String content() {
        return this.content;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzck
    public String contentType() {
        return this.contentType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzck) {
            zzck zzckVar = (zzck) obj;
            if (this.id.equals(zzckVar.id()) && this.content.equals(zzckVar.content()) && this.contentType.equals(zzckVar.contentType()) && this.errorCode == zzckVar.errorCode()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzck
    public int errorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        return ((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.contentType.hashCode()) * 1000003) ^ this.errorCode;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzck
    public String id() {
        return this.id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponseData{id=");
        sb.append(this.id);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", errorCode=");
        return b.o(sb, this.errorCode, "}");
    }
}
