package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.internal.zzqf;

/* loaded from: classes3.dex */
final class zzap extends zzco {
    private final zzqf<zzcn> obstructions;

    private zzap(zzqf<zzcn> zzqfVar) {
        this.obstructions = zzqfVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzco) {
            return this.obstructions.equals(((zzco) obj).obstructions());
        }
        return false;
    }

    public int hashCode() {
        return this.obstructions.hashCode() ^ 1000003;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzco
    public zzqf<zzcn> obstructions() {
        return this.obstructions;
    }

    public String toString() {
        return b.D("ObstructionListData{obstructions=", String.valueOf(this.obstructions), "}");
    }
}
