package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectCollectors;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MoreCollectors;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements BinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43169a;

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f43169a) {
            case 0:
                CollectCollectors.EnumSetAccumulator enumSetAccumulator = (CollectCollectors.EnumSetAccumulator) obj;
                CollectCollectors.EnumSetAccumulator enumSetAccumulator2 = (CollectCollectors.EnumSetAccumulator) obj2;
                EnumSet enumSet = enumSetAccumulator.f42535a;
                if (enumSet == null) {
                    return enumSetAccumulator2;
                }
                EnumSet enumSet2 = enumSetAccumulator2.f42535a;
                if (enumSet2 == null) {
                    return enumSetAccumulator;
                }
                enumSet.addAll(enumSet2);
                return enumSetAccumulator;
            case 1:
                ImmutableList.Builder builder = (ImmutableList.Builder) obj;
                ImmutableList.Builder builder2 = (ImmutableList.Builder) obj2;
                builder.getClass();
                builder.d(builder2.f42658b, builder2.f42657a);
                return builder;
            case 2:
                MoreCollectors.ToOptionalState toOptionalState = (MoreCollectors.ToOptionalState) obj;
                MoreCollectors.ToOptionalState toOptionalState2 = (MoreCollectors.ToOptionalState) obj2;
                if (toOptionalState.f42942a == null) {
                    return toOptionalState2;
                }
                if (toOptionalState2.f42942a == null) {
                    return toOptionalState;
                }
                if (toOptionalState.f42943b.isEmpty()) {
                    toOptionalState.f42943b = new ArrayList();
                }
                toOptionalState.f42943b.add(toOptionalState2.f42942a);
                toOptionalState.f42943b.addAll(toOptionalState2.f42943b);
                if (toOptionalState.f42943b.size() <= 4) {
                    return toOptionalState;
                }
                List list = toOptionalState.f42943b;
                list.subList(4, list.size()).clear();
                toOptionalState.b(true);
                throw null;
            case 3:
                return ((ImmutableSet.Builder) obj).l((ImmutableSet.Builder) obj2);
            default:
                ImmutableRangeSet.Builder builder3 = (ImmutableRangeSet.Builder) obj;
                builder3.getClass();
                Iterator it = ((ImmutableRangeSet.Builder) obj2).f42718a.iterator();
                while (it.hasNext()) {
                    Range range = (Range) it.next();
                    Preconditions.h(!range.f(), "range must not be empty, but was %s", range);
                    builder3.f42718a.add(range);
                }
                return builder3;
        }
    }
}
