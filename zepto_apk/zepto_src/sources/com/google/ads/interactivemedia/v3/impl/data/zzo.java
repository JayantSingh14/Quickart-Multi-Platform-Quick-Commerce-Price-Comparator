package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzo extends zzbg {
    private int height;
    private int left;
    private byte set$0;
    private int top;
    private int width;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbg
    public zzbh build() {
        if (this.set$0 == 15) {
            return new zzq(this.left, this.top, this.height, this.width);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" left");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" top");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" height");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" width");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbg
    public zzbg height(int i2) {
        this.height = i2;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbg
    public zzbg left(int i2) {
        this.left = i2;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbg
    public zzbg top(int i2) {
        this.top = i2;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbg
    public zzbg width(int i2) {
        this.width = i2;
        this.set$0 = (byte) (this.set$0 | 8);
        return this;
    }
}
