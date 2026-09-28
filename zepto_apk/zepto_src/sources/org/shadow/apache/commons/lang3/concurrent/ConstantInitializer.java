package org.shadow.apache.commons.lang3.concurrent;

import org.shadow.apache.commons.lang3.ObjectUtils;

/* loaded from: classes5.dex */
public class ConstantInitializer<T> implements ConcurrentInitializer<T> {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConstantInitializer)) {
            return false;
        }
        ((ConstantInitializer) obj).getClass();
        return ObjectUtils.a(null, null);
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return String.format("ConstantInitializer@%d [ object = %s ]", Integer.valueOf(System.identityHashCode(this)), "null");
    }
}
