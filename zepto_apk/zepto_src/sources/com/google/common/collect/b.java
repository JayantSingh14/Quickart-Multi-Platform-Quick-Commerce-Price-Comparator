package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectCollectors;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MoreCollectors;
import java.util.EnumSet;
import java.util.function.BiConsumer;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43168a;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f43168a) {
            case 0:
                CollectCollectors.EnumSetAccumulator enumSetAccumulator = (CollectCollectors.EnumSetAccumulator) obj;
                Enum r4 = (Enum) obj2;
                EnumSet enumSet = enumSetAccumulator.f42535a;
                if (enumSet != null) {
                    enumSet.add(r4);
                    break;
                } else {
                    enumSetAccumulator.f42535a = EnumSet.of(r4);
                    break;
                }
            case 1:
                ((MoreCollectors.ToOptionalState) obj).a(obj2);
                break;
            case 2:
                MoreCollectors.ToOptionalState toOptionalState = (MoreCollectors.ToOptionalState) obj;
                if (obj2 == null) {
                    obj2 = MoreCollectors.f42941a;
                } else {
                    Object obj3 = MoreCollectors.f42941a;
                }
                toOptionalState.a(obj2);
                break;
            case 3:
                ((ImmutableSet.Builder) obj).c(obj2);
                break;
            case 4:
                ImmutableRangeSet.Builder builder = (ImmutableRangeSet.Builder) obj;
                Range range = (Range) obj2;
                builder.getClass();
                Preconditions.h(!range.f(), "range must not be empty, but was %s", range);
                builder.f42718a.add(range);
                break;
            default:
                ((ImmutableList.Builder) obj).h(obj2);
                break;
        }
    }
}
