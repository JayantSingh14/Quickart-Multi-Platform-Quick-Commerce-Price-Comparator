package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzbd extends zzcz {
    private byte set$0;
    private float volume;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcz
    public zzda build() {
        if (this.set$0 == 1) {
            return new zzbf(this.volume);
        }
        throw new IllegalStateException("Missing required properties: volume");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcz
    public zzcz volume(float f2) {
        this.volume = f2;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }
}
