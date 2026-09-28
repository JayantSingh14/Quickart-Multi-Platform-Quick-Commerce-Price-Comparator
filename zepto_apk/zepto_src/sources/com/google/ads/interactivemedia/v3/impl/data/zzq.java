package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzq extends zzbh {
    private final int height;
    private final int left;
    private final int top;
    private final int width;

    private zzq(int i2, int i3, int i4, int i5) {
        this.left = i2;
        this.top = i3;
        this.height = i4;
        this.width = i5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbh) {
            zzbh zzbhVar = (zzbh) obj;
            if (this.left == zzbhVar.left() && this.top == zzbhVar.top() && this.height == zzbhVar.height() && this.width == zzbhVar.width()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.left ^ 1000003) * 1000003) ^ this.top) * 1000003) ^ this.height) * 1000003) ^ this.width;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbh
    public int height() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbh
    public int left() {
        return this.left;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BoundingRectData{left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", width=");
        return b.o(sb, this.width, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbh
    public int top() {
        return this.top;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbh
    public int width() {
        return this.width;
    }
}
