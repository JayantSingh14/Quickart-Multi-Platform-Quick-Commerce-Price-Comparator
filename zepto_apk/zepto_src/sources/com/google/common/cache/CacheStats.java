package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class CacheStats {
    public final boolean equals(Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        ((CacheStats) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{0L, 0L, 0L, 0L, 0L, 0L});
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        toStringHelperB.b("hitCount");
        toStringHelperB.b("missCount");
        toStringHelperB.b("loadSuccessCount");
        toStringHelperB.b("loadExceptionCount");
        toStringHelperB.b("totalLoadTime");
        toStringHelperB.b("evictionCount");
        return toStringHelperB.toString();
    }
}
