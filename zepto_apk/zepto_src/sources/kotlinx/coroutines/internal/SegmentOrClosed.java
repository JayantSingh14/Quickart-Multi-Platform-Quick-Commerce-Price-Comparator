package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

@Metadata
@JvmInline
/* loaded from: classes.dex */
public final class SegmentOrClosed<S extends Segment<S>> {
    public static final Segment a(Object obj) {
        if (obj != ConcurrentLinkedListKt.f55062a) {
            return (Segment) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final boolean b(Object obj) {
        return obj == ConcurrentLinkedListKt.f55062a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SegmentOrClosed)) {
            return false;
        }
        ((SegmentOrClosed) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "SegmentOrClosed(value=null)";
    }
}
