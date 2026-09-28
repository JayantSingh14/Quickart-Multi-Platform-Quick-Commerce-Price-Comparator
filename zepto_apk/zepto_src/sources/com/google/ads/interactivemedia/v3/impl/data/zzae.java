package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import java.util.List;

/* loaded from: classes3.dex */
final class zzae extends zzbu {
    private final List<zzbt> icons;

    public zzae(List<zzbt> list) {
        if (list == null) {
            throw new NullPointerException("Null icons");
        }
        this.icons = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbu) {
            return this.icons.equals(((zzbu) obj).icons());
        }
        return false;
    }

    public int hashCode() {
        return this.icons.hashCode() ^ 1000003;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbu
    public List<zzbt> icons() {
        return this.icons;
    }

    public String toString() {
        return b.D("IconsViewData{icons=", String.valueOf(this.icons), "}");
    }
}
