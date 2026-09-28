package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;

@Metadata
/* loaded from: classes3.dex */
public final class RangeKt$toClosedRange$1 implements ClosedRange<Comparable<Object>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Range<Comparable<Object>> f2994a;

    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return this.f2994a.getLower();
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return this.f2994a.getUpper();
    }
}
