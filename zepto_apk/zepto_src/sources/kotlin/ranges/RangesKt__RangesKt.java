package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes.dex */
class RangesKt__RangesKt {
    public static final void a(boolean z, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }
}
