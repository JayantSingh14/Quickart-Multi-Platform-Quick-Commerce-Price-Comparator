package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.util.Arrays;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class BloomFilter<T> implements Predicate<T>, Serializable {

    public static class SerialForm<T> implements Serializable {
    }

    public interface Strategy extends Serializable {
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        throw null;
    }

    @Override // com.google.common.base.Predicate
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        ((BloomFilter) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{0, null, null, null});
    }
}
