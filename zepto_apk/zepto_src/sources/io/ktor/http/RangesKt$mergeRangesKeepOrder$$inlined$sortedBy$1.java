package io.ktor.http;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.LongRange;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.a(Long.valueOf(((LongRange) obj).f53848a), Long.valueOf(((LongRange) obj2).f53848a));
    }
}
