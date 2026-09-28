package org.shadow.apache.commons.lang3.mutable;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class MutableBoolean implements Mutable<Boolean>, Serializable, Comparable<MutableBoolean> {
    @Override // java.lang.Comparable
    public final int compareTo(MutableBoolean mutableBoolean) {
        mutableBoolean.getClass();
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MutableBoolean)) {
            return false;
        }
        ((MutableBoolean) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Boolean.FALSE.hashCode();
    }

    public final String toString() {
        return String.valueOf(false);
    }
}
