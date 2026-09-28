package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return a().equals(((RangeSet) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
