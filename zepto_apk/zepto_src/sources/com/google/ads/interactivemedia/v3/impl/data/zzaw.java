package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzaw extends zzcs {
    private final Integer height;
    private final Integer width;

    public zzaw(Integer num, Integer num2) {
        if (num == null) {
            throw new NullPointerException("Null width");
        }
        this.width = num;
        if (num2 == null) {
            throw new NullPointerException("Null height");
        }
        this.height = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcs) {
            zzcs zzcsVar = (zzcs) obj;
            if (this.width.equals(zzcsVar.width()) && this.height.equals(zzcsVar.height())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.width.hashCode() ^ 1000003) * 1000003) ^ this.height.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcs
    public Integer height() {
        return this.height;
    }

    public String toString() {
        return "SizeData{width=" + this.width + ", height=" + this.height + "}";
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcs
    public Integer width() {
        return this.width;
    }
}
