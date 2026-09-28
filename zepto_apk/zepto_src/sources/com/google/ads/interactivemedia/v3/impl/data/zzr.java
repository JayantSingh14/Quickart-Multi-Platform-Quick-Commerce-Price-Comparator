package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzr extends zzbk {
    private final String clickThroughUrl;
    private final String size;
    private final String src;
    private final zzbj type;

    public zzr(String str, String str2, String str3, zzbj zzbjVar) {
        if (str == null) {
            throw new NullPointerException("Null size");
        }
        this.size = str;
        if (str2 == null) {
            throw new NullPointerException("Null src");
        }
        this.src = str2;
        if (str3 == null) {
            throw new NullPointerException("Null clickThroughUrl");
        }
        this.clickThroughUrl = str3;
        if (zzbjVar == null) {
            throw new NullPointerException("Null type");
        }
        this.type = zzbjVar;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbk
    public String clickThroughUrl() {
        return this.clickThroughUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbk) {
            zzbk zzbkVar = (zzbk) obj;
            if (this.size.equals(zzbkVar.size()) && this.src.equals(zzbkVar.src()) && this.clickThroughUrl.equals(zzbkVar.clickThroughUrl()) && this.type.equals(zzbkVar.type())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.src.hashCode()) * 1000003) ^ this.clickThroughUrl.hashCode()) * 1000003) ^ this.type.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbk
    public String size() {
        return this.size;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbk
    public String src() {
        return this.src;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbk
    public zzbj type() {
        return this.type;
    }
}
