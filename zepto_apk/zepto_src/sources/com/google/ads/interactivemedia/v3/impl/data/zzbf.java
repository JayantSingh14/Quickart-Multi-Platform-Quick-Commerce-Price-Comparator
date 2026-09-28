package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzbf extends zzda {
    private final float volume;

    private zzbf(float f2) {
        this.volume = f2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zzda) && Float.floatToIntBits(this.volume) == Float.floatToIntBits(((zzda) obj).volume());
    }

    public int hashCode() {
        return Float.floatToIntBits(this.volume) ^ 1000003;
    }

    public String toString() {
        return "VolumeUpdateData{volume=" + this.volume + "}";
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzda
    public float volume() {
        return this.volume;
    }
}
