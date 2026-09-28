package androidx.collection;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class LongLongPair {
    public final boolean equals(Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        longLongPair.getClass();
        longLongPair.getClass();
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(0L) ^ Long.hashCode(0L);
    }

    public final String toString() {
        return "(0, 0)";
    }
}
