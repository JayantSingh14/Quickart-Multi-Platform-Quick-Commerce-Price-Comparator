package kotlin.collections;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: classes.dex */
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final int d(int i2, List list) {
        if (i2 >= 0 && i2 <= CollectionsKt.B(list)) {
            return CollectionsKt.B(list) - i2;
        }
        StringBuilder sbU = b.u(i2, "Element index ", " must be in range [");
        sbU.append(new IntRange(0, CollectionsKt.B(list), 1));
        sbU.append("].");
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    public static final int e(int i2, List list) {
        if (i2 >= 0 && i2 <= list.size()) {
            return list.size() - i2;
        }
        StringBuilder sbU = b.u(i2, "Position index ", " must be in range [");
        sbU.append(new IntRange(0, list.size(), 1));
        sbU.append("].");
        throw new IndexOutOfBoundsException(sbU.toString());
    }
}
