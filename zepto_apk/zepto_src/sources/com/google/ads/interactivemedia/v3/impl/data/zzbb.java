package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzbb extends zzcu {
    private final long currentTime;
    private final long duration;
    private final String timeUnit;

    public zzbb(long j2, long j3, String str) {
        this.currentTime = j2;
        this.duration = j3;
        if (str == null) {
            throw new NullPointerException("Null timeUnit");
        }
        this.timeUnit = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcu
    public long currentTime() {
        return this.currentTime;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcu
    public long duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcu) {
            zzcu zzcuVar = (zzcu) obj;
            if (this.currentTime == zzcuVar.currentTime() && this.duration == zzcuVar.duration() && this.timeUnit.equals(zzcuVar.timeUnit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.duration;
        long j3 = this.currentTime;
        return ((((int) (j2 ^ (j2 >>> 32))) ^ ((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003)) * 1000003) ^ this.timeUnit.hashCode();
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcu
    public String timeUnit() {
        return this.timeUnit;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TimeUpdateData{currentTime=");
        sb.append(this.currentTime);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", timeUnit=");
        return b.r(sb, this.timeUnit, "}");
    }
}
