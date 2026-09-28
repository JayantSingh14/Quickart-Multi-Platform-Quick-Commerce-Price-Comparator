package androidx.privacysandbox.ads.adservices.common;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;

@Metadata
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes3.dex */
public final class AdFilters {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdFilters)) {
            return false;
        }
        ((AdFilters) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "AdFilters: frequencyCapFilters=null";
    }
}
