package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectCollectors;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.MoreCollectors;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43170a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f43170a) {
            case 0:
                CollectCollectors.EnumSetAccumulator enumSetAccumulator = (CollectCollectors.EnumSetAccumulator) obj;
                EnumSet enumSet = enumSetAccumulator.f42535a;
                if (enumSet == null) {
                    int i2 = ImmutableSet.f42719c;
                    return RegularImmutableSet.f43033j;
                }
                int i3 = ImmutableEnumSet.f42662f;
                int size = enumSet.size();
                Object immutableEnumSet = size != 0 ? size != 1 ? new ImmutableEnumSet(enumSet) : new SingletonImmutableSet((Enum) Iterables.d(enumSet)) : RegularImmutableSet.f43033j;
                enumSetAccumulator.f42535a = null;
                return immutableEnumSet;
            case 1:
                ArrayList arrayList = ((ImmutableRangeSet.Builder) obj).f42718a;
                ImmutableList.Builder builder = new ImmutableList.Builder(arrayList.size());
                Range range = Range.f42992c;
                Collections.sort(arrayList, Range.RangeLexOrdering.f42997a);
                PeekingIterator peekingIteratorJ = Iterators.j(arrayList.iterator());
                while (peekingIteratorJ.hasNext()) {
                    Range range2 = (Range) peekingIteratorJ.next();
                    while (peekingIteratorJ.hasNext()) {
                        Range range3 = (Range) ((Iterators.PeekingImpl) peekingIteratorJ).a();
                        if (range2.e(range3)) {
                            Preconditions.d(range2, range3, "Overlapping ranges not permitted but found %s overlapping %s", range2.d(range3).f());
                            Range range4 = (Range) peekingIteratorJ.next();
                            Cut cut = range4.f42993a;
                            Cut cut2 = range2.f42993a;
                            int iCompareTo = cut2.compareTo(cut);
                            Cut cut3 = range2.f42994b;
                            Cut cut4 = range4.f42994b;
                            int iCompareTo2 = cut3.compareTo(cut4);
                            if (iCompareTo > 0 || iCompareTo2 < 0) {
                                if (iCompareTo < 0 || iCompareTo2 > 0) {
                                    if (iCompareTo > 0) {
                                        cut2 = range4.f42993a;
                                    }
                                    if (iCompareTo2 < 0) {
                                        cut3 = cut4;
                                    }
                                    range2 = new Range(cut2, cut3);
                                } else {
                                    range2 = range4;
                                }
                            }
                        }
                    }
                    builder.h(range2);
                }
                ImmutableList immutableListJ = builder.j();
                return immutableListJ.isEmpty() ? ImmutableRangeSet.f42704b : (((RegularImmutableList) immutableListJ).f43012d == 1 && ((Range) Iterables.d(immutableListJ)).equals(Range.f42992c)) ? ImmutableRangeSet.f42705c : new ImmutableRangeSet(immutableListJ);
            case 2:
                MoreCollectors.ToOptionalState toOptionalState = (MoreCollectors.ToOptionalState) obj;
                if (toOptionalState.f42943b.isEmpty()) {
                    return Optional.ofNullable(toOptionalState.f42942a);
                }
                toOptionalState.b(false);
                throw null;
            case 3:
                MoreCollectors.ToOptionalState toOptionalState2 = (MoreCollectors.ToOptionalState) obj;
                Object obj2 = MoreCollectors.f42941a;
                if (toOptionalState2.f42942a == null) {
                    throw new NoSuchElementException();
                }
                if (!toOptionalState2.f42943b.isEmpty()) {
                    toOptionalState2.b(false);
                    throw null;
                }
                Object obj3 = toOptionalState2.f42942a;
                if (obj3 == MoreCollectors.f42941a) {
                    return null;
                }
                return obj3;
            case 4:
                return ((ImmutableSet.Builder) obj).k();
            default:
                return ((ImmutableList.Builder) obj).j();
        }
    }
}
