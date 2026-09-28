package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.a;
import java.util.List;

/* loaded from: classes3.dex */
final class zzad extends zzbt {
    private final String alternateText;
    private final int duration;
    private final List<zzbs> fallbackImages;
    private final int height;
    private final int id;
    private final String imageUrl;
    private final int offset;
    private final double pixelRatio;
    private final int width;
    private final String xPosition;
    private final String yPosition;

    public zzad(int i2, int i3, int i4, double d2, String str, String str2, int i5, int i6, String str3, String str4, List<zzbs> list) {
        this.id = i2;
        this.width = i3;
        this.height = i4;
        this.pixelRatio = d2;
        if (str == null) {
            throw new NullPointerException("Null xPosition");
        }
        this.xPosition = str;
        if (str2 == null) {
            throw new NullPointerException("Null yPosition");
        }
        this.yPosition = str2;
        this.offset = i5;
        this.duration = i6;
        if (str3 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.imageUrl = str3;
        if (str4 == null) {
            throw new NullPointerException("Null alternateText");
        }
        this.alternateText = str4;
        if (list == null) {
            throw new NullPointerException("Null fallbackImages");
        }
        this.fallbackImages = list;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public String alternateText() {
        return this.alternateText;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public int duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbt) {
            zzbt zzbtVar = (zzbt) obj;
            if (this.id == zzbtVar.id() && this.width == zzbtVar.width() && this.height == zzbtVar.height() && Double.doubleToLongBits(this.pixelRatio) == Double.doubleToLongBits(zzbtVar.pixelRatio()) && this.xPosition.equals(zzbtVar.xPosition()) && this.yPosition.equals(zzbtVar.yPosition()) && this.offset == zzbtVar.offset() && this.duration == zzbtVar.duration() && this.imageUrl.equals(zzbtVar.imageUrl()) && this.alternateText.equals(zzbtVar.alternateText()) && this.fallbackImages.equals(zzbtVar.fallbackImages())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public List<zzbs> fallbackImages() {
        return this.fallbackImages;
    }

    public int hashCode() {
        long jDoubleToLongBits = (Double.doubleToLongBits(this.pixelRatio) >>> 32) ^ Double.doubleToLongBits(this.pixelRatio);
        int i2 = (int) jDoubleToLongBits;
        return ((((((((((((((i2 ^ ((((((this.id ^ 1000003) * 1000003) ^ this.width) * 1000003) ^ this.height) * 1000003)) * 1000003) ^ this.xPosition.hashCode()) * 1000003) ^ this.yPosition.hashCode()) * 1000003) ^ this.offset) * 1000003) ^ this.duration) * 1000003) ^ this.imageUrl.hashCode()) * 1000003) ^ this.alternateText.hashCode()) * 1000003) ^ this.fallbackImages.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public int height() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public int id() {
        return this.id;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public String imageUrl() {
        return this.imageUrl;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public int offset() {
        return this.offset;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public double pixelRatio() {
        return this.pixelRatio;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.fallbackImages);
        StringBuilder sb = new StringBuilder("IconData{id=");
        sb.append(this.id);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", pixelRatio=");
        sb.append(this.pixelRatio);
        sb.append(", xPosition=");
        sb.append(this.xPosition);
        sb.append(", yPosition=");
        sb.append(this.yPosition);
        sb.append(", offset=");
        sb.append(this.offset);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", alternateText=");
        return a.n(sb, this.alternateText, ", fallbackImages=", strValueOf, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public int width() {
        return this.width;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public String xPosition() {
        return this.xPosition;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbt
    public String yPosition() {
        return this.yPosition;
    }
}
