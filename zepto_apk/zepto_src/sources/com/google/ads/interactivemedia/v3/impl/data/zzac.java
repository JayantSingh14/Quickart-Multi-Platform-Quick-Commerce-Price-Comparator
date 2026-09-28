package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzac extends zzbs {
    private final String alternateText;
    private final String creativeType;
    private final int height;
    private final String imageUrl;
    private final int width;

    public zzac(int i2, int i3, String str, String str2, String str3) {
        this.width = i2;
        this.height = i3;
        if (str == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.imageUrl = str;
        if (str2 == null) {
            throw new NullPointerException("Null alternateText");
        }
        this.alternateText = str2;
        if (str3 == null) {
            throw new NullPointerException("Null creativeType");
        }
        this.creativeType = str3;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbs
    public String alternateText() {
        return this.alternateText;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbs
    public String creativeType() {
        return this.creativeType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbs) {
            zzbs zzbsVar = (zzbs) obj;
            if (this.width == zzbsVar.width() && this.height == zzbsVar.height() && this.imageUrl.equals(zzbsVar.imageUrl()) && this.alternateText.equals(zzbsVar.alternateText()) && this.creativeType.equals(zzbsVar.creativeType())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.width ^ 1000003) * 1000003) ^ this.height) * 1000003) ^ this.imageUrl.hashCode()) * 1000003) ^ this.alternateText.hashCode()) * 1000003) ^ this.creativeType.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbs
    public int height() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbs
    public String imageUrl() {
        return this.imageUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbs
    public int width() {
        return this.width;
    }
}
