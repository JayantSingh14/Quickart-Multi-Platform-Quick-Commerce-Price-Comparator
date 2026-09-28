package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FloatFloatPair {
    public final boolean equals(Object obj) {
        if (!(obj instanceof FloatFloatPair)) {
            return false;
        }
        ((FloatFloatPair) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(0L);
    }

    public final String toString() {
        return "(" + Float.intBitsToFloat((int) 0) + ", " + Float.intBitsToFloat((int) 0) + ')';
    }
}
