package com.google.common.collect;

import com.google.common.collect.CollectCollectors;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MoreCollectors;
import java.util.Collections;
import java.util.function.Supplier;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43167a;

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f43167a) {
            case 0:
                int i2 = CollectCollectors.f42534a;
                return new CollectCollectors.EnumSetAccumulator();
            case 1:
                MoreCollectors.ToOptionalState toOptionalState = new MoreCollectors.ToOptionalState();
                toOptionalState.f42942a = null;
                toOptionalState.f42943b = Collections.EMPTY_LIST;
                return toOptionalState;
            case 2:
                int i3 = ImmutableSet.f42719c;
                return new ImmutableSet.Builder();
            case 3:
                ImmutableRangeSet immutableRangeSet = ImmutableRangeSet.f42704b;
                return new ImmutableRangeSet.Builder();
            default:
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                return new ImmutableList.Builder();
        }
    }
}
