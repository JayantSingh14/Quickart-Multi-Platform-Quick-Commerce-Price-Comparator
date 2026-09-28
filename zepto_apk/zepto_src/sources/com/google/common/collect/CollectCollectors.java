package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.EnumSet;
import java.util.stream.Collector;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@IgnoreJRERequirement
/* loaded from: classes4.dex */
final class CollectCollectors {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f42534a = 0;

    @J2ktIncompatible
    @IgnoreJRERequirement
    public static class EnumMapAccumulator<K extends Enum<K>, V> {
    }

    @IgnoreJRERequirement
    public static final class EnumSetAccumulator<E extends Enum<E>> {

        /* renamed from: a, reason: collision with root package name */
        public EnumSet f42535a;

        static {
            int i2 = CollectCollectors.f42534a;
            Collector.of(new a(0), new b(0), new c(0), new d(0), Collector.Characteristics.UNORDERED);
        }
    }

    static {
        Collector.of(new a(4), new b(5), new c(1), new d(5), new Collector.Characteristics[0]);
        Collector.of(new a(2), new b(3), new c(3), new d(4), new Collector.Characteristics[0]);
        Collector.of(new a(3), new b(4), new c(4), new d(1), new Collector.Characteristics[0]);
    }
}
