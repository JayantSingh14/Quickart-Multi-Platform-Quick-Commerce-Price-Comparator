package com.google.ads.interactivemedia.v3.impl;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class AutoValue_StreamVideoDisplay_TimedMetadataWithKeys extends zzbt {
    private final String TXXX;

    public AutoValue_StreamVideoDisplay_TimedMetadataWithKeys(String str) {
        if (str == null) {
            throw new NullPointerException("Null TXXX");
        }
        this.TXXX = str;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbt
    public String TXXX() {
        return this.TXXX;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbt) {
            return this.TXXX.equals(((zzbt) obj).TXXX());
        }
        return false;
    }

    public int hashCode() {
        return this.TXXX.hashCode() ^ 1000003;
    }

    public String toString() {
        return b.r(new StringBuilder("TimedMetadataWithKeys{TXXX="), this.TXXX, "}");
    }
}
