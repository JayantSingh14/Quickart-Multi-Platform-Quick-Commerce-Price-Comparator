package kotlin.collections;

import android.support.v4.media.b;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class SlidingWindowKt {
    public static final void a(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException((i2 != i3 ? b.e(i2, i3, "Both size ", " and step ", " must be greater than zero.") : b.g(i2, "size ", " must be greater than zero.")).toString());
        }
    }
}
