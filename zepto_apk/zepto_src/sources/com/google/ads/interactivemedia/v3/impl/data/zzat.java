package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzat extends zzcp {
    private final Integer height;
    private final Integer width;
    private final Integer x;
    private final Integer y;

    public zzat(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            throw new NullPointerException("Null x");
        }
        this.x = num;
        if (num2 == null) {
            throw new NullPointerException("Null y");
        }
        this.y = num2;
        if (num3 == null) {
            throw new NullPointerException("Null width");
        }
        this.width = num3;
        if (num4 == null) {
            throw new NullPointerException("Null height");
        }
        this.height = num4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcp) {
            zzcp zzcpVar = (zzcp) obj;
            if (this.x.equals(zzcpVar.x()) && this.y.equals(zzcpVar.y()) && this.width.equals(zzcpVar.width()) && this.height.equals(zzcpVar.height())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.x.hashCode() ^ 1000003) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.width.hashCode()) * 1000003) ^ this.height.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcp
    public Integer height() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcp
    public Integer width() {
        return this.width;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcp
    public Integer x() {
        return this.x;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcp
    public Integer y() {
        return this.y;
    }
}
