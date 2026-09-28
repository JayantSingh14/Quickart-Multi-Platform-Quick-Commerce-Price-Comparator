package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzav extends zzcr {
    private final int major;
    private final int micro;
    private final int minor;

    public zzav(int i2, int i3, int i4) {
        this.major = i2;
        this.minor = i3;
        this.micro = i4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcr) {
            zzcr zzcrVar = (zzcr) obj;
            if (this.major == zzcrVar.major() && this.minor == zzcrVar.minor() && this.micro == zzcrVar.micro()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.major ^ 1000003) * 1000003) ^ this.minor) * 1000003) ^ this.micro;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcr
    public int major() {
        return this.major;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcr
    public int micro() {
        return this.micro;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzcr
    public int minor() {
        return this.minor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SecureSignalsVersionData{major=");
        sb.append(this.major);
        sb.append(", minor=");
        sb.append(this.minor);
        sb.append(", micro=");
        return b.o(sb, this.micro, "}");
    }
}
