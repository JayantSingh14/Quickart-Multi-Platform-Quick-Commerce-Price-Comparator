package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ComparisonsKt extends ComparisonsKt___ComparisonsKt {
    public static int a(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static int b(Comparable comparable, Comparable comparable2, Function1... selectors) {
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (Function1 function1 : selectors) {
            int iA = a((Comparable) function1.invoke(comparable), (Comparable) function1.invoke(comparable2));
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }

    public static Comparator c() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.f53675a;
        Intrinsics.d(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return naturalOrderComparator;
    }

    public static Comparator d() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.f53676a;
        Intrinsics.d(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return reverseOrderComparator;
    }
}
